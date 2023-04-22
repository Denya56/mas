package MP2.basic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String firstName;
    private float salary;

    private static final Set<Employee> extent = new HashSet<>();

    private final Set<Project> projects = new HashSet<>();

    public Employee(String firstName, float salary) {
        setSalary(salary);
        setFirstName(firstName);
        extent.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("First name cannot be null");
        }
        this.firstName = firstName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if(salary <= 0) {
            throw new IllegalArgumentException("Salary cannot be 0 or lower");
        }
        this.salary = salary;
    }

    public static Set<Employee> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public Set<Project> getProjects() {
        return Collections.unmodifiableSet(projects);
    }

    public void addProject(Project project) {
        if(project == null) {
            throw new IllegalArgumentException("Project cannot be null");
        }
        if(projects.contains(project)) return;
        projects.add(project);
        project.addEmployee(this);
    }

    public void removeProject(Project project) {
        if(project == null) {
            throw new IllegalArgumentException("Project cannot be null");
        }
        if(!projects.contains(project)) return;
        projects.remove(project);
        project.removeEmployee(this);
    }

    public static void delete(Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        Set<Project> tempProj = Set.copyOf(employee.projects);
        employee.projects.clear();
        tempProj.forEach(x -> x.removeEmployee(employee));
        extent.remove(employee);
    }

    @Override
    public String toString() {
        return "Employee:" +
                "First name: " + firstName +
                "Salary: " + salary;
    }
}
