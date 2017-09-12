package com.doora.api.service;


import com.doora.api.model.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Long id);

    Course findCourseByID(Long id);

    List<Course> findCourseByName(String name);

    List<Course> findAllCourse();

}