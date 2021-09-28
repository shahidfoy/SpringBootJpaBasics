package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByName(String name);
    int countByName(String name);

    List<Course> findByNameOrderByIdDesc(String name);
    void deleteByName(String name);

    @Query("Select  c  From Course c where name like '%100 Steps'")
    List<Course> coursesWith100StepsInName();

    @Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
    List<Course> coursesWith100StepsInNameUsingNativeQuery();

    @Query(name="query_get_all_courses_join_fetch")
    List<Course> coursesWith100StepsInNameUsingNamedQuery();
}
