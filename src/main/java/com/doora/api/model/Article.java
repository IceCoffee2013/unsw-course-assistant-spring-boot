package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by langley on 12/9/17.
 */
@Entity
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Column(name = "title")
    @Setter @Getter
    private String title;

    @Column(name = "content", length = 200000)
    @Setter @Getter
    private String content;

    @Column(name = "author")
    @Setter @Getter
    private String author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter @Getter
    private List<Tag> tags = new ArrayList<>();

    @Column(name = "postTime")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter @Getter
    private Date postTime;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                ", postTime=" + postTime +
                '}';
    }
}
