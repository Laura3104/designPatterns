package com.design.patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SessionManagerTest {

    private SessionManager sessionManager;

    private User user;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        user = new User("Juan", "admin");
        sessionManager = new SessionManager();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCreateSession(){
        Session session = sessionManager.createSession(user, "high/dashboard");
        session.getSession();
        Assertions.assertEquals("Session created for user : Juan\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testCreateSessionException(){
        Assertions.assertThrowsExactly(InsufficientRightsException.class, () -> {
            sessionManager.createSession(user, "medium/dashboard");
        });
    }
}
