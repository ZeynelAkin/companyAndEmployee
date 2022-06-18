package enoca.challenge.zeynel.service;





import enoca.challenge.zeynel.dao.ICompanyModel;
import enoca.challenge.zeynel.dao.IEmployeesModel;
import enoca.challenge.zeynel.model.CompanyModel;
import enoca.challenge.zeynel.model.EmployeesModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ChallengeServiceTest {

    private ChallengeService challengeService;

    private ICompanyModel iCompanyModel;


    private IEmployeesModel iEmployeesModel;


    CompanyModel companyModel;

    EmployeesModel employeesModel;

    @Before
   public void setUp() throws Exception{

        iCompanyModel= Mockito.mock(ICompanyModel.class);
        iEmployeesModel=Mockito.mock(IEmployeesModel.class);

        challengeService =new ChallengeService();
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