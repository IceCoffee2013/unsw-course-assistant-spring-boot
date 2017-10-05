package com.doora.api.commandline;

import com.doora.api.dto.UserDTO;
import com.doora.api.model.Course;
import com.doora.api.model.Tag;
import com.doora.api.service.CourseService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * initial data at application startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @Override
    public void run(String... arg0) throws Exception {
//        addUser();
//        addCourse();
    }

    private void addUser() {
        userService.createUser(new UserDTO("295046974@qq.com", "123", "frank", "ROLE_ADMIN"));
        userService.createUser(new UserDTO("ruan.yuji@gmail.com", "123", "yuji", "ROLE_USER"));
        userService.createUser(new UserDTO("test@gmail.com", "123", "test1", "ROLE_USER"));
    }

    private void addCourse() {
        String csvFile = "./csv/all.csv";
        String line = "";
        String cvsSplitBy = ",";

//        List<Course> courseList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] courseArray = line.split(cvsSplitBy);

                Course course = new Course();
                course.setCode(courseArray[0].trim());
                course.setName(courseArray[1].trim());
                course.setFaculty(courseArray[2].trim());
                course.setSchool(courseArray[3].trim());
                course.setCareer(courseArray[4].trim());
                course.setCredit("6");
                course.setRequirements(courseArray[5].trim());
                course.setDescription(courseArray[6].trim());
                course.setLikes(0);
                Tag tag1 = new Tag();
                tag1.setName(course.getCode().replaceAll("\\d+",""));
                Tag tag2 = new Tag();
                tag2.setName(course.getCareer());
                List<Tag> tags = new ArrayList<>();
                tags.add(tag1);
                tags.add(tag2);
                course.setTags(tags);

//                courseList.add(course);
                System.out.println(course);
                courseService.addCourse(course);

                System.out.println("Course [code= " + courseArray[0] + " , name=" + courseArray[1] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}