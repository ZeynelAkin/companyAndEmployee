package enoca.challenge.zeynel.service;


import enoca.challenge.zeynel.data.CompanyDataResponse;
import enoca.challenge.zeynel.data.EmployeeDataResponse;
import enoca.challenge.zeynel.dao.ICompanyModel;
import enoca.challenge.zeynel.dao.IEmployeesModel;
import enoca.challenge.zeynel.model.CompanyModel;
import enoca.challenge.zeynel.model.EmployeesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ICompanyModel iCompanyModel;

    @Autowired
    private IEmployeesModel iEmployeesModel;

    CompanyModel companyModel = new CompanyModel();
    EmployeesModel employeesModel = new EmployeesModel();
    Logger logger = LogManager.getLogger(ChallengeService.class);

    public String companySave(Integer companyId, String companyName) {
        String message = null;
        CompanyDataResponse companyDataResponse=new CompanyDataResponse(companyId,companyName);
        Boolean aBooleanCompany = iCompanyModel.existsById(companyId);
        if (aBooleanCompany) {
            message = "Company Id exist: " + companyId;
            return message;
        } else {
            companyModel.setCompanyId(companyId);
            companyModel.setCompanyName(companyName);
            iCompanyModel.save(companyModel);

            logger.info("Company Saving...\n" + "Company Id: " + companyId + "\tCompany Name: " + companyName);
            message = "Company Id: "+companyDataResponse.getCompanyId()+"\nCompany Name: "+companyDataResponse.getCompanyName();
            return message;
        }

    }

    public List<CompanyModel> companyListAll() {
        List<CompanyModel> companyModelList =  iCompanyModel.findAll();
        logger.info("Company List Getting..." + companyModelList);
        return companyModelList;
    }

    public String companyDeleteById(Integer companyDeleteId) {

        Boolean aBooleanId = iCompanyModel.existsById(companyDeleteId);
        StringBuilder stringBuilder=new StringBuilder();

        if (aBooleanId) {
            logger.info("Company Deleting..." + iCompanyModel.findById(companyDeleteId));

            companyModel=iCompanyModel.findById(companyDeleteId).get();
            CompanyDataResponse companyDataResponse= new CompanyDataResponse(companyModel.getCompanyId(),companyModel.getCompanyName());
            stringBuilder.append("Company Deleted\n"+"\nCompany Id: "+companyDataResponse.getCompanyId()
                    +"\nCompany Name: "+companyDataResponse.getCompanyName());

            iCompanyModel.deleteById(companyDeleteId);

            return stringBuilder.toString();

        } else {
            stringBuilder.append( "Could not find any company with ID: " + companyDeleteId);

            return stringBuilder.toString();
        }


    }

    public EmployeeDataResponse employeeSave(Integer employeeId, String employeeTc, String employeeName, String employeeSurname, String employeeEmail, Integer employeeSalary, String employeeGender, Integer companyId) {

        employeesModel.setEmployeeId(employeeId);
        employeesModel.setEmployeeTc(employeeTc);
        employeesModel.setEmployeeName(employeeName);
        employeesModel.setEmployeeSurname(employeeSurname);
        employeesModel.setEmployeeEmail(employeeEmail);
        employeesModel.setEmployeeSalary(employeeSalary);
        employeesModel.setEmployeeGender(employeeGender);

        companyModel = iCompanyModel.findById(companyId).get();

        employeesModel.setCompanyId(companyModel);
        logger.info("Employee Saving...\n" + "Employee Id: " + employeeId + "\t" + "Employee Tc: " + employeeTc + "\t" + "Employee Name: "
                + employeeName + "\t" + "Employee Surname: " + employeeSurname + "\t" + "Employee Email: " + employeeEmail + "\t"
                + "Employee Salary: " + employeeSalary + "\t" + "Employee Gender: " + employeeGender + "\t" + "Employee Company Id: " + companyModel.getCompanyId() + "\t");
       iEmployeesModel.save(employeesModel);
        return new EmployeeDataResponse( employeeId,  employeeTc,  employeeName,  employeeSurname
                ,  employeeEmail,  employeeSalary,  employeeGender,  companyModel.getCompanyId(), companyModel.getCompanyName());

    }

    public List<EmployeeDataResponse> employeeListAll() {

        List<EmployeesModel> employeesModelList = iEmployeesModel.findAll();
        StringBuilder stringBuilder=new StringBuilder();
        EmployeeDataResponse employeeDataResponse;
        List<EmployeeDataResponse>employeeDataResponseList=new ArrayList<>(employeesModelList.size());
        for (EmployeesModel employeesModel:employeesModelList) {
            employeeDataResponse=new EmployeeDataResponse(employeesModel.getEmployeeId(),employeesModel.getEmployeeTc()
                    ,employeesModel.getEmployeeName(),employeesModel.getEmployeeSurname(),employeesModel.getEmployeeEmail()
                    ,employeesModel.getEmployeeSalary(),employeesModel.getEmployeeGender()
                    ,employeesModel.getCompanyId().getCompanyId(),employeesModel.getCompanyId().getCompanyName());

            employeeDataResponseList.add(employeeDataResponse);

            stringBuilder.append("Method Name : " + Thread.currentThread().getStackTrace()[1].getMethodName()
                    +"\nEmployee ID: "+employeesModel.getEmployeeId()+"\nEmployee Tc: "+employeesModel.getEmployeeTc()
                    +"\nEmployee Name: "+employeesModel.getEmployeeName()+"\nEmployee Surname: "+employeesModel.getEmployeeSurname()
                    +"\nEmployee Email: "+employeesModel.getEmployeeEmail()+"\nEmployee Salary: "+employeesModel.getEmployeeSalary()
                    +"\nEmployee Gender: "+employeesModel.getEmployeeGender()+"\nCompany Id: "+employeesModel.getCompanyId().getCompanyId()
                    +"\nCompany Name: "+employeesModel.getCompanyId().getCompanyName());

        }
        logger.info("Employee List Getting..." + stringBuilder);
        return employeeDataResponseList;
    }

    public String employeeDeleteById(Integer employeeDeleteById) {
        Boolean aBooleanEmployee = iEmployeesModel.existsById(employeeDeleteById);
        StringBuilder stringBuilder=new StringBuilder();
        employeesModel=iEmployeesModel.findById(employeeDeleteById).get();

        if (aBooleanEmployee) {
            iEmployeesModel.deleteById(employeeDeleteById);

            logger.info("Employee Deleting...\n" + "Employee Information: " );
            stringBuilder.append("Method Name : " + Thread.currentThread().getStackTrace()[1].getMethodName()
                    +"\nEmployee ID: "+employeesModel.getEmployeeId()+"\nEmployee Tc: "+employeesModel.getEmployeeTc()
                    +"\nEmployee Name: "+employeesModel.getEmployeeName()+"\nEmployee Surname: "+employeesModel.getEmployeeSurname()
                    +"\nEmployee Email: "+employeesModel.getEmployeeEmail()+"\nEmployee Salary: "+employeesModel.getEmployeeSalary()
                    +"\nEmployee Gender: "+employeesModel.getEmployeeGender()+"\nCompany Id: "+employeesModel.getCompanyId().getCompanyId()
                    +"\nCompany Name: "+employeesModel.getCompanyId().getCompanyName());

            return stringBuilder.toString();
        } else {
          return   stringBuilder .append("Could not find any employee with ID: " + employeeDeleteById).toString();

        }


    }
}
