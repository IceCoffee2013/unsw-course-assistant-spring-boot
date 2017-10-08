package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;

    @Column(name = "questionId")
    @Setter @Getter
    private String questionId;

    @Column(name = "author")
    @Setter @Getter
    private String author;

    @Column(name = "content", length = 2048)
    @Setter @Getter
    private String content;

    @Column(name = "postTime")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter @Getter
    private Date postTime;

    @Column(name = "likes")
    @Setter @Getter
    private Integer likes;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId='" + questionId + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                ", likes=" + likes +
                '}';
    }

}
