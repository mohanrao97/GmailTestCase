package com.ty.assiagnment.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Inbox implements Serializable {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private String msg;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private Account account;
}
