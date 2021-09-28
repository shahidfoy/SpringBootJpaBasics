package com.shahidfoy.jpa.hibernate.demo;

import com.shahidfoy.jpa.hibernate.demo.entity.*;
import com.shahidfoy.jpa.hibernate.demo.repository.CourseRepository;
import com.shahidfoy.jpa.hibernate.demo.repository.EmployeeRepository;
import com.shahidfoy.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.saveStudentWithPassport();
//		List<Review> reviews = new ArrayList<>();
//		Review review = new Review("5", "something");
//		Review review2 = new Review("4", "something else");
//		reviews.add(review);
//		reviews.add(review2);
//		courseRepository.addReviewsForCourse(10003L, reviews);

//		Student student = new Student("Jack");
//      Course course = new Course("Microservices in 100 steps");
//		studentRepository.insertStudentAndCourse(student, course);

		employeeRepository.insert(new PartTimeEmployee("jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("jack", new BigDecimal("10000")));

		logger.info("All Part Time Employees -> {}", employeeRepository.retrieveAllParTimeEmployees());
		logger.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());

	}
}
