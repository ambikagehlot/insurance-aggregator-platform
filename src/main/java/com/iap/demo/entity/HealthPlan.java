package com.iap.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity  
@Table(name = "health_plan")

public class HealthPlan {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")  
	private int id;
	
	@Column(name = "insurance_company")
	private String insuranceCompany;
	
	@Column(name = "plan_name")
	private String planName;
	
	@Column(name = "plan_type")
	private String planType;
	
	@Column(name = "sum_insured")
	private long sumInsured;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public long getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(long sumInsured) {
		this.sumInsured = sumInsured;
	}
	
	
	
}
