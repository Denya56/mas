package MP2.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee e1;
    private Project p1;
    private Project p2;

    @Before
    public void setUp() {
        e1 = new Employee("name1", 100);
        p1 = new Project("Project name");
        p2 = new Project("Project name 2");
    }

    @Test
    public void addProject() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, p2.getEmployees().size());
        assertEquals(0, e1.getProjects().size());

        e1.addProject(p1);
        e1.addProject(p2);

        assertEquals(1, p1.getEmployees().size());
        assertEquals(1, p2.getEmployees().size());
        assertEquals(2, e1.getProjects().size());
    }

    @Test
    public void removeProject() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, p2.getEmployees().size());
        assertEquals(0, e1.getProjects().size());

        e1.addProject(p1);
        e1.addProject(p2);

        assertEquals(1, p1.getEmployees().size());
        assertEquals(1, p2.getEmployees().size());
        assertEquals(2, e1.getProjects().size());

        e1.removeProject(p1);

        assertEquals(0, p1.getEmployees().size());
        assertEquals(1, p2.getEmployees().size());
        assertEquals(1, e1.getProjects().size());

        e1.removeProject(p2);

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, p2.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
    }

    @Test
    public void delete() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, p2.getEmployees().size());
        assertEquals(0, e1.getProjects().size());

        e1.addProject(p1);
        e1.addProject(p2);

        assertEquals(1, p1.getEmployees().size());
        assertEquals(1, p2.getEmployees().size());
        assertEquals(2, e1.getProjects().size());

        Employee.delete(e1);

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, p2.getEmployees().size());
    }
}