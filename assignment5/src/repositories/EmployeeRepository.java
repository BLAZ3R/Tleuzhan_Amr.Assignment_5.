package repositories;

import data.interfaces.IDBManager;
import entities.Employee;
import repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDBManager dbManager;
    //Initialize the DBManager.
    public EmployeeRepository(IDBManager dbManager) {
        this.dbManager =dbManager;
    }
    //overriding methods from interface
    @Override
    public ArrayList<Employee> searchEmployeeByItsName(String first_name) {
        Connection connection = null;
        try {
            //establish connection
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE first_name LIKE '" + first_name  + "%'" );
            //execute SQL query by using preparedStatement.
            //and then saving the result of execute resultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            //using loop to get all the results with the same name as I used in the query!
            while (resultSet.next()) {
                Employee employee = new Employee( resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("position")
                );
                employees.add(employee);
            }
            //In the end return ArrayList
            return employees;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee getEmployeeByItsId(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = new Employee();
            //Initializing employee object to store all the information from database in this object.
            if(resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setSecond_name(resultSet.getString("second_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setPosition(resultSet.getString("position"));
            }

            return employee;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO employee(first_name, second_name, age ,salary , position) VALUES(?,?,?,?,?)");
            //Here I use set methods, to add information to database
            preparedStatement.setString(1,employee.getFirst_name());
            preparedStatement.setString(2,employee.getSecond_name());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5, employee.getPosition());


            preparedStatement.execute();

            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeEmployeeByItsId(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee  WHERE id = ?");
            //remove data from database by id.
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Employee> showEveryEmployee() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Employee> employees = new ArrayList<>();
            //using loop to get all the employees from database. Save it in the ArrayList Employees
            while (resultSet.next()) {
                Employee employee = new Employee( resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("position"));

                employees.add(employee);
            }
            return employees;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    @Override
    public int getTotalCostOfAllEmployees() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(salary) FROM employee");

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            //return sum!
            return resultSet.getInt("sum");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
