package com.shahidfoy.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private ReviewRating rating;

    @ManyToOne
    private Course course;

    protected Review() {}

    public Review(ReviewRating rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]", rating, description);
    }
}
