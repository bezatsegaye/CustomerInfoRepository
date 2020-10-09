package miu.edu.start.job.applicationprocessor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import miu.edu.start.job.applicationprocessor.domain.Company;


public interface CompanyService {
	Company getCompanyByName(String name);
	Company getbyid(long id);
	Company add(Company company);
	List<Company> listAll();
	void delete(long id);

}
