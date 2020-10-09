package miu.edu.start.job.applicationprocessor.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

import com.sun.istack.internal.NotNull;

import lombok.Data;

@Entity
public @Data class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//@NotNull
	@Size(min = 10, max = 30)
	private String name;
	private String country;
	//@NotNull
	@Size(min = 10, max = 30)
	private String city;
//	@Temporal(TemporalType.DATE)
//	private LocalDate createdDate;
//	@Temporal(TemporalType.TIME)
//	private LocalTime createdTime;	
	
}
