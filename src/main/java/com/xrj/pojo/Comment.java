package com.xrj.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xh_comment")
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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取论父id
     *
     * @return pid - 论父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置论父id
     *
     * @param pid 论父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取品论uuid
     *
     * @return uuid - 品论uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置品论uuid
     *
     * @param uuid 品论uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return user_uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * @return article_uuid
     */
    public String getArticleUuid() {
        return articleUuid;
    }

    /**
     * @param articleUuid
     */
    public void setArticleUuid(String articleUuid) {
        this.articleUuid = articleUuid;
    }

    /**
     * 获取是否精选0否 1 是
     *
     * @return best_status - 是否精选0否 1 是
     */
    public Boolean getBestStatus() {
        return bestStatus;
    }

    /**
     * 设置是否精选0否 1 是
     *
     * @param bestStatus 是否精选0否 1 是
     */
    public void setBestStatus(Boolean bestStatus) {
        this.bestStatus = bestStatus;
    }

    /**
     * 获取状态 -1 删除 0 表示待审核 1审核不通过 2审核通过
     *
     * @return audit_status - 状态 -1 删除 0 表示待审核 1审核不通过 2审核通过
     */
    public Boolean getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置状态 -1 删除 0 表示待审核 1审核不通过 2审核通过
     *
     * @param auditStatus 状态 -1 删除 0 表示待审核 1审核不通过 2审核通过
     */
    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取赞数
     *
     * @return zan - 赞数
     */
    public Integer getZan() {
        return zan;
    }

    /**
     * 设置赞数
     *
     * @param zan 赞数
     */
    public void setZan(Integer zan) {
        this.zan = zan;
    }

    /**
     * @return pri_data
     */
    public String getPriData() {
        return priData;
    }

    /**
     * @param priData
     */
    public void setPriData(String priData) {
        this.priData = priData;
    }

    /**
     * 获取加精时间
     *
     * @return best_time - 加精时间
     */
    public Date getBestTime() {
        return bestTime;
    }

    /**
     * 设置加精时间
     *
     * @param bestTime 加精时间
     */
    public void setBestTime(Date bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * 获取评论时间
     *
     * @return add_time - 评论时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置评论时间
     *
     * @param addTime 评论时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取0 先发后审  1 先审后发
     *
     * @return comment_type - 0 先发后审  1 先审后发
     */
    public Boolean getCommentType() {
        return commentType;
    }

    /**
     * 设置0 先发后审  1 先审后发
     *
     * @param commentType 0 先发后审  1 先审后发
     */
    public void setCommentType(Boolean commentType) {
        this.commentType = commentType;
    }

    /**
     * 获取父评论的uuid
     *
     * @return p_uuid - 父评论的uuid
     */
    public String getpUuid() {
        return pUuid;
    }

    /**
     * 设置父评论的uuid
     *
     * @param pUuid 父评论的uuid
     */
    public void setpUuid(String pUuid) {
        this.pUuid = pUuid;
    }
}