package com.FJNU.seed.model;

public class UserInfo {
    private String id;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String idnumber;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }
    public void setIdnumber(String idnumber) {
        this. idnumber= idnumber;
    }

    @Override
    public String toString() {
        return "{id:" + id +",password:" + password +", name:" + name + ", gender:" + gender + ", phone:" + phone + ", idnumber:" + idnumber +"}";
    }
}
