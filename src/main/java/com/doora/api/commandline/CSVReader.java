package com.doora.api.commandline;

import com.doora.api.model.Course;
import com.doora.api.model.Tag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by langley on 4/10/17.
 */
public class CSVReader {


    public static void main(String[] args) {

        String csvFile = "./csv/all.csv";
        String line = "";
        String cvsSplitBy = ",";

        List<Course> courseList = new ArrayList<>();

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

                courseList.add(course);
//                course.set

                System.out.println("Course [code= " + courseArray[0] + " , name=" + courseArray[1] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
