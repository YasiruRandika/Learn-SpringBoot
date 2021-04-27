package com.learnsb.springbootwithderby.course;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseReposiotry courseReposiotry;

    public List<Course> getCourseByTopic(int id) {
        List<Course> courses = new ArrayList<>();
        courseReposiotry.findByTopicId(id)
        .forEach(courses::add);
        return courses;
    }

    public void addCourse(Course topic) {
        courseReposiotry.save(topic);
    }

    public Course getCourse(int id) {
        return courseReposiotry.findById(id).get();
    }

    public void updateCourse(int id, Course topic) {
        courseReposiotry.save(topic);
    }
    
    public void deleteCourse(int id) {
        courseReposiotry.deleteById(id);
    }
}
