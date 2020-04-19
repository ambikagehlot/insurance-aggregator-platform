package com.iap.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.iap.demo.entity.HealthPlan;
import com.iap.demo.service.HealthPlanService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HealthPlanController {
	
	@Autowired 
	HealthPlanService healthPlanService;
	
	@GetMapping("/healthPlan")
	public List<HealthPlan> getPlans() throws Exception{
		return healthPlanService.getPlans(); 
	}
	
	@GetMapping("/healthPlan/{planId}")
	public HealthPlan getHealthPlanById(@PathVariable("planId") int planId) throws Exception{
		return healthPlanService.getHealthPlanById(planId);
	}
	
	@PostMapping("/healthPlan/addPlan")
	public HealthPlan addPlan(@RequestBody HealthPlan newHealthPlan) throws Exception
	{
		return healthPlanService.addPlan(newHealthPlan);
				
	}
	
	/*
	 * @PutMapping("healthPlan/updatePlan") public HealthPlan
	 * updateEmployee(@RequestBody HealthPlan healthPlan) { return
	 * healthPlanService.updatePlan(healthPlan); }
	 */
	
	@PutMapping("healthPlan/updatePlanById/{planId}")
	public HealthPlan updateHealthPlanById(@PathVariable("planId") int planId, @RequestBody HealthPlan healthPlan) throws Exception
	{
		return healthPlanService.updateHealthPlanById(planId, healthPlan);
	}
	
	@DeleteMapping("healthPlan/deletePlanById/{planId}") 
	public void deletePlanById(@PathVariable("planId") int planId) throws Exception
	{
		healthPlanService.deletePlanById(planId);
	}
	
	@DeleteMapping("healthPlan/deletePlan")
	public void deletePlan() throws Exception
	{
		healthPlanService.deletePlan();
	}
	

}
