package com.si5.hrpayroll.dto;

import java.util.List;

public class FieldsListDTO {

    private String employeeId ;
    private List<JsonKeyValueDTO> fieldList ;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<JsonKeyValueDTO> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<JsonKeyValueDTO> fieldList) {
        this.fieldList = fieldList;
    }

    @Override
    public String toString() {
        return "FieldsListDTO{" +
                "employeeId='" + employeeId + '\'' +
                ", fieldList=" + fieldList +
                '}';
    }
}
