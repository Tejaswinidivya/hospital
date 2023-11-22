package com.example.bookProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookProject.entity.Hospital;
import com.example.bookProject.repo.HospitalRepo;
import com.example.bookProject.service.HospitalService;



@Controller
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	@Autowired
	HospitalRepo hospitalRepo;
	@PostMapping("/Post")
	public Hospital saveBook(@RequestBody Hospital hospital){
	      return  hospitalService.saveHospital(hospital);
		
	}
	
	@PutMapping("/Update")
	public Hospital updateHospital(@RequestHeader int id, @RequestBody Hospital hospital)
	{
	
 return hospitalService.updateHospital(hospital, id);

}
	@DeleteMapping("/Delete")
public String deleteHospital(@RequestHeader  int id)
{
	hospitalService.deleteHospital(id);
	return "the record is deleted";
}
	
	
	//display list of hospitals
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listHospital",hospitalRepo.findAll());
		return "index";
	}
	
	@GetMapping("/showNewHospitalForm")
	public String showNewhospitalForm(Model model) {
		//create model attribute to bind form data
		Hospital hospital=new Hospital();
		model.addAttribute("hospital", hospital);
		return "createHospital";
	}
	
	@PostMapping("/saveHospital")
	public String savehospital(@ModelAttribute("hospital") Hospital hospital){
		//save hospital to database
		hospitalService.saveHospital(hospital);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id,Model model ) {
		//get hospital from the service
		Hospital hospital=hospitalRepo.findById(id);
		
		//set hospital as a model attribute to pre-populate the form
		model.addAttribute("hospital", hospital);
		return "updateHospital";
	}
	
	@GetMapping("/deletehospital/{id}")
	public String deletehospital(@PathVariable (value="id") int id) {
		Hospital hospital=hospitalRepo.findById(id);

		//call delete hospital method
		this.hospitalRepo.delete(hospital);
		return "redirect:/";
	}

	
}
