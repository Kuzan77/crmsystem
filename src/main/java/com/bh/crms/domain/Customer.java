package com.bh.crms.domain;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 实体类
 * (客户)
 * @author ：mmzs
 * @date ：Created in 2021/1/27 11:06
 */
public class Customer {
    private String cid;                     // id
    private String cname;                   // 姓名
    private String gender;                  // 性别
    private Date birthday;                  // 生日
    private String cellphone;               // 电话
    private String email;                   // 邮箱
    private String description;             // 描述

    public Customer() {

    }

    public Customer(String cid, String cname, String gender, Date birthday, String cellphone, String email, String description) {
        this.cid = cid;
        this.cname = cname;
        this.gender = gender;
        this.birthday = birthday;
        this.cellphone = cellphone;
        this.email = email;
        this.description = description;
    }

    public Customer(String cname, String gender, String cellphone, String email) {
        this.cname = cname;
        this.gender = gender;
        this.cellphone = cellphone;
        this.email = email;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
