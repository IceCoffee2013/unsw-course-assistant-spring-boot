package com.doora.api.controllers;

import com.doora.api.model.Course;
import com.doora.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllCourses(@RequestParam(value = "searchText", required = false) String searchText,
                                            @RequestParam(value = "tag", required = false) String tag) {
        List<Course> courses = new ArrayList<>();
        if (searchText != null && !searchText.isEmpty()) {
            courses = courseService.findCourseByName(searchText);
        } else {
            courses = courseService.findAllCourse();
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        Course course = courseService.findCourseByID(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
