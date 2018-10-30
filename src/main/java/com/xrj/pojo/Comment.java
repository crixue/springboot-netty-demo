package com.xrj.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "xh_comment")
@Data
public class Comment {
    @Id
    private Integer id;

    /**
     * 论父id
     */
    private Integer pid;

    /**
     * 品论uuid
     */
    private String uuid;

    /**
     * 评论内容
     */
    private String content;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "article_uuid")
    private String articleUuid;

    /**
     * 是否精选0否 1 是
     */
    @Column(name = "best_status")
    private Boolean bestStatus;

    /**
     * 状态 -1 删除 0 表示待审核 1审核不通过 2审核通过
     */
    @Column(name = "audit_status")
    private Boolean auditStatus;

    /**
     * 赞数
     */
    private Integer zan;

    @Column(name = "pri_data")
    private String priData;

    /**
     * 加精时间
     */
    @Column(name = "best_time")
    private Date bestTime;

    /**
     * 评论时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 0 先发后审  1 先审后发
     */
    @Column(name = "comment_type")
    private Boolean commentType;

    /**
     * 父评论的uuid
     */
    @Column(name = "p_uuid")
    private String pUuid;

}