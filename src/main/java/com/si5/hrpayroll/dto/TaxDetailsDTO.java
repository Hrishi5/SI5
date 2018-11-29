package com.si5.hrpayroll.dto;

import java.io.Serializable;

public class TaxDetailsDTO implements Serializable {
    private int taxDetailsId ;
    private String ssnNumber ;
    private boolean isTaxExempt ;
    private String employeeId ;

    public int getTaxDetailsId() {
        return taxDetailsId;
    }

    public void setTaxDetailsId(int taxDetailsId) {
        this.taxDetailsId = taxDetailsId;
    }

    public String getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(String ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public boolean getIsTaxExempt() {
        return isTaxExempt;
    }

    public void setIsTaxExempt(boolean taxExempt) {
        isTaxExempt = taxExempt;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "TaxDetailsDTO{" +
                "taxDetailsId=" + taxDetailsId +
                ", ssnNumber='" + ssnNumber + '\'' +
                ", isTaxExempt=" + isTaxExempt +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
