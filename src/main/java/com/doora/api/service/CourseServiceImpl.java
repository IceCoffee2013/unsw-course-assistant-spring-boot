package com.doora.api.service;

import com.doora.api.model.Course;
import com.doora.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final static int RELATED_COURSE_COUNT = 10;

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

    @Override
    public List<Course> findRelatedCourse(Long id) {
        List<Course> relatedCourses = new ArrayList<>();
        Course target = findCourseByID(id);
        if (target == null) {
            return relatedCourses;
        }

        String codePrefix = target.getCode().replaceAll("\\d+","");
        if (codePrefix == null) {
            return relatedCourses;
        }

        int count = 0;
        for (Course c : this.courseRepository.findByCodeContaining(codePrefix)) {
            if (relatedCourses.size() >= RELATED_COURSE_COUNT) {
                break;
            }
            count++;
            if (c.getId().equals(target.getId())) {
                continue;
            }
            relatedCourses.add(c);
        }
        System.out.println("target: " + target.getCode() + " relatedCourses:" + relatedCourses.size());

        return relatedCourses;
    }
}
