package com.doora.api.commandline;

import com.doora.api.dto.UserDTO;
import com.doora.api.model.Course;
import com.doora.api.model.Tag;
import com.doora.api.service.CourseService;
import com.doora.api.service.UserService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
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
        userService.createUser(new UserDTO("295046974@qq.com", "123", "frank", "ROLE_ADMIN", "assets/images/face-1.jpg"));
        userService.createUser(new UserDTO("ruan.yuji@gmail.com", "123", "yuji", "ROLE_USER", "assets/images/face-2.jpg"));
        userService.createUser(new UserDTO("test@gmail.com", "123", "test1", "ROLE_USER", "assets/images/face-3.jpg"));
    }

    private void addCourse() {
        try {
            String csvFile = "./csv/all.csv";
            FileInputStream fis = new FileInputStream(csvFile);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            CSVReader reader = new CSVReader(isr);

            for (String[] row; (row = reader.readNext()) != null; ) {

                Course course = new Course();
                course.setCode(row[0].trim());
                course.setName(row[1].trim());
                course.setFaculty(row[2].trim());
                course.setSchool(row[3].trim());
                course.setCareer(row[4].trim());
                course.setCredit("6");
                course.setRequirements(row[5].trim());
                course.setDescription(row[6].trim());
                course.setLikes(0);
                Tag tag1 = new Tag();
                tag1.setName(course.getCode().replaceAll("\\d+", ""));
                Tag tag2 = new Tag();
                tag2.setName(course.getCareer());
                List<Tag> tags = new ArrayList<>();
                tags.add(tag1);
                tags.add(tag2);
                course.setTags(tags);

                System.out.println(course);

                courseService.addCourse(course);
            }

            reader.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            System.err.println("[error] " + e.getMessage());
        }
    }

}