package com.design.patterns;

public class AccessChecker {
    private static AccessChecker instance;

    public static AccessChecker getInstance() {
        if (instance == null) {
            instance = new AccessChecker();
        }
        return instance;
    }

    private ServerConfig config = ServerConfig.getInstance();

    private AccessChecker() {
        System.out.println("AccessChecker initialized.");
    }

    public boolean mayAccess(User user, String path) {
        String userLevel = config.getAccessLevel(user);
        String pathLevelValue = path.substring(0, path.indexOf('/'));
        return userLevel != null && userLevel.equalsIgnoreCase(pathLevelValue);
    }

}
