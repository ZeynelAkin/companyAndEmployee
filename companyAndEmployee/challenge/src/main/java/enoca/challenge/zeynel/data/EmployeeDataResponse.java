package enoca.challenge.zeynel.data;

public class EmployeeDataResponse {

    private Integer employeeId;
    private String employeeTc;
    private String employeeName;
    private String employeeSurname;
    private String employeeEmail;
    private Integer employeeSalary;
    private String employeeGender;
    private Integer companyId;
    private String companyName;

    public EmployeeDataResponse() {
    }

    public EmployeeDataResponse(Integer employeeId, String employeeTc, String employeeName, String employeeSurname
            , String employeeEmail, Integer employeeSalary, String employeeGender, Integer companyId, String companyName) {
        this.employeeId = employeeId;
        this.employeeTc = employeeTc;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeEmail = employeeEmail;
        this.employeeSalary = employeeSalary;
        this.employeeGender = employeeGender;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeTc() {
        return employeeTc;
    }

    public void setEmployeeTc(String employeeTc) {
        this.employeeTc = employeeTc;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
