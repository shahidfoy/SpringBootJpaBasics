package com.shahidfoy.jpa.hibernate.demo.repository;

import com.shahidfoy.jpa.hibernate.demo.entity.Course;
import com.shahidfoy.jpa.hibernate.demo.entity.Review;
import com.shahidfoy.jpa.hibernate.demo.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            // insert
            em.persist(course);
        } else {
            // update
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() {}", course.getReviews());
        for(Review review: reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }

        public void addReviewsForCourseHardCoded() {
        // get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() {}", course.getReviews());
        // add 2 reviews
        Review review = new Review(ReviewRating.FIVE, "Great Hand-on Stuff.");
        Review review2 = new Review(ReviewRating.FOUR, "Nice.");
        // set relationship
        course.addReview(review);
        review.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        // save
        em.persist(review);
        em.persist(review2);

    }
}
