package core.lesson30;

import java.util.Date;
import java.util.Set;

public class Firm {
    private Date dateFounded;
    private Set<Department> departments;
    private Set<Employee> employees;

    public Firm() {
    }

    public Firm(Set<Department> departments, Set<Employee> employees) {
        this.dateFounded = new Date();
        this.departments = departments;
        this.employees = employees;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm firm = (Firm) o;

        if (!dateFounded.equals(firm.dateFounded)) return false;
        if (!departments.equals(firm.departments)) return false;
        return employees.equals(firm.employees);
    }

    @Override
    public int hashCode() {
        int result = dateFounded.hashCode();
        result = 31 * result + departments.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                ", departments=" + departments +
                ", employees=" + employees +
                '}';
    }
}
