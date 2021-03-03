package entities;

public class Employee {
    private int id;
    private String first_name;
    private String second_name; // Here I declare fields.
    private int age;
    private double salary;
    private String position;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String fName) {
        this.first_name = fName;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String sName) {
        this.second_name = sName;
    }

    public Employee () {

    }
    // Here I declare constructors, setters and getters.
    public Employee(int id, String first_name, String second_name, int age, double salary, String position) {
        setId(id);
        setFirst_name(first_name);
        setSecond_name(second_name);
        setSalary(salary);
        setPosition(position);
        setAge(age);
    }
    public Employee(String first_name, String second_name,  int age, double salary, String position) {
        setFirst_name(first_name);
        setSecond_name(second_name);
        setSalary(salary);
        setPosition(position);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee [ " +
                "id is " + id +
                " | first name - '" + first_name + '\'' +
                " | second name - '" + second_name + '\'' +
                " | age - " + age +
                " | salary - " + salary +
                " | position - '" + position + '\'' +
                ']' + '\n';
    }
}
