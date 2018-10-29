package com.xrj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrj.mapper.CommentMapper;
import com.xrj.pojo.Comment;
import com.xrj.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	public Comment getCommentByArticleUuid(String articleUuid) {
		return commentMapper.getCommentByArticleUuid(articleUuid);
	}

}
