package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginUnitTest {

    // Sample valid test data
    private final LoginService service = new LoginService();

    @Test
    public void testValidLogin() {
        assertTrue(service.login("dilmi", "dilmi123", "2002-08-26"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(service.login("wronguser", "dilmi123", "2002-08-26"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(service.login("dilmi", "wrongpass", "2002-08-26"));
    }

    @Test
    public void testInvalidDoB() {
        assertFalse(service.login("dilmi", "dilmi123", "2002-08-25"));
    }

    @Test
    public void testNullUsername() {
        assertFalse(service.login(null, "dilmi123", "2002-08-26"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(service.login("dilmi", null, "2002-08-26"));
    }

    @Test
    public void testNullDoB() {
        assertFalse(service.login("dilmi", "dilmi123", null));
    }

    @Test
    public void testAllNulls() {
        assertFalse(service.login(null, null, null));
    }

    @Test
    public void testEmptyStrings() {
        assertFalse(service.login("", "", ""));
    }

    @Test
    public void testIncorrectDoBFormat() {
        assertFalse(service.login("dilmi", "dilmi123", "08-26-2002")); // Format off
    }

    @Test
    public void testCaseSensitivityUsername() {
        assertFalse(service.login("DILMI", "dilmi123", "2002-08-26")); // uppercase
    }

    @Test
    public void testExtraWhitespace() {
        assertFalse(service.login(" dilmi ", "dilmi123", "2002-08-26")); // with spaces
    }
}


