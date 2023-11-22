package com.example.bookProject.service;
import java.util.List;

import com.example.bookProject.entity.Hospital;

public interface HospitalService {
	
	Hospital saveHospital (Hospital hospital);
	Hospital updateHospital (Hospital hospital, int hospitalId);
	void  deleteHospital (int hospitalId);
	 List<Hospital> getAllHospitalNames() ;
		// TODO Auto-generated method stub
		
	

}
