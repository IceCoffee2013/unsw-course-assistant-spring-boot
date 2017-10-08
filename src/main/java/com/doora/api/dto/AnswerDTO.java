package com.doora.api.dto;

import com.doora.api.model.Answer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by langley on 8/10/17.
 */
public class AnswerDTO {

    @Setter @Getter
    String id;

    @Setter @Getter
    String questionId;

    @Setter @Getter
    String author;

    @Setter @Getter
    String content;

    @Setter @Getter
    int likes = 0;

    @Setter @Getter
    Date postTime;

    @Setter @Getter
    String avatar;

    @Setter @Getter
    boolean isUp = false;    // vote

    @Setter @Getter
    boolean isDown = false;

    @Setter @Getter
    boolean isShowComment = false;

    public AnswerDTO(Answer answer) {
        this.id = answer.getId() + "";
        this.questionId = answer.getQuestionId();
        this.author = answer.getAuthor();
        this.content = answer.getContent();
        this.likes = answer.getLikes();
        this.postTime = answer.getPostTime();
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", postTime=" + postTime +
                ", isUp=" + isUp +
                ", isDown=" + isDown +
                ", isShowComment=" + isShowComment +
                '}';
    }
}
