package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {

    /**
     * comment id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Column(name = "postId")
    @Setter @Getter
    private String postId;

    @Column(name = "content")
    @Setter @Getter
    private String content;

    @Column(name = "postTime")
    @Temporal(TemporalType.DATE)
    @Setter @Getter
    private Date postTime;

    @Column(name = "commenter")
    @Setter @Getter
    private String commenter;

    @Column(name = "replies")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter @Getter
    private List<Reply> replies = new ArrayList<>();

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId='" + postId + '\'' +
                ", content='" + content + '\'' +
                ", commenter='" + commenter + '\'' +
                ", replies=" + replies +
                '}';
    }
}
