package com.empapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.empapp.dao.Employee;

@Component
public class ScheduledJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService service;

	@Scheduled(cron = "* 0,1 * * * *")
	public void cronJob() {
		logger.info("> cronJob");
		service.evictCache();
		logger.info("< cronJob");
	}

//	// after application startup delay of 5 sec, schedule to run each after 15 sec.
//	@Scheduled(initialDelay = 5000, fixedRate = 15000)
//	public void fixedRateJob() {
//		logger.info("> fixedRateJob");
//
//		// Add scheduled logic here
//
//		List<Employee> emps = service.getAll();
//		
//		logger.info("There are {} emps in the company.", emps.size());
//
//		logger.info("< fixedRateJob");
//	}

}
