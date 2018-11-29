package com.si5.hrpayroll.dto;

public class BankDetailsDTO {

    private String employeeId ;
    private String branch ;
    private String name ;
    private String address;
    private String paymentMethod ;
    private String accountNumber ;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankDetailsDTO{" +
                "employeeId='" + employeeId + '\'' +
                ", branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
