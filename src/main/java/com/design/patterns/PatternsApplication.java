package com.design.patterns;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		User user = new User("Juan", "admin");

		SessionManager sessionManager = new SessionManager();

		try{
			Session session = sessionManager.createSession(user, "high/dashboard");
			session.getSession();
		} catch (InsufficientRightsException ex){
			System.err.println(ex.getMessage());
		}

	}
}
