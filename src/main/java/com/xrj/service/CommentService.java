package com.xrj.service;

import com.xrj.pojo.Comment;

public interface CommentService {

	Comment getCommentByArticleUuid(String articleUuid);

	int insertComment(Comment comment);

}
