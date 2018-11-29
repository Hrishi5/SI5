package com.si5.hrpayroll.dto;

import java.io.Serializable;

public class PayrollDetailsDTO implements Serializable {

    private String employeeId ;
    private String firstName ;
    private String lastName;
    private int bankId ;
    private int salary ;
    private boolean isActive ;

    @Override
    public String toString() {
        return "PayrollDetailsDTO{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankId=" + bankId +
                ", salary=" + salary +
                ", isActive=" + isActive +
                '}';
    }

    public String getEmployeeId() {
        return employeeId;
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

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
