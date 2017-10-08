package com.doora.api.service;


import com.doora.api.model.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(Long id);

    Course findCourseByID(Long id);

    List<Course> findCourseByName(String name);

    List<Course> findAllCourse();

    List<Course> findRelatedCourse(Long id);

}