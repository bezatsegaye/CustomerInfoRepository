package miu.edu.start.job.applicationprocessor.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import miu.edu.start.job.applicationprocessor.exception.CompanyNotFoundException;

@ControllerAdvice
class EmployeeNotFoundAdvice {
	
  @ResponseBody
 // @ExceptionHandler(CompanyNotFoundException.class)
  @ResponseStatus(code=HttpStatus.NOT_FOUND) 
  String employeeNotFoundHandler(CompanyNotFoundException ex) {
    return ex.getMessage();
  }
}