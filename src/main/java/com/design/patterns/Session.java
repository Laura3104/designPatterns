package com.design.patterns;

import java.time.LocalDateTime;

public class Session {
    private User user;
    private LocalDateTime creationTime;

    public Session(User user){
        this.user = user;
        this.creationTime = LocalDateTime.now();
    }

    public void getSession(){
        System.out.println("Session created for user : " + user.getName());
    }
}
