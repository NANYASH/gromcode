package core.lesson30;


import core.lesson30.exceptions.BadRequestException;


public class Demo {
    public static void main(String[] args) throws BadRequestException {

        Department department1 = new Department(DepartmentType.DEVELOPERS);
        Department department2 = new Department(DepartmentType.DESIGNERS);
        DepartmentDAO.addDepartment(department1);
        DepartmentDAO.addDepartment(department2);


        Employee employee1 = new Employee("TEAM_LEAD1", "TEAM_LEAD1", Position.TEAM_LEAD, department1);
        Employee employee2 = new Employee("DEVELOPER1", "DEVELOPER1", Position.DEVELOPER, department1);
        Employee employee3 = new Employee("DEVELOPER2", "DEVELOPER2", Position.DEVELOPER, department1);
        Employee employee4 = new Employee("DESIGNER1", "DESIGNER1", Position.DESIGNER, department1);

        Employee employee5 = new Employee("TEAM_LEAD2", "TEAM_LEAD2", Position.TEAM_LEAD, department2);
        Employee employee6 = new Employee("DEVELOPER3", "DEVELOPER3", Position.DEVELOPER, department2);
        Employee employee7 = new Employee("DEVELOPER4", "DEVELOPER4", Position.DEVELOPER, department2);
        Employee employee8 = new Employee("DESIGNER2", "DESIGNER2", Position.DESIGNER, department2);

        EmployeeDAO.addEmployee(employee1);
        EmployeeDAO.addEmployee(employee2);
        EmployeeDAO.addEmployee(employee3);
        EmployeeDAO.addEmployee(employee4);
        EmployeeDAO.addEmployee(employee5);
        EmployeeDAO.addEmployee(employee6);
        EmployeeDAO.addEmployee(employee7);
        EmployeeDAO.addEmployee(employee8);


        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department1.addEmployee(employee3);
        department1.addEmployee(employee4);

        department2.addEmployee(employee5);
        department2.addEmployee(employee6);
        department2.addEmployee(employee7);
        department2.addEmployee(employee8);


        Customer customer1 = new Customer("customer1", "Ukraine", 1000);
        Customer customer2 = new Customer("customer2", "USA", 2000);
        Customer customer3 = new Customer("customer3", "Italy", 3000);
        Customer customer4 = new Customer("customer4", "Canada", 4000);

        CustomerDAO.addCustomer(customer1);
        CustomerDAO.addCustomer(customer2);
        CustomerDAO.addCustomer(customer3);
        CustomerDAO.addCustomer(customer4);

        Project project1 = new Project("project1", customer1);
        Project project2 = new Project("project2", customer2);
        Project project3 = new Project("project3", customer3);
        Project project4 = new Project("project4", customer4);
        Project project5 = new Project("project5", customer2);
        Project project6 = new Project("project6", customer2);
        Project project7 = new Project("project7", customer3);
        Project project8 = new Project("project8", customer4);


        ProjectDAO.addProject(project1);
        ProjectDAO.addProject(project1);
        ProjectDAO.addProject(project3);
        ProjectDAO.addProject(project4);
        ProjectDAO.addProject(project5);
        ProjectDAO.addProject(project6);
        ProjectDAO.addProject(project7);
        ProjectDAO.addProject(project7);


        employee1.addProject(project1);
        employee1.addProject(project1);
        employee2.addProject(project1);
        employee1.addProject(project2);
        employee2.addProject(project2);
        employee3.addProject(project2);
        employee4.addProject(project5);
        employee2.addProject(project5);
        employee2.addProject(project6);
        employee3.addProject(project7);
        employee4.addProject(project8);


        System.out.println(Controller.employeesByProject("project1"));
        System.out.println(Controller.projectsByEmployee(employee1));
        System.out.println(Controller.employeesWithoutProjects());
        System.out.println(Controller.employeesByTeamLead(employee1));
        System.out.println(Controller.teamLeadByEmployees(employee2));
        System.out.println(Controller.employeesByProjectEmployee(employee1));
        System.out.println(Controller.projectsByCustomer(customer1));
        System.out.println(Controller.employeesByCustomerProject(customer1));


    }

}
