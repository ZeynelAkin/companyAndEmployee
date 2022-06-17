package enoca.challange.zeynel.dao;

import enoca.challange.zeynel.model.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeesModel extends JpaRepository<EmployeesModel,Integer> {
}
