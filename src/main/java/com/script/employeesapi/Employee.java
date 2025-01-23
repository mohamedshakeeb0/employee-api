package com.script.employeesapi;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double salary;
    private String joinDate;
    private String department;

    public Employee() {
    }

    //construct
    public Employee(String firstName, String lastName, double salary, String dateOfBirth, String joinDate, String department) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.department = department;
    }

    // getters and setters
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }

    public String getJoinDate() {

        return joinDate;
    }

    public void setJoinDate(String joinDate) {

        this.joinDate = joinDate;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }
}
