package MP2.basic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Project {
    private String name;

    private static final Set<Project> extent = new HashSet<>();

    private final Set<Employee> employees = new HashSet<>();

    public Project(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name has to be specified");
        }
        this.name = name;
    }

    public static Set<Project> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public void addEmployee(Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if(employees.contains(employee)) return;
        employees.add(employee);
        employee.addProject(this);
    }

    public void removeEmployee(Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if(!employees.contains(employee)) return;
        employees.remove(employee);
        employee.removeProject(this);
    }

    public static void delete(Project project) {
        if(project == null) {
            throw new IllegalArgumentException("Project cannot be null");
        }
        Set<Employee> tempEmployees = Set.copyOf(project.employees);
        project.employees.clear();
        tempEmployees.forEach(x -> x.removeProject(project));
        extent.remove(project);
    }

    @Override
    public String toString() {
        return "Group: " + name;
    }
}
