package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    /**
     * app id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Column(name = "name")
    @Setter @Getter
    private String name;

    @Setter @Getter
    @Column(name = "school")
    private String school;

    @Setter @Getter
    @Column(name = "faculty")
    private String faculty;

    @Setter @Getter
    @Column(name = "career")
    private String career;  // postgraduate

    @Setter @Getter
    @Column(name = "credit")
    private String credit;  // Unit of credit.

    @Setter @Getter
    @Column(name = "requirements")
    private String requirements;

    @Column(name = "likes")
    @Setter @Getter
    private Integer likes;

    @Column(name = "description")
    @Setter @Getter
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter @Getter
    private List<Tag> tags = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!id.equals(course.id)) return false;
        if (!name.equals(course.name)) return false;
        return school.equals(course.school);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + school.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", faculty='" + faculty + '\'' +
                ", career='" + career + '\'' +
                ", credit='" + credit + '\'' +
                ", requirements='" + requirements + '\'' +
                ", likes=" + likes +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}

