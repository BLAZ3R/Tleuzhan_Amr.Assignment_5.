package repositories.interfaces;

import entities.Employee;

import java.util.ArrayList;
//initialize methods in interface for Employee repository
public interface IEmployeeRepository {
    public ArrayList<Employee> searchEmployeeByItsName(String first_name);
    public Employee getEmployeeByItsId(int id);
    public boolean addEmployee(Employee employee);
    public boolean removeEmployeeByItsId(int id);
    public ArrayList<Employee> showEveryEmployee();
    public int getTotalCostOfAllEmployees();
}
