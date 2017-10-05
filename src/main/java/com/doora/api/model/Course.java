package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Column(name = "code")
    @Setter @Getter
    private String code;

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

    @Column(name = "description", length = 2048)
    @Setter @Getter
    @Size(max = 2048)
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
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
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

