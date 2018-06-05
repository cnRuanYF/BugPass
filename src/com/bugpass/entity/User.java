package com.bugpass.entity;

import java.util.Date;

/**
 * 用户实体类
 * 
 * @author RuanYaofeng
 * @date 2018-06-05 21:21
 */
public class User {

    /** 用户ID */
    private long id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;

    /** 真实姓名 */
    private String realname;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String email;

    /** 注册日期 */
    private Date registerTime;

    /** 用户头像 */
    private int pictureId;

    /**
     * 构造一个用户对象
     */
    public User() {}

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * 构造一个用户对象
     * 
     * @param username 用户名
     * @param password 密码
     */
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname the realname to set
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return the registerTime
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * @param registerTime the registerTime to set
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * @return the pictureId
     */
    public int getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId the pictureId to set
     */
    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
                + ", phone=" + phone + ", email=" + email + ", registerTime=" + registerTime + ", pictureId="
                + pictureId + "]";
    }
}
