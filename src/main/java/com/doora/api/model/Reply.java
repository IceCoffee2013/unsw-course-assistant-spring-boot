package com.doora.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reply")
public class Reply {

    /**
     * comment id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;

    @Column(name = "commentId")
    @Setter @Getter
    private String commentId;

    @Column(name = "replyContent")
    @Setter @Getter
    private String replyContent;

    @Column(name = "replier")
    @Setter @Getter
    private String replier;

    @Column(name = "toWho")
    @Setter @Getter
    private String toWho;

    @Column(name = "replyTime")
    @Temporal(TemporalType.DATE)
    @Setter @Getter
    private Date replyTime;

}
