package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.entity.Course;
import com.shahidfoy.jpa.hibernate.demo.entity.Passport;
import com.shahidfoy.jpa.hibernate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            // insert
            em.persist(student);
        } else {
            // update
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {

        Passport passport = new Passport("K12345");
        em.persist(passport);
        Student student = new Student("Kraken");
        student.setPassport(passport);
        em.persist(student);

    }

    public void someMockOperationPersistenceContext() {
        Student student = em.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("R12345");
        student.setName("Rex - updated");
    }

    public void insertStudentAndCourse(Student student, Course course) {
//        Student student = new Student("Jack");
//        Course course = new Course("Microservices in 100 steps");
//        em.persist(student);
//        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
        em.persist(course);
    }
}
