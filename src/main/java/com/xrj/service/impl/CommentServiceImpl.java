package com.xrj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrj.mapper.CommentMapper;
import com.xrj.pojo.Comment;
import com.xrj.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public Comment getCommentByArticleUuid(String articleUuid) {
		return commentMapper.getCommentByArticleUuid(articleUuid);
	}

	
	@Override
	public int insertComment(Comment comment) {
		return commentMapper.insertSelective(comment);
	}
}
