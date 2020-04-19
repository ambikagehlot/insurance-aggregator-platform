package com.iap.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iap.demo.entity.HealthPlan;

@Repository
public interface HealthPlanRepo extends JpaRepository<HealthPlan, Integer>{

}
