package com.zhongruan.bean;

public class Teacher {
    private int stuid;
    private String stuName;

    public Teacher(int stuid, String stuName) {
        this.stuid = stuid;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "stuid=" + stuid +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public Teacher() {
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
