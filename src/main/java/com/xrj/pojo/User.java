package com.xrj.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "xh_user")
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5358840619608732009L;

	@Id
    private Integer uid;

    /**
     * 用户账户类型 0.未知1.手机用户 2.微信 3.QQ 4.微博
     */
    @Column(name = "user_type")
    private Boolean userType;

    /**
     * 用户登陆名称(登陆)
     */
    private String username;

    /**
     * 用户显示名称
     */
    private String nickname;

    /**
     * 默认为一组随机字符
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatar;

    /**
     * email
     */
    private String email;

    /**
     * 第三方uuid
     */
    @Column(name = "third_uuid")
    private String thirdUuid;

    /**
     * 备注
     */
    private String description;

    /**
     * 状态(正常0、-1 冻结)
     */
    @Column(name = "status_freeze")
    private Boolean statusFreeze;

    /**
     * 密码盐值
     */
    private String salt;

    /**
     * 0 未知 ，1 男 ，2 女
     */
    private Boolean sex;

    /**
     * 国家
     */
    private String country;

    /**
     * 区域
     */
    private String region;

    /**
     * 城市
     */
    private String city;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 用户uuid
     */
    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 私有数据
     */
    @Column(name = "pri_data")
    private String priData;

    /**
     * 登录次数
     */
    @Column(name = "login_num")
    private Integer loginNum;

    /**
     * 新增用户的时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 上一次登陆的时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 密码错误的次数 登陆成功后置为0
     */
    @Column(name = "login_error_num")
    private Integer loginErrorNum;

    /**
     * 上一次更改密码的时间
     */
    @Column(name = "last_update_password_time")
    private Date lastUpdatePasswordTime;

    /**
     * 临时昵称 
     */
    @Column(name = "nickname_temp")
    private String nicknameTemp;

    /**
     * 临时头像
     */
    @Column(name = "avatar_temp")
    private String avatarTemp;

    /**
     * 0待审核  1 审核通过 -1 审核不通过
     */
    @Column(name = "nickname_audit")
    private Boolean nicknameAudit;

    /**
     * 0待审核 1审核通过 -1审核不通过
     */
    @Column(name = "avatar_audit")
    private Boolean avatarAudit;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取用户账户类型 0.未知1.手机用户 2.微信 3.QQ 4.微博
     *
     * @return user_type - 用户账户类型 0.未知1.手机用户 2.微信 3.QQ 4.微博
     */
    public Boolean getUserType() {
        return userType;
    }

    /**
     * 设置用户账户类型 0.未知1.手机用户 2.微信 3.QQ 4.微博
     *
     * @param userType 用户账户类型 0.未知1.手机用户 2.微信 3.QQ 4.微博
     */
    public void setUserType(Boolean userType) {
        this.userType = userType;
    }

    /**
     * 获取用户登陆名称(登陆)
     *
     * @return username - 用户登陆名称(登陆)
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户登陆名称(登陆)
     *
     * @param username 用户登陆名称(登陆)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户显示名称
     *
     * @return nickname - 用户显示名称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户显示名称
     *
     * @param nickname 用户显示名称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取默认为一组随机字符
     *
     * @return password - 默认为一组随机字符
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置默认为一组随机字符
     *
     * @param password 默认为一组随机字符
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取第三方uuid
     *
     * @return third_uuid - 第三方uuid
     */
    public String getThirdUuid() {
        return thirdUuid;
    }

    /**
     * 设置第三方uuid
     *
     * @param thirdUuid 第三方uuid
     */
    public void setThirdUuid(String thirdUuid) {
        this.thirdUuid = thirdUuid;
    }

    /**
     * 获取备注
     *
     * @return description - 备注
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置备注
     *
     * @param description 备注
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取状态(正常0、-1 冻结)
     *
     * @return status_freeze - 状态(正常0、-1 冻结)
     */
    public Boolean getStatusFreeze() {
        return statusFreeze;
    }

    /**
     * 设置状态(正常0、-1 冻结)
     *
     * @param statusFreeze 状态(正常0、-1 冻结)
     */
    public void setStatusFreeze(Boolean statusFreeze) {
        this.statusFreeze = statusFreeze;
    }

    /**
     * 获取密码盐值
     *
     * @return salt - 密码盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐值
     *
     * @param salt 密码盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取0 未知 ，1 男 ，2 女
     *
     * @return sex - 0 未知 ，1 男 ，2 女
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置0 未知 ，1 男 ，2 女
     *
     * @param sex 0 未知 ，1 男 ，2 女
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取区域
     *
     * @return region - 区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置区域
     *
     * @param region 区域
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Byte getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * 获取用户uuid
     *
     * @return user_uuid - 用户uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * 设置用户uuid
     *
     * @param userUuid 用户uuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * 获取私有数据
     *
     * @return pri_data - 私有数据
     */
    public String getPriData() {
        return priData;
    }

    /**
     * 设置私有数据
     *
     * @param priData 私有数据
     */
    public void setPriData(String priData) {
        this.priData = priData;
    }

    /**
     * 获取登录次数
     *
     * @return login_num - 登录次数
     */
    public Integer getLoginNum() {
        return loginNum;
    }

    /**
     * 设置登录次数
     *
     * @param loginNum 登录次数
     */
    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    /**
     * 获取新增用户的时间
     *
     * @return add_time - 新增用户的时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置新增用户的时间
     *
     * @param addTime 新增用户的时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取上一次登陆的时间
     *
     * @return last_login_time - 上一次登陆的时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上一次登陆的时间
     *
     * @param lastLoginTime 上一次登陆的时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取密码错误的次数 登陆成功后置为0
     *
     * @return login_error_num - 密码错误的次数 登陆成功后置为0
     */
    public Integer getLoginErrorNum() {
        return loginErrorNum;
    }

    /**
     * 设置密码错误的次数 登陆成功后置为0
     *
     * @param loginErrorNum 密码错误的次数 登陆成功后置为0
     */
    public void setLoginErrorNum(Integer loginErrorNum) {
        this.loginErrorNum = loginErrorNum;
    }

    /**
     * 获取上一次更改密码的时间
     *
     * @return last_update_password_time - 上一次更改密码的时间
     */
    public Date getLastUpdatePasswordTime() {
        return lastUpdatePasswordTime;
    }

    /**
     * 设置上一次更改密码的时间
     *
     * @param lastUpdatePasswordTime 上一次更改密码的时间
     */
    public void setLastUpdatePasswordTime(Date lastUpdatePasswordTime) {
        this.lastUpdatePasswordTime = lastUpdatePasswordTime;
    }

    /**
     * 获取临时昵称 
     *
     * @return nickname_temp - 临时昵称 
     */
    public String getNicknameTemp() {
        return nicknameTemp;
    }

    /**
     * 设置临时昵称 
     *
     * @param nicknameTemp 临时昵称 
     */
    public void setNicknameTemp(String nicknameTemp) {
        this.nicknameTemp = nicknameTemp;
    }

    /**
     * 获取临时头像
     *
     * @return avatar_temp - 临时头像
     */
    public String getAvatarTemp() {
        return avatarTemp;
    }

    /**
     * 设置临时头像
     *
     * @param avatarTemp 临时头像
     */
    public void setAvatarTemp(String avatarTemp) {
        this.avatarTemp = avatarTemp;
    }

    /**
     * 获取0待审核  1 审核通过 -1 审核不通过
     *
     * @return nickname_audit - 0待审核  1 审核通过 -1 审核不通过
     */
    public Boolean getNicknameAudit() {
        return nicknameAudit;
    }

    /**
     * 设置0待审核  1 审核通过 -1 审核不通过
     *
     * @param nicknameAudit 0待审核  1 审核通过 -1 审核不通过
     */
    public void setNicknameAudit(Boolean nicknameAudit) {
        this.nicknameAudit = nicknameAudit;
    }

    /**
     * 获取0待审核 1审核通过 -1审核不通过
     *
     * @return avatar_audit - 0待审核 1审核通过 -1审核不通过
     */
    public Boolean getAvatarAudit() {
        return avatarAudit;
    }

    /**
     * 设置0待审核 1审核通过 -1审核不通过
     *
     * @param avatarAudit 0待审核 1审核通过 -1审核不通过
     */
    public void setAvatarAudit(Boolean avatarAudit) {
        this.avatarAudit = avatarAudit;
    }
}