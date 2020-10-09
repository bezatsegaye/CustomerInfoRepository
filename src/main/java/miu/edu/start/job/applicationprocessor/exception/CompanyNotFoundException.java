package miu.edu.start.job.applicationprocessor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.compiler.CompileError;

@ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason ="Actor Not Found")
public class CompanyNotFoundException extends RuntimeException {

//public	CompanyNotFoundException() {
//	    super("Could not find employee ");
//	  }
}
