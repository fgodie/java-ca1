/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author wongj
 * Class: DIT/FT/2B/23
 * Admission Number: P2329354
 * Name: Wong Jun Hong
 * 
 */
public class Student {

    private String studentName;

    private String adminNo;

    private String studentClass;

    private String Module;

    private double GPA;


    //Contructor
    //Default Contructor
    public Student(){
        this.studentName = "admin";
        this.adminNo = "12345";
        this.studentClass = "DIT2B23";
        this.Module = "ST0509/JPRG";
        this.GPA = 0.0;
    }

    //Explicit Contructor
    public Student(String studentName, String adminNo, String studentClass, String Module, double GPA ){
        this.studentName = studentName;
        this.adminNo = adminNo;
        this.studentClass = studentClass;
        this.Module = Module;
        this.GPA = GPA;
        
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getModule() {
        return this.Module;
    }

    public void setModule(String module) {
        Module = module;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

    


}