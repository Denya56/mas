package MP2.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectTest {
    private Employee e1;
    private Employee e2;
    private Project p1;

    @Before
    public void setUp() {
        e1 = new Employee("name1", 100);
        e2 = new Employee("name2", 1000);
        p1 = new Project("Project name");
    }


    @Test
    public void addEmployee() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
        assertEquals(0, e2.getProjects().size());

        p1.addEmployee(e1);
        p1.addEmployee(e2);

        assertEquals(2, p1.getEmployees().size());
        assertEquals(1, e1.getProjects().size());
        assertEquals(1, e2.getProjects().size());
    }

    @Test
    public void removeEmployee() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
        assertEquals(0, e2.getProjects().size());

        p1.addEmployee(e1);
        p1.addEmployee(e2);

        assertEquals(2, p1.getEmployees().size());
        assertEquals(1, e1.getProjects().size());
        assertEquals(1, e2.getProjects().size());

        p1.removeEmployee(e1);
        assertEquals(1, p1.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
        assertEquals(1, e2.getProjects().size());

        p1.removeEmployee(e2);
        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
        assertEquals(0, e2.getProjects().size());

    }

    @Test
    public void delete() {

        assertEquals(0, p1.getEmployees().size());
        assertEquals(0, e1.getProjects().size());
        assertEquals(0, e2.getProjects().size());

        p1.addEmployee(e1);
        p1.addEmployee(e2);

        assertEquals(2, p1.getEmployees().size());
        assertEquals(1, e1.getProjects().size());
        assertEquals(1, e2.getProjects().size());

        Project.delete(p1);
        assertEquals(0, e1.getProjects().size());
        assertEquals(0, e2.getProjects().size());
    }
}