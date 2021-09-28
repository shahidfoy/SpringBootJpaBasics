package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.entity.Employee;
import com.shahidfoy.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.shahidfoy.jpa.hibernate.demo.entity.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class)
                .getResultList();
    }

    public List<PartTimeEmployee> retrieveAllParTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class)
                .getResultList();
    }

//    public List<Employee> retrieveAllEmployees() {
//        return em.createQuery("select e from Employee e", Employee.class)
//                .getResultList();
//    }
}
