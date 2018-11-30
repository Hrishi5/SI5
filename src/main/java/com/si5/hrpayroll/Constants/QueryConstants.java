package com.si5.hrpayroll.Constants;

public class QueryConstants {

    public static StringBuilder GET_EMPLOYEE_DETAILS = new StringBuilder("select * from EmployeeDetails e " +
            "INNER JOIN ContactDetails as c on c.EmployeeId = e.EmployeeId " +
            "INNER JOIN EducationDetails as ed on ed.EmployeeId = e.EmployeeId " +
            "INNER JOIN SalaryDetails as sd on sd.EmployeeId = e.EmployeeId where e.employeeId = ?") ;

    public static StringBuilder GET_EMPLOYEES = new StringBuilder(
            "select * from EmployeeDetails"
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

    public static StringBuilder SET_PASSWORD = new StringBuilder(
            "UPDATE PasswordDetails p set p.Password = ? where p.EmployeeId = ? or p.EmailId = ?"
    ) ;

    public static StringBuilder GET_PAYROLL_DETAILS = new StringBuilder(
            "select * from PayRollDetails where EmployeeId = ?"
    ) ;

    public static StringBuilder GET_BANK_DETAILS = new StringBuilder(
            "select * from BankDetails b, PayRollDetails p where b.BankId = p.BankId and p.EmployeeId = ?"
    ) ;

    public static StringBuilder GET_TAX_DETAILS = new StringBuilder(
            "select * from TaxDetails where EmployeeId = ?"
    ) ;

    public static StringBuilder UPDATE_EMPLOYEE_DETAILS = new StringBuilder(
            "UPDATE HR.EmployeeDetails\n" +
                    "SET\n" +
                    "FirstName = :firstName ,\n" +
                    "LastName = :lastName ,\n" +
                    "Age = :age ,\n" +
                    "DateOfBirth = :dateOfBirth ,\n" +
                    "MaritalStatus = :maritalStatus ,\n" +
                    "Gender = :gender ,\n" +
                    "HiringDate = :hiringDate ,\n" +
                    "JoiningDate = :joiningDate ,\n" +
                    "JobId = :jobId ,\n" +
                    "IsMigrated = 0 \n" +
                    "WHERE EmployeeId = :employeeId and IsActive = 1\n"
    ) ;

    public static StringBuilder UPDATE_EDUCATION_DETAILS = new StringBuilder(
            "UPDATE HR.EducationDetails\n" +
                    "SET\n" +
                    "NameOfSchool =:nameOfSchool ,\n" +
                    "Degree =:degree ,\n" +
                    "StartDate =:startDate ,\n" +
                    "EndDate =:endDate \n" +
                    "WHERE EmployeeId =:employeeId\n"
    ) ;

    public static StringBuilder UPDATE_CONTACT_DETAILS = new StringBuilder(
    "UPDATE HR.ContactDetails\n" +
            "SET\n" +
            "PhoneNumber =:phoneNumber,\n" +
            "Address =:address,\n" +
            "Email=:email where EmployeeId=:employeeId"
    ) ;

    public static StringBuilder UPDATE_SALARY_DETAILS = new StringBuilder(
            "UPDATE HR.SalaryDetails set Amount=:amount, IsMonthly=:isMonthly where EmployeeId=:employeeId"
    ) ;

    public static StringBuilder UPDATE_PAYROLL_DETAILS = new StringBuilder(
            "Update PayRoll.PayRollDetails set Address = :address, BankId = :bankId, " +
                    "PaymentMethod = :paymentMethod, AccountNumber = :accountNumber " +
                    "where EmployeeId = :employeeId and IsActive = 1"
    ) ;

    public static StringBuilder UPDATE_TAX_DETAILS = new StringBuilder(
            "Update PayRoll.TaxDetails set SSNNumber = :ssnNumber, IsTaxExempt = :isTaxExempt where EmployeeId = :employeeId"
    ) ;






}
