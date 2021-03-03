import controller.EmployeeController;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private final EmployeeController employeeController;
    private final Scanner scanner;
    //Creating object of controller.

    public Application(EmployeeController employeeController) {
        this.employeeController = employeeController;
        scanner = new Scanner(System.in);
    }
    //this method starts the program
    public void start() {
        System.out.println("\nThis is the program that helps you to store your employees information\n");
        label:
        while (true) { //This is console menu
            System.out.println("To use functionality of this program you need to write the number of option you choose. (0-5)" +
                    "\n 1] To search employee by its name. " +
                    "\n 2] To get employee by its id. " +
                    "\n 3] To add new employee. " +
                    "\n 4] To remove employee. " +
                    "\n 5] To show every employee in database." +
                    "\n 6] To show total cost of all employees." +
                    "\n 0] Exit\n" );

            String option = scanner.next();
            // this switch case will call functionality that user choose!
            switch (option) {
                case "1" -> searchEmployeeByItsNameOption();
                case "2" -> getEmployeeByItsIdOption();
                case "3" -> addEmployeeOption();
                case "4" -> removeEmployeeByItsIdOption();
                case "5" -> showEveryEmployeeOption();
                case "6" -> getTotalCostOfAllEmployeesOption();
                default -> System.out.println("Program ended, have a good day!");
            }

            System.out.println("--------------------------------------");
        }
    }

    public void searchEmployeeByItsNameOption() {
        System.out.println("Please, write First Name of the employee");
        String first_name = scanner.next();
        //This method gather information and calls methods from controller. Also it output the results.
        String result = employeeController.searchEmployeeByItsName(first_name);
        System.out.println(result);
    }

    public void getEmployeeByItsIdOption() {
        System.out.println("Please, write the id of employee");
        int id = scanner.nextInt();

        String result = employeeController.getEmployeeByItsId(id);
        System.out.println(result);
    }

    public void addEmployeeOption() {
        System.out.println("Please, write the first name of employee that you wanna add");
        String first_name = scanner.next();
        System.out.println("Please, write the second name of employee that you wanna add");
        String second_name = scanner.next();

        System.out.println("Please, write the age of this employee");
        int age = scanner.nextInt();

        System.out.println("Please, write the salary of this employee");
        double salary = scanner.nextDouble();

        System.out.println("Please, write the position of this employee");
        String position = scanner.next();


        String result = employeeController.addEmployee(first_name, second_name, age, salary, position);

        System.out.println(result);
    }

    public void removeEmployeeByItsIdOption() {
        System.out.println("Please, write the employee Id, to delete it");
        int id = scanner.nextInt();

        String result = employeeController.removeEmployeeByItsId(id);

        System.out.println(result);
    }

    public void showEveryEmployeeOption() {
        System.out.println("This is the list of all the employees we have! \n");
        ArrayList result = employeeController.showEveryEmployee();

        System.out.println(result);
    }

    public void getTotalCostOfAllEmployeesOption() {
        int result = employeeController.getTotalCostOfAllEmployees();

        System.out.println(" The total cost of all employees: " + result);
    }

}
