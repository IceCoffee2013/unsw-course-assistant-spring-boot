package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Column(name = "title")
    @Setter @Getter
    private String title;

    @Column(name = "description")
    @Setter @Getter
    private String description;

    @Column(name = "author")
    @Setter @Getter
    private String author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter @Getter
    private List<Tag> tags = new ArrayList<>();

    @Column(name = "postTime")
    @Temporal(TemporalType.DATE)
    @Setter @Getter
    private Date postTime;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                ", postTime=" + postTime +
                '}';
    }
}
