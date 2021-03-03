import controller.EmployeeController;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.EmployeeRepository;
import repositories.interfaces.IEmployeeRepository;

public class Main {
    public static void main(String[] args) {
        IDBManager idbManager = new DBManager();  //Here I declare DBManager, repository, employee controller and application
        IEmployeeRepository employeeRepository = new EmployeeRepository(idbManager);
        EmployeeController employeeController = new EmployeeController(employeeRepository);
        Application application = new Application(employeeController);
        application.start(); //then call method start() to start the application!
    }
}
