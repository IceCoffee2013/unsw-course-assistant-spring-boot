package com.doora.api.utils;

import javafx.util.Pair;
import com.doora.api.model.CommentType;

/**
 * Created by langley on 13/9/17.
 */
public class Util {

    public static String generatePostId(CommentType commentType, Long id) {
        if (commentType == null) {
            return null;
        }
        return commentType.toString() + "_" + id;
    }

    public static Pair<CommentType, Long> parsePostId(String postId) {
        String[] tmp = postId.split("_");
        if (tmp == null || tmp.length != 2) {
            System.out.println("error in parse post id: " + postId);
            return null;
        }
        CommentType type = CommentType.valueOf(tmp[0]);
        Long id = Long.parseLong(tmp[1]);
        Pair<CommentType, Long> result = new Pair<>(type, id);
        return result;
    }

}
