package miu.edu.start.job.applicationprocessor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import miu.edu.start.job.applicationprocessor.ApplicationProcessorApplication;
import miu.edu.start.job.applicationprocessor.domain.Company;
import miu.edu.start.job.applicationprocessor.exception.CompanyNotFoundException;
import miu.edu.start.job.applicationprocessor.repository.CompanyRepository;
import miu.edu.start.job.applicationprocessor.service.CompanyService;

@Controller
@RequestMapping("/home")
public class CompanyController {

	@Autowired
	private CompanyService companyService; 
	
	@Autowired
	private ApplicationProcessorApplication ap;

	@GetMapping(params = {"name"})
	public String displayCompany(@RequestParam String name, Model model) {
		Company com =  companyService.getCompanyByName(name);
		model.addAttribute("com", ap.personService());
		return "greeting";
		
	}
	
	@GetMapping("/list")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}

    @GetMapping
   // @ResponseStatus(HttpStatus.CREATED)
   // @ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason = "Some parameters are invalid"
    public String recordJob( Company company, BindingResult  bindResult, Model model) {
    	if(bindResult.hasErrors()) {
    		return "errorForm";
    	}
//    	throw new ResponseStatusException(
//    	          HttpStatus.NOT_FOUND, "Actor Not Found");
    	    
        model.addAttribute("newCompany",company);
        return "jobTracking";
    	
    }
    
	@PostMapping("/add")
	public String add(@Valid Company company, BindingResult  bindResult, Model model) {
		if(bindResult.hasErrors())
		{
			return "errorForm";
		}
		 companyService.add(company);
	     model.addAttribute("newCompany",companyService.getbyid(company.getId()));
	      return "redirect:/home/view";
	}
	
	@GetMapping("/view")
	public String ViewCompany(Model model) {
		model.addAttribute("ViewCompany", companyService.listAll());
		return "jobs";
	}
	@GetMapping("/delete/{id}")
	public String DeleteCompany(@PathVariable(value = "id") Long id, Model model) {
		companyService.delete(id);
		model.addAttribute("ViewCompany", companyService.listAll());
		return "jobs";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("company", companyService.getbyid(id));
		return "update";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable long id, Company company, Model model) {
		companyService.delete(id);
		companyService.add(company);
		model.addAttribute("company",companyService.listAll());
		return "redirect:/home/view";
	}
}
