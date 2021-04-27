package com.learnsb.springbootwithderby.course;

import java.util.List;

import com.learnsb.springbootwithderby.topic.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable int id) {
        return courseService.getCourseByTopic(id);
    }

    @GetMapping("/topics/{id}/courses/{courseId}")
    public Course getCourse(@PathVariable int id, @PathVariable int courseId) {
        return courseService.getCourse(courseId);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping("/topics/{id}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable int id) {
        course.setTopic(new Topic(id, "", ""));
        courseService.addCourse(course);
    }

    @DeleteMapping("/topics/{id}/courses/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
    }

    @PutMapping("/topics/{id}/courses/{courseId}")
    public void updateTopic(@RequestBody Course course, @PathVariable int courseId, @PathVariable int id) {
        course.setTopic(new Topic(id, "", ""));
        courseService.updateCourse(courseId, course);
    }

}
