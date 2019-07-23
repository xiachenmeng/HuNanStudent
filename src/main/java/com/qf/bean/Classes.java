package com.qf.bean;

import java.util.Date;
import java.util.List;

public class Classes {
    private Integer classid;

    private String classnum;

    private Integer deptid;
    private List<Student> studentList;
    private List<Major> majors;
    private  List<Classes> classes;
    private Integer majorid;
    private Department department;
    private String classname;

    private Date classbegin;

    private Date classend;

    private String classcontent;

    private String classqq;

    private String tagline;

    private String classteacher;

    private Integer peoplecount;

    private String classstate;

    private Integer auditcount;

    private Integer auditid;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum == null ? null : classnum.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Date getClassbegin() {
        return classbegin;
    }

    public void setClassbegin(Date classbegin) {
        this.classbegin = classbegin;
    }

    public Date getClassend() {
        return classend;
    }

    public void setClassend(Date classend) {
        this.classend = classend;
    }

    public String getClasscontent() {
        return classcontent;
    }

    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent == null ? null : classcontent.trim();
    }

    public String getClassqq() {
        return classqq;
    }

    public void setClassqq(String classqq) {
        this.classqq = classqq == null ? null : classqq.trim();
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline == null ? null : tagline.trim();
    }

    public String getClassteacher() {
        return classteacher;
    }

    public void setClassteacher(String classteacher) {
        this.classteacher = classteacher == null ? null : classteacher.trim();
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getClassstate() {
        return classstate;
    }

    public void setClassstate(String classstate) {
        this.classstate = classstate == null ? null : classstate.trim();
    }

    public Integer getAuditcount() {
        return auditcount;
    }

    public void setAuditcount(Integer auditcount) {
        this.auditcount = auditcount;
    }

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }
}