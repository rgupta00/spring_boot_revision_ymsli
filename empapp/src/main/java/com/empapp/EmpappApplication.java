package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.empapp.service.EmployeeService;
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class EmpappApplication implements CommandLineRunner{

	@Autowired
	private EmployeeService employeeService;
	
	
	@Bean
	public CacheManager cacheManager(){
		ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager("emps");
		return cacheManager;

	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmpappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeService.save(new Employee("ravi", 40.0));
//		employeeService.save(new Employee("kapil", 50.0));
//		employeeService.save(new Employee("amit", 40.0));
//		employeeService.save(new Employee("sumit", 40.0));	
		System.out.println("---------");	
	}
}
