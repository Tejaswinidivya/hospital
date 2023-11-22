package com.example.bookProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.bookProject.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
	@Query(value =  "select * from Hospital where id =?" , nativeQuery = true) 
	Hospital findById(int hospitalId); //spring data repository method
	//
	

}
