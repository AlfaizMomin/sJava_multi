import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    // Violation: Method name should follow naming convention (Rule: `MethodNamingConventions`)
    @Test
    public void TestUserCreation() {
        User user = new User("john", "doe");
        assertNotNull(user);
    }

    // Violation: Method name should not contain underscores (Rule: `MethodNamingConventions`)
    @Test
    public void create_user_with_null_lastname() {
        User user = new User("john", null);
        assertEquals("john", user.getFirstName());
    }

    // Violation: Empty test method (Rule: `EmptyMethod`)
    @Test
    public void testEmpty() {
    }

    // Violation: Test method name too short (Rule: `MethodNamingConventions`)
    @Test
    public void t() {
        User user = new User("a", "b");
        assertTrue(user.getFirstName().length() == 1);
    }

    // Violation: Multiple assert statements in one test (Rule: `JUnitTestsShouldIncludeAssert`) — This one is controversial but often flagged
    @Test
    public void testMultipleAsserts() {
        User user = new User("Jane", "Doe");
        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
    }
}
