package core.lesson30;


import core.lesson30.exceptions.BadRequestException;

import java.util.*;

public class Controller {

    public static List<Employee> employeesByProject(String projectName) throws BadRequestException {
        List<Employee> employeesAtProject = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {
                if (project.getName().equals(projectName))
                    employeesAtProject.add(employee);
            }
        }
        checkEmployees(employeesAtProject);
        return employeesAtProject;
    }

    public static List<Project> projectsByEmployee(Employee employee) throws BadRequestException {
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            if (employee.equals(employee1)) {
                checkProjects(employee1.getProjects());
                return employee1.getProjects();
            }
        }
        throw new BadRequestException("Such employee does not exist.");
    }


    public static List<Employee> employeesWithoutProjects() throws BadRequestException {
        List<Employee> employeesWithoutProjects = new ArrayList<>();
        boolean employeeWithoutProjects = true;
        for (Employee employee : EmployeeDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {
                if (project != null) {
                    employeeWithoutProjects = false;
                    break;
                }
            }
            if (employeeWithoutProjects) employeesWithoutProjects.add(employee);
        }
        checkEmployees(employeesWithoutProjects);
        return employeesWithoutProjects;

    }

    public static Set<Employee> employeesByTeamLead(Employee employee) throws BadRequestException {
        if (!employee.getPosition().equals(Position.TEAM_LEAD))
            throw new BadRequestException("Such employee is not a TeamLead.");
        Set<Employee> employees = new TreeSet<>();
        List<Project> projects = projectsByEmployee(employee);
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            for (Project project : projects) {
                if (employee1.getProjects().contains(project) && !employee1.equals(employee))
                    employees.add(employee1);
            }
        }
        checkEmployees(employees);
        return employees;

    }


    public static Set<Employee> teamLeadByEmployees(Employee employee) throws BadRequestException {
        if (employee.getPosition().equals(Position.TEAM_LEAD))
            throw new BadRequestException("Such employee is a TeamLead.");
        Set<Employee> employees = new TreeSet<>();
        List<Project> projects = projectsByEmployee(employee);
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            for (Project project : projects) {
                if (employee1.getPosition().equals(Position.TEAM_LEAD) && employee1.getProjects().contains(project))
                    employees.add(employee1);
            }
        }
        checkEmployees(employees);
        return employees;

    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) throws BadRequestException {
        Set<Employee> employees = new TreeSet<>();
        List<Project> projects = projectsByEmployee(employee);
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            for (Project project : projects) {
                if (employee1.getProjects().contains(project) && !employee1.equals(employee))
                    employees.add(employee1);
            }
        }
        checkEmployees(employees);
        return employees;

    }

    public static List<Project> projectsByCustomer(Customer customer) throws BadRequestException {
        List<Project> projects = new ArrayList<>();
        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(customer))
                projects.add(project);
        }
        checkProjects(projects);
        return projects;
    }

    public static Set<Employee> employeesByCustomerProject(Customer customer) throws BadRequestException {
        Set<Employee> employees = new TreeSet<>();
        for (Project project : projectsByCustomer(customer)) {
            employees.addAll(employeesByProject(project.getName()));
        }
        checkEmployees(employees);
        return employees;

    }

    public static void checkEmployees(List<Employee> employees) throws BadRequestException {
        for (Employee employee : employees) {
            if (employee != null) return;
        }
        throw new BadRequestException("No employees with such parameter.");
    }

    public static void checkEmployees(Set<Employee> employees) throws BadRequestException {
        for (Employee employee : employees) {
            if (employee != null) return;
        }
        throw new BadRequestException("No employees with such parameter.");
    }

    public static void checkProjects(List<Project> projects) throws BadRequestException {
        for (Project project : projects) {
            if (project != null) return;
        }
        throw new BadRequestException("No projects with such parameter.");
    }
}
