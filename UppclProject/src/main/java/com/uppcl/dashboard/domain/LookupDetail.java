package com.uppcl.dashboard.domain;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "lookupDetail")
public class LookupDetail extends AbstractAuditingEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name = "Name", nullable = false,length=50)
	private String Name;
	
	@Column(name = "Code", nullable = true,length=50 )
	private String Code;
	
	@Column(name = "parentId", nullable = true,length=50)
	private int parentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "lookupId",
            nullable = false
    )
    private LookUp lookUpId;

}
