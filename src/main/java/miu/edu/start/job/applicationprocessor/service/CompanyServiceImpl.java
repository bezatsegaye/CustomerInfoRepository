package miu.edu.start.job.applicationprocessor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miu.edu.start.job.applicationprocessor.domain.Company;
import miu.edu.start.job.applicationprocessor.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company getCompanyByName(String name) {
		return companyRepository.findByName(name);
	}
	@Override
	public Company getbyid(long id) {
		return companyRepository.findById(id).orElse(null);
	}
	@Override
	public Company add(Company company) {
		return companyRepository.save(company);
	}
	
	@Override
	public List<Company> listAll() {
		return companyRepository.findAll();
	}
	@Override
	public void delete(long id) {
		companyRepository.deleteById(id);
	}
	
	
}
