package com.xrj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.xrj.pojo.Comment;
import com.xrj.util.MyMapper;

@Mapper
public interface CommentMapper extends MyMapper<Comment> {
	
	Comment getCommentByArticleUuid(String articleUuid);
	
}