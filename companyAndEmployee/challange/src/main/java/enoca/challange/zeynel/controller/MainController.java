package enoca.challange.zeynel.controller;

import enoca.challange.zeynel.model.CompanyModel;
import enoca.challange.zeynel.model.EmployeesModel;
import enoca.challange.zeynel.service.ChallangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RestController
public class MainController {

    @Autowired
    private ChallangeService challangeService;


    @GetMapping("")
    public String showHomePage()
    {
        return "index";
    }

    @GetMapping("/companyList")
    @ResponseBody
    public String showCompanyList(Model model)
    {
        List<CompanyModel>listCompany=challangeService.companyListAll();
        StringBuilder stringBuilder=new StringBuilder();
        for (CompanyModel companyModel:listCompany)
        {
            stringBuilder.append("Company Id: "+companyModel.getCompanyId()+"---Company Name:"+companyModel.getCompanyName()+"\n");
        }
        return stringBuilder.toString();
    }

    @PostMapping(value = "companyDeleteId")
    @ResponseBody
    public String companyDeleteById(@RequestParam Integer companyDeleteId)
    {
       String message= challangeService.companyDeleteById(companyDeleteId);
        return message;
    }

    @PostMapping(value = "/companySavee")
    @ResponseBody
    public String companySave(@RequestParam Integer companyId,@RequestParam String companyName)
    {


       String message= challangeService.companySave(companyId,companyName);



       return message;
    }

    @GetMapping("/employeeList")
    @ResponseBody
    public String showEmployeeList(Model model)
    {
        List<EmployeesModel>employeesModelList=challangeService.employeeListAll();
        StringBuilder stringBuilder=new StringBuilder();
        for (EmployeesModel employeesModel:employeesModelList)
        {
            stringBuilder.append("Employee Id: "+employeesModel.getEmployeeId()+"\tEmployee Tc: "+employeesModel.getEmployeeTc()+"\tEmployee Name: "
                    +employeesModel.getEmployeeName()+"\tEmployee Surname: "+employeesModel.getEmployeeSurname()
                    +"\tEmployee Mail: "+employeesModel.getEmployeeEmail()+"\tEmployee Salary: "+employeesModel.getEmployeeSalary()
                    +"\tEmployee Gender: "+employeesModel.getEmployeeGender()+"\nEmployee Company Id: "+employeesModel.getCompany_id());
        }
        return stringBuilder.toString();
    }

    @PostMapping(value = "employeeSavee")
    @ResponseBody
    public String enployeeSave(@RequestParam Integer employeeId,@RequestParam String employeeTc,@RequestParam String employeeName,@RequestParam String employeeSurname
            ,@RequestParam String employeeEmail,@RequestParam Integer employeeSalary
            ,@RequestParam String employeeGener,@RequestParam Integer companyId)
    {
        challangeService.employeeSave(employeeId,employeeTc,employeeName,employeeSurname,employeeEmail,employeeSalary,employeeGener,companyId);

        return "Enployee Save Successfully ";
    }

    @PostMapping(value = "employeeDeleteId")
    @ResponseBody
    public String employeeDeleteById(@RequestParam Integer employeeDeleteById)
    {
      String message =challangeService.employeeDeleteById(employeeDeleteById);
        return message;
    }

}
