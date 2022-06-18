package enoca.challange.zeynel.service;


import enoca.challange.zeynel.dao.ICompanyModel;
import enoca.challange.zeynel.dao.IEmployeesModel;
import enoca.challange.zeynel.model.CompanyModel;
import enoca.challange.zeynel.model.EmployeesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallangeService {

    @Autowired
    private ICompanyModel iCompanyModel;

    @Autowired
    private IEmployeesModel iEmployeesModel;


    CompanyModel companyModel=new CompanyModel();
    EmployeesModel employeesModel=new EmployeesModel();
    Logger logger= LogManager.getLogger(ChallangeService.class);
    public String companySave(Integer companyId,String companyName)
    {   String message = null;
        Boolean aBooleanCompany=iCompanyModel.existsById(companyId);
        if (aBooleanCompany)
        {   message="Company Id exist: "+companyId;
            return message;
        }else {
            companyModel.setCompanyId(companyId);
            companyModel.setCompanyName(companyName);
            iCompanyModel.save(companyModel);
            logger.info("Company Saving...\n"+"Company Id: "+companyId+"\tCompany Name: "+companyName);
            message="Save Successfuly";
            return message;
        }




    }
    public List<CompanyModel> companyListAll()
    {   List<CompanyModel>companyModelList=(List<CompanyModel>)iCompanyModel.findAll();
        logger.info("Company List Getting..."+companyModelList);
        return companyModelList;
    }

    public String companyDeleteById(Integer companyDeleteId)
    {
        Boolean aBooleanId=iCompanyModel.existsById(companyDeleteId);
        String message;
        if (aBooleanId)
        {   iCompanyModel.deleteById(companyDeleteId);
            logger.info("Company Deleting..."+iCompanyModel.findById(companyDeleteId));
            message="Company Delete Succesfuly: "+iCompanyModel.findById(companyDeleteId);

        }else {
            message="Could not find any company with ID: "+companyDeleteId;

        }


        return message;
    }

    public void employeeSave(Integer employeeId,String employeeTc,String employeeName,String employeeSurname,String employeeEmail,Integer employeeSalary,String employeeGender,Integer companyId)
    {

        employeesModel.setEmployeeId(employeeId);
        employeesModel.setEmployeeTc(employeeTc);
        employeesModel.setEmployeeName(employeeName);
        employeesModel.setEmployeeSurname(employeeSurname);
        employeesModel.setEmployeeEmail(employeeEmail);
        employeesModel.setEmployeeSalary(employeeSalary);
        employeesModel.setEmployeeGender(employeeGender);

        companyModel=iCompanyModel.findById(companyId).get();

        employeesModel.setCompany_id(companyModel);
        logger.info("Employee Saving...\n"+"Employee Id: "+employeeId+"\t"+"Employee Tc: "+employeeTc+"\t"+"Employee Name: "
                +employeeName+"\t"+"Employee Surname: "+employeeSurname+"\t"+"Employee Email: "+employeeEmail+"\t"
                +"Employee Salary: "+employeeSalary+"\t"+"Employee Gender: "+employeeGender+"\t"+"Employee Company Id: "+companyId+"\t");
        iEmployeesModel.save(employeesModel);


    }

    public List<EmployeesModel> employeeListAll()
    {   List<EmployeesModel>employeesModelList=(List<EmployeesModel>)iEmployeesModel.findAll();
        logger.info("Employee List Getting..."+employeesModelList);
        return employeesModelList;
    }

    public String employeeDeleteById(Integer employeeDeleteById)
    {   Boolean aBooleanEmployee=iEmployeesModel.existsById(employeeDeleteById);
        String message;
        if (aBooleanEmployee)
        {   iEmployeesModel.deleteById(employeeDeleteById);
            logger.info("Employee Deleting...\n"+"Employee Information: "+iEmployeesModel.findById(employeeDeleteById));
            message="Employee Delete Succesfuly";

        }else {
            message="Could not find any employee with ID: "+ employeeDeleteById;

        }


        return message;
    }
}
