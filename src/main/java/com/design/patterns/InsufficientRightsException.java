package com.design.patterns;

public class InsufficientRightsException extends RuntimeException {

    private User user;
    public String accessedPath;
    public InsufficientRightsException(User user, String accessedPath) {
        super("User " + user.getName() + " does not have rights to access " + accessedPath);
        this.user = user;
        this.accessedPath = accessedPath;
    }
}
