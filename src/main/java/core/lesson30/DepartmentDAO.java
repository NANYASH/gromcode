package core.lesson30;


import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private static List<Department> departments = new ArrayList<>();

    public static Department addDepartment(Department department) {
        departments.add(department);
        return departments.get(departments.indexOf(department));
    }

    public static List<Department> getDepartments() {
        return departments;
    }

    public static void setDepartments(List<Department> departments) {
        DepartmentDAO.departments = departments;
    }
}
