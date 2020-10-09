package miu.edu.start.job.applicationprocessor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Board {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;


}
