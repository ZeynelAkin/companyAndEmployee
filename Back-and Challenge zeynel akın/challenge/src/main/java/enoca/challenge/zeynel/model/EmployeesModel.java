package enoca.challenge.zeynel.model;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "employees")
public class EmployeesModel implements Serializable {

    @Id
    @Column(name = "employee_id",nullable = false)
    private Integer employeeId;
    @Column(name = "employee_tc",nullable = false,unique = true)
    private String employeeTc;

    @Column(name = "employee_name",nullable = false)
    private String employeeName;

    @Column(name = "employee_surname",nullable = false)
    private String employeeSurname;

    @Column(name = "employee_email",nullable = false)
    private String employeeEmail;

    @Column(name = "employee_salary",nullable = false)
    private Integer employeeSalary;

    @Column(name = "employee_gender",nullable = false)
    private String employeeGender;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "company_id")
    private CompanyModel companyId;


    public String getEmployeeTc() {
        return employeeTc;
    }

    public void setEmployeeTc(String employeeTc) {
        this.employeeTc = employeeTc;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public CompanyModel getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyModel companyId) {
        this.companyId = companyId;
    }
}