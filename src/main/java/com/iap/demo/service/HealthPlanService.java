package com.iap.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iap.demo.entity.HealthPlan;
import com.iap.demo.repository.HealthPlanRepo;

@Service 
public class HealthPlanService {
	
	@Autowired
	HealthPlanRepo healthPlanRepo;
	
	public List<HealthPlan> getPlans() throws Exception
	{
		if(healthPlanRepo.count() == 0)
		{
			throw new Exception("Plans not found");
		}
		else
		{
			return healthPlanRepo.findAll();
		}
	}
	
	public HealthPlan getHealthPlanById(int planId) throws Exception
	{
		if(!(healthPlanRepo.findById(planId).isPresent()))
		{
			throw new Exception("Could not find plan with id - " +planId);
		}
		else
		{
			return healthPlanRepo.findById(planId).get();
		}
	}
	
	public HealthPlan addPlan(HealthPlan newHealthPlan) throws Exception
	{
		if(healthPlanRepo.findById(newHealthPlan.getId()).isPresent())
		{
			throw new Exception("Plan already found with id - " +newHealthPlan.getId());
		}
		else {
			return healthPlanRepo.save(newHealthPlan);
		}
	}
	
	/*
	 * public HealthPlan updatePlan(HealthPlan healthPlan) { return
	 * healthPlanRepo.save(healthPlan); }
	 */
	
	public HealthPlan updateHealthPlanById(int planId, HealthPlan updHealthPlan) throws Exception
	{
		if(healthPlanRepo.findById(planId).isPresent())
		{
			HealthPlan existingHealthPlan = healthPlanRepo.findById(planId).get();
			if(updHealthPlan.getInsuranceCompany() == null || updHealthPlan.getInsuranceCompany().isEmpty())
				updHealthPlan.setInsuranceCompany(existingHealthPlan.getInsuranceCompany());
			if(updHealthPlan.getPlanName() == null || updHealthPlan.getPlanName().isEmpty())
				updHealthPlan.setPlanName(existingHealthPlan.getPlanName());
			if(updHealthPlan.getPlanType() == null || updHealthPlan.getPlanType().isEmpty())
				updHealthPlan.setPlanType(existingHealthPlan.getPlanType());
			if(updHealthPlan.getSumInsured() == 0 )
				updHealthPlan.setSumInsured(existingHealthPlan.getSumInsured());
				
			updHealthPlan.setId(planId);
			return healthPlanRepo.save(updHealthPlan);
		}
		else
		{
			throw new Exception("Could not find plan with id - " +planId);
		}
	}
	
	public void deletePlanById(int planId) throws Exception
	{
		if(healthPlanRepo.findById(planId).isPresent())
		{
			healthPlanRepo.deleteById(planId);
		}
		else
		{
			throw new Exception("Could not find plan with id - " +planId);
		}
	}
	
	public void deletePlan() throws Exception
	{
		if(healthPlanRepo.count() == 0)
		{
			throw new Exception("Plans not found");
		}
		else
		{
			healthPlanRepo.deleteAll();
			
		}
	}

}
