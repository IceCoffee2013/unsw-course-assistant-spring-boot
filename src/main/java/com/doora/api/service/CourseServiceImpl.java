package com.doora.api.service;

import com.doora.api.model.Course;
import com.doora.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        this.courseRepository.delete(id);
    }

    @Override
    public Course findCourseByID(Long id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public List<Course> findCourseByName(String name) {
        return this.courseRepository.findByNameContaining(name);
    }

    @Override
    public List<Course> findAllCourse() {
        return this.courseRepository.findAll();
    }
}
