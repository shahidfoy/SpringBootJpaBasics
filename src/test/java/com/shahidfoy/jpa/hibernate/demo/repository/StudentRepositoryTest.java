package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.DemoApplication;
import com.shahidfoy.jpa.hibernate.demo.entity.Address;
import com.shahidfoy.jpa.hibernate.demo.entity.Course;
import com.shahidfoy.jpa.hibernate.demo.entity.Passport;
import com.shahidfoy.jpa.hibernate.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void someTest() {
        repository.someMockOperationPersistenceContext();

    }

    @Test
    @Transactional
    public void retrieveStudentAndCourse() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("passport -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void setAddressDetails() {
        Student student = em.find(Student.class, 20001L);
        student.setAddress(new Address("123", "mainstreet", "denver"));
        em.flush();
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    public void findById_basic() {
        logger.info("Testing is Running");

        Student student = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", student.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        repository.deleteById(20002L);
        assertNull(repository.findById(20002L));
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        Student student = repository.findById(20001L);
        assertEquals("Shahid", student.getName());
        student.setName("Foy");
        repository.save(student);
        assertEquals("Foy", student.getName());
    }
}
