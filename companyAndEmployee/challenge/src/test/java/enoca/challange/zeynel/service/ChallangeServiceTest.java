package enoca.challange.zeynel.service;





import enoca.challange.zeynel.dao.ICompanyModel;
import enoca.challange.zeynel.dao.IEmployeesModel;
import enoca.challange.zeynel.model.CompanyModel;
import enoca.challange.zeynel.model.EmployeesModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ChallangeServiceTest {

    private ChallangeService challangeService;

    private ICompanyModel iCompanyModel;


    private IEmployeesModel iEmployeesModel;


    CompanyModel companyModel;

    EmployeesModel employeesModel;

    @Before
   public void setUp() throws Exception{

        iCompanyModel= Mockito.mock(ICompanyModel.class);
        iEmployeesModel=Mockito.mock(IEmployeesModel.class);

        challangeService=new ChallangeService();
        companyModel=new CompanyModel();
        employeesModel=new EmployeesModel();

    }

    @Test
    public void whenCompanySave()
    {
        companyModel.setCompanyId(1);
        companyModel.setCompanyName("Kleo");

        Mockito.when(iCompanyModel.save(companyModel));
        System.out.println("Test Save Succesfuly");
    }

    @Test
    public void whenCompanyList()
    {

        System.out.println("Company List: "+iCompanyModel.findAll());

    }
}