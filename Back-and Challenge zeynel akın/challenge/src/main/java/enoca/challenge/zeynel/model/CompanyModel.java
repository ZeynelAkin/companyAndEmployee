package enoca.challenge.zeynel.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id",nullable = false)
    private Integer companyId;

    @Column(name = "company_name",nullable = false)
    private String companyName;


    @OneToMany(mappedBy = "companyId",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmployeesModel> employeesModelList;

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

    public List<EmployeesModel> getEmployeesModelList() {
        return employeesModelList;
    }

    public void setEmployeesModelList(List<EmployeesModel> employeesModelList) {
        this.employeesModelList = employeesModelList;
    }
}
