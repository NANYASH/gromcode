package core.lesson30;


import java.util.ArrayList;
import java.util.List;


public class Department {
    private DepartmentType type;
    private List<Employee> employees = new ArrayList<>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employees.get(employees.indexOf(employee));
    }

    public DepartmentType getType() {
        return type;
    }

    public void setType(DepartmentType type) {
        this.type = type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (type != that.type) return false;
        return employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}

