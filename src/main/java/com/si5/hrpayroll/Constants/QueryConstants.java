package com.si5.hrpayroll.Constants;

public class QueryConstants {

    public static StringBuilder GET_EMPLOYEE_DETAILS = new StringBuilder("select * from EmployeeDetails e " +
            "INNER JOIN ContactDetails as c on c.EmployeeId = e.EmployeeId " +
            "INNER JOIN EducationDetails as ed on ed.EmployeeId = e.EmployeeId " +
            "INNER JOIN SalaryDetails as sd on sd.EmployeeId = e.EmployeeId where e.employeeId = ?") ;

    public static StringBuilder GET_EMPLOYEES = new StringBuilder(
            "select EmployeeId,firstName,lastName,Gender from EmployeeDetails"
    ) ;

    public static StringBuilder DEACTIVATE_EMPLOYEE = new StringBuilder(
            "UPDATE EmployeeDetails SET isActive=0 WHERE EmployeeId = ?"
    ) ;

    public static StringBuilder GET_MAX_ID_EMPLOYEEDETAILS = new StringBuilder(
            "select max(EmployeeId) from EmployeeDetails"
    ) ;

    public static StringBuilder GET_MAX_ID_CONTACTDETAILS = new StringBuilder(
            "select max(ContactId) from ContactDetails"
    ) ;

    public static StringBuilder GET_MAX_ID_EDUCATIONDETAILS = new StringBuilder(
            "select max(Id) from EducationDetails"
    ) ;

    public static StringBuilder GET_MAX_ID_SALARYDETAILS = new StringBuilder(
            "select max(SalaryId) from SalaryDetails"
    ) ;

    public static StringBuilder GET_PASSWORD_FROM_HR = new StringBuilder(
            "select Password,JobId from PasswordDetails where EmployeeId = ? or EmailId = ?"
    ) ;





}
