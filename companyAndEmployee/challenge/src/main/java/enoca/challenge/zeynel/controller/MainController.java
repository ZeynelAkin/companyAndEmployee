package enoca.challenge.zeynel.controller;

import com.sun.istack.NotNull;
import enoca.challenge.zeynel.data.EmployeeDataResponse;
import enoca.challenge.zeynel.model.CompanyModel;
import enoca.challenge.zeynel.model.EmployeesModel;
import enoca.challenge.zeynel.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ChallengeService challengeService;


    @GetMapping("")
    public String showHomePage()
    {
        return "index";
    }

    @GetMapping("/company/list")
    @ResponseBody
    public String showCompanyList()
    {
        List<CompanyModel>listCompany= challengeService.companyListAll();
        StringBuilder stringBuilder=new StringBuilder();
        for (CompanyModel companyModel:listCompany)
        {
            stringBuilder.append("Company Id: "+companyModel.getCompanyId()+"---Company Name:"+companyModel.getCompanyName()+"\n");
        }
        return stringBuilder.toString();
    }

    @PostMapping(value = "company/delete/id")
    @ResponseBody
    public String companyDeleteById(@RequestParam Integer companyDeleteId)
    {
       String message= challengeService.companyDeleteById(companyDeleteId);
        return message;
    }

    @PostMapping(value = "/company/savee")
    @ResponseBody
    public String companySave(@RequestParam Integer companyId,@RequestParam String companyName)
    {
       String message= challengeService.companySave(companyId,companyName);
       return message;
    }

    @GetMapping("/employee/list")
    @ResponseBody
    public List<EmployeeDataResponse> showEmployeeList()
    {
        List<EmployeeDataResponse>employeeDataResponseList= challengeService.employeeListAll();

        return employeeDataResponseList;
    }

    @PostMapping(value = "employee/savee")
    @ResponseBody
    public Object enployeeSave(@RequestParam Integer employeeId,@RequestParam String employeeTc,@RequestParam String employeeName,@RequestParam String employeeSurname
            ,@RequestParam String employeeEmail,@RequestParam Integer employeeSalary
            ,@RequestParam String employeeGener,@RequestParam Integer companyId)
    {
        return  challengeService.employeeSave(employeeId,employeeTc,employeeName,employeeSurname,employeeEmail,employeeSalary,employeeGener,companyId);

    }

    @PostMapping(value = "employee/delete/id")
    @ResponseBody
    public String employeeDeleteById(@RequestParam Integer employeeDeleteById)
    {
      String message = challengeService.employeeDeleteById(employeeDeleteById);
        return message;
    }

}
