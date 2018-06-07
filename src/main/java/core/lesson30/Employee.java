package core.lesson30;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private List<Project> projects;


    public Employee(String firstName, String lastName, Position position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = new Date();
        this.position = position;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Project addProject(Project project) {
        projects.add(project);
        return projects.get(projects.indexOf(project));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!dateHired.equals(employee.dateHired)) return false;
        if (position != employee.position) return false;
        if (!department.equals(employee.department)) return false;
        return projects.equals(employee.projects);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateHired.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + projects.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                //", department=" + department +
                ", projects=" + projects +
                '}';
    }


    @Override
    public int compareTo(Employee employee) {
        return this.firstName.compareTo(employee.firstName);
    }
}
