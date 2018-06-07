package core.lesson30;


import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static List<Employee> employees = new ArrayList<>();

    public static Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employees.get(employees.indexOf(employee));
    }


    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        EmployeeDAO.employees = employees;
    }
}
