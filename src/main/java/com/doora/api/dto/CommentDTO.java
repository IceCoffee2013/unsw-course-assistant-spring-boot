package com.doora.api.dto;

import com.doora.api.model.Comment;
import com.doora.api.model.Reply;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by langley on 8/10/17.
 */
public class CommentDTO {

    @Setter @Getter
    String id;

    @Setter @Getter
    String postId;

    @Setter @Getter
    String content;

    @Setter @Getter
    Date postTime;

    @Setter @Getter
    String commenter;

    @Setter @Getter
    String avatar;

    @Setter @Getter
    List<Reply> replies;

    public CommentDTO(Comment comment) {
        this.id = comment.getId() + "";
        this.postId = comment.getPostId();
        this.content = comment.getContent();
        this.postTime = comment.getPostTime();
        this.commenter = comment.getCommenter();
        this.replies = comment.getReplies();
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id='" + id + '\'' +
                ", postId='" + postId + '\'' +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                ", commenter='" + commenter + '\'' +
                ", replies=" + replies +
                '}';
    }
}
