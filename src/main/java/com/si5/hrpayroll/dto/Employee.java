package com.si5.hrpayroll.dto ;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private int age;
    private String dateOfBirth;
    private String maritalStatus;
    private String gender;
    private String hiringDate;
    private String joiningDate;
    private String jobId;
    private boolean isActive ;
    private boolean isMigrated ;

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsMigrated() {
        return isMigrated;
    }

    public void setIsMigrated(boolean isMigrated) {
        this.isMigrated = isMigrated;
    }

    private ContactDetails contactDetails ;
    private EducationDetails educationDetails ;
    private SalaryDetails salaryDetails ;

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public EducationDetails getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(EducationDetails educationDetails) {
        this.educationDetails = educationDetails;
    }

    public SalaryDetails getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(SalaryDetails salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", gender=" + gender +
                ", hiringDate=" + hiringDate +
                ", joiningDate=" + joiningDate +
                ", jobId='" + jobId + '\'' +
                '}';
    }
}


