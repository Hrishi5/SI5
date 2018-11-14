package com.si5.hrpayroll.dto;

public class SalaryDetails {

    private String employeeId ;
    private String amount ;
    private boolean isMonthly ;
    private String salaryId ;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public void setMonthly(boolean monthly) {
        isMonthly = monthly;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    @Override
    public String toString() {
        return "SalaryDetails{" +
                "employeeId='" + employeeId + '\'' +
                ", amount='" + amount + '\'' +
                ", isMonthly=" + isMonthly +
                ", salaryId=" + salaryId +
                '}';
    }
}
