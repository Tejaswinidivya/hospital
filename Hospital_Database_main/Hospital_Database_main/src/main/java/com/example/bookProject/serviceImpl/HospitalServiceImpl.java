package com.example.bookProject.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookProject.entity.Hospital;
import com.example.bookProject.repo.HospitalRepo;
import com.example.bookProject.service.HospitalService;
@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	HospitalRepo hospitalRepo;
	@Override
	
	public Hospital saveHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalRepo.save(hospital);
		
	}

	@Override
	public Hospital updateHospital(Hospital hospital, int hospitalId) {
		// TODO Auto-generated method stub
		Hospital hosp=hospitalRepo.findById(hospitalId);
		if(hosp!=null)
		{
			hosp.setHospitalName(hosp.getHospitalName());
			hosp.setPatientAddress(hosp.getPatientAddress());
	
		
		}
		return hospitalRepo.save(hosp);
		
		

	}

	@Override
	public void deleteHospital(int hospitalId) {
		// TODO Auto-generated method stub
		Hospital hosp=hospitalRepo.findById(hospitalId);
		if(hosp!=null)
		{
			hospitalRepo.deleteById(hospitalId);
		}
		
		
	}

	@Override
	public List<Hospital> getAllHospitalNames() {
		return hospitalRepo.findAll();
		// TODO Auto-generated method stub
		
	}

}
