package com.si5.hrpayroll.dto;

import java.io.Serializable;

public class PayrollDTO implements Serializable {

    private PayrollDetailsDTO payrollDetails ;
    private BankDetailsDTO bankDetails ;
    private TaxDetailsDTO taxDetails ;

    public PayrollDTO() {
    }


    public PayrollDTO(PayrollDetailsDTO payrollDetails, BankDetailsDTO bankDetails, TaxDetailsDTO taxDetails) {
        this.payrollDetails = payrollDetails ;
        this.bankDetails = bankDetails ;
        this.taxDetails = taxDetails ;
    }

    public PayrollDetailsDTO getPayrollDetails() {
        return payrollDetails;
    }

    public void setPayrollDetails(PayrollDetailsDTO payrollDetails) {
        this.payrollDetails = payrollDetails;
    }

    public BankDetailsDTO getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetailsDTO bankDetails) {
        this.bankDetails = bankDetails;
    }

    public TaxDetailsDTO getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(TaxDetailsDTO taxDetails) {
        this.taxDetails = taxDetails;
    }

    @Override
    public String toString() {
        return "PayrollDTO{" +
                "payrollDetails=" + payrollDetails +
                ", bankDetails=" + bankDetails +
                ", taxDetails=" + taxDetails +
                '}';
    }
}
