package enoca.challenge.zeynel.data;

public class CompanyDataResponse {

    private Integer companyId;
    private String companyName;

    public CompanyDataResponse() {
    }


    public CompanyDataResponse(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
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
