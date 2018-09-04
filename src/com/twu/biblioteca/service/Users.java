package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public List<String> username = new ArrayList<String>();
    public List<String> password = new ArrayList<String>();
    public List<String> phone = new ArrayList<String>();
    public List<String> mail = new ArrayList<String>();

    public void usernameInitial(){
        username.add("tom-008");
        username.add("ellen--008");
        username.add("xiaochu-008");
    }
    public void passwordInitial(){
        password.add("likeEllen");
        password.add("likeTom");
        password.add("isSon");
    }
    public void phoneInitial(){
        phone.add("13600989874");
        phone.add("17613214124");
        phone.add("18731241241");
    }
    public void mailInitial(){
        mail.add("chinamobile@eqweq.com");
        mail.add("thoughtworks@dwafaw.com");
        mail.add("google@wadawd.com");
    }

    public String verify(String userName,String passWord){
        for(int i=0;i<username.size();i++){
            if(username.get(i).equals(userName) && password.get(i).equals(passWord)){
                System.out.println("\nWelcome! here are your informations : ");
                System.out.println(username.get(i)+ "----"+phone.get(i)+"-----" +mail.get(i)+"\n");
                return "OK";
                }
            }
            return "REFUSE";
        }

    public int login(String userName,String passWord){
        usernameInitial();
        passwordInitial();
        phoneInitial();
        mailInitial();
        if(verify(userName,passWord)=="OK") return 1;
        else return 0;
    }
}
