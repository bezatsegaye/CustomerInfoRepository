package miu.edu.start.job.applicationprocessor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import miu.edu.start.job.applicationprocessor.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByName(String name);
	
	 
}
