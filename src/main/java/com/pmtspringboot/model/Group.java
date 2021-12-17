package com.pmtspringboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "group_tbl")
@Data
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int groupId;
	private String groupName;
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "group_fk1")
	private List<Account> account;
	
}
