package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Users;

public class UserService {
    public void usernameInitial(Users users){
        users.username.add("tom-008");
        users.username.add("ellen--008");
        users.username.add("xiaochu-008");
    }
    public void passwordInitial(Users users){
        users.password.add("likeEllen");
        users.password.add("likeTom");
        users.password.add("isSon");
    }
    public void phoneInitial(Users users){
        users.phone.add("13600989874");
        users.phone.add("17613214124");
        users.phone.add("18731241241");
    }
    public void mailInitial(Users users){
        users.mail.add("chinamobile@eqweq.com");
        users.mail.add("thoughtworks@dwafaw.com");
        users.mail.add("google@wadawd.com");
    }

    public String verify(Users users, String userName,String passWord){
        for(int i=0;i<users.username.size();i++){
            if(users.username.get(i).equals(userName) && users.password.get(i).equals(passWord)){
                System.out.println("\nWelcome! here are your informations : ");
                System.out.println(users.username.get(i)+ "----"+users.phone.get(i)+"-----" +users.mail.get(i)+"\n");
                return "OK";
            }
        }
        return "REFUSE";
    }

    public int login(Users users, String userName,String passWord){
        usernameInitial(users);
        passwordInitial(users);
        phoneInitial(users);
        mailInitial(users);
        if(verify(users,userName,passWord)=="OK") return 1;
        else return 0;
    }
}
