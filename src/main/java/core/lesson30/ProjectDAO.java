package core.lesson30;


import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private static List<Project> projects = new ArrayList<>();

    public static Project addProject(Project project) {
        projects.add(project);
        return projects.get(projects.indexOf(project));
    }

    public static List<Project> getProjects() {
        return projects;
    }

    public static void setProjects(List<Project> projects) {
        ProjectDAO.projects = projects;
    }

}
