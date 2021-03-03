package controller;

import entities.Employee;
import repositories.interfaces.IEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeController {

        private final IEmployeeRepository employeeRepository;

        //This class allows me to set connection between repository and application.
        public EmployeeController(IEmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        public String searchEmployeeByItsName(String first_name){
            String result = employeeRepository.searchEmployeeByItsName(first_name).toString();

            return result;
        }
        //There are methods that calls repository.
        public String getEmployeeByItsId(int id) {
            String result = employeeRepository.getEmployeeByItsId(id).toString();

            return result;
        }
        // I use type string to return result!
        public String addEmployee(String first_name, String second_name, int age,double salary, String position) {
            Employee employee = new Employee(first_name,second_name, age,salary,position);
            boolean added = employeeRepository.addEmployee(employee);


            return added ? "|  New employee was added!  |" : "|  New employee wasn't added, something failed  |";
        }

        public String removeEmployeeByItsId(int id) {
            boolean removed = employeeRepository.removeEmployeeByItsId(id);

            return removed ? "|  employee was deleted!  |" : "|  employee wasn't deleted, something went wrong  |";
        }

        public ArrayList<Employee> showEveryEmployee() {
            ArrayList<Employee> result = employeeRepository.showEveryEmployee();

            return result;
        }

        public int getTotalCostOfAllEmployees() {
            int result = employeeRepository.getTotalCostOfAllEmployees();

            return result;
        }
}
