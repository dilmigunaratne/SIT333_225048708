package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationUnitTest {

    @Test
    public void testSuccessfulRegistration() {
        RegistrationService.clearUsers();
        assertTrue(RegistrationService.register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01"));
        assertEquals(1, RegistrationService.getUserCount());
    }

    @Test
    public void testDuplicateRegistration() {
        RegistrationService.clearUsers();
        RegistrationService.register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01");
        assertFalse(RegistrationService.register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01"));
    }

    @Test
    public void testEmptyFields() {
        RegistrationService.clearUsers();
        assertFalse(RegistrationService.register("", "punsara", "dilmi123@gmail.com", "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", "", "dilmi123@gmail.com", "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", "punsara", "", "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", "punsara", "dilmi123@gmail.com", ""));
    }

    @Test
    public void testNullFields() {
        RegistrationService.clearUsers();
        assertFalse(RegistrationService.register(null, "punsara", "dilmi123@gmail.com", "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", null, "dilmi123@gmail.com", "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", "punsara", null, "2000-01-01"));
        assertFalse(RegistrationService.register("dilmi", "punsara", "dilmi123@gmail.com", null));
    }
}
