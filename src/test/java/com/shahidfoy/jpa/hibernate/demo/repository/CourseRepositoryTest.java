package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.DemoApplication;
import com.shahidfoy.jpa.hibernate.demo.entity.Course;
import com.shahidfoy.jpa.hibernate.demo.entity.Review;
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
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void findById_basic() {
        logger.info("Testing is Running");

        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @Transactional
    public void findById_firstLevelCacheDemo() {
        Course course = repository.findById(10001L);
        logger.info("First Course Retrieved {}", course);
        Course course2 = repository.findById(10001L);
        logger.info("First Course Retrieved again {}", course2);
        assertEquals("JPA in 50 Steps", course.getName());
        assertEquals("JPA in 50 Steps", course2.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);
        assertEquals("JPA in 50 Steps - Updated", course.getName());
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10001L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 50001L);
        logger.info("{}", review.getCourse());
    }
}