package com.doora.api.commandline;

import com.doora.api.model.Course;
import com.doora.api.model.Tag;
import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by langley on 4/10/17.
 */
public class DBReader {

    public static void main(String[] args) {
        try {
            String csvFile = "./csv/all.csv";
            FileInputStream fis = new FileInputStream(csvFile);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            CSVReader reader = new CSVReader(isr);

            List<Course> courseList = new ArrayList<>();

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
                System.out.println();

                courseList.add(course);
            }

            reader.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }


    }

}
