package com.learnsb.springbootwithderby.course;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface CourseReposiotry extends CrudRepository<Course, Integer>{
    public List<Course> findByTopicId(int id);
}
