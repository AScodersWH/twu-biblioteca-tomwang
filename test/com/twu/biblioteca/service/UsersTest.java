package com.twu.biblioteca.service;


import com.twu.biblioteca.model.Users;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Test
    public void shouldUserInitialSuccess() {
        Users users = new Users();
        UserService userService = new UserService();
        userService.usernameInitial(users);
        List<String> testUsername = new ArrayList<String>();

        testUsername.add("tom-008");
        testUsername.add("ellen--008");
        testUsername.add("xiaochu-008");
        assertEquals(users.username, testUsername);
    }

    @Test
    public void shouldPasswordInitialSuccess() {
        Users users = new Users();
        UserService userService = new UserService();

        userService.passwordInitial(users);
        List<String> testPassword = new ArrayList<String>();
        testPassword.add("likeEllen");
        testPassword.add("likeTom");
        testPassword.add("isSon");

        assertEquals(users.password, testPassword);
    }

    @Test
    public void shouldPhoneInitialSuccess() {
        Users users = new Users();
        UserService userService = new UserService();

        userService.phoneInitial(users);
        List<String> testPhone = new ArrayList<String>();
        testPhone.add("13600989874");
        testPhone.add("17613214124");
        testPhone.add("18731241241");
        assertEquals(users.phone, testPhone);
    }

    @Test
    public void shouldMailInitialSuccess() {
        Users users = new Users();
        UserService userService = new UserService();

        userService.mailInitial(users);
        List<String> testMail = new ArrayList<String>();
        testMail.add("chinamobile@eqweq.com");
        testMail.add("thoughtworks@dwafaw.com");
        testMail.add("google@wadawd.com");
        assertEquals(users.mail, testMail);
    }

    @Test
    public void shouldVerifySuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Users users = new Users();
        UserService userService = new UserService();

        userService.passwordInitial(users);
        userService.usernameInitial(users);
        userService.mailInitial(users);
        userService.phoneInitial(users);

        assertEquals(userService.verify(users,"tom-008", "likeEllen"), "OK");
        assertEquals(outContent.toString(), "\nWelcome! here are your informations : \n" +
                "tom-008----13600989874-----chinamobile@eqweq.com\n\n");
    }

    @Test
    public void shouldVerifyFail_by_username() {
        Users users = new Users();
        UserService userService = new UserService();

        userService.passwordInitial(users);
        userService.usernameInitial(users);
        userService.mailInitial(users);
        userService.phoneInitial(users);

        assertEquals(userService.verify(users,"tom-009", "likeEllen"), "REFUSE");
    }

    @Test
    public void shouldVerifyFail_by_password() {
        Users users = new Users();
        UserService userService = new UserService();

        userService.passwordInitial(users);
        userService.usernameInitial(users);
        userService.mailInitial(users);
        userService.phoneInitial(users);

        assertEquals(userService.verify(users,"tom-008", "likeEllens"), "REFUSE");
    }

    @Test
    public void shouldLoginSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Users users = new Users();
        UserService userService = new UserService();

        assertEquals(userService.login(users,"tom-008", "likeEllen"), 1);
        assertEquals(outContent.toString(), "\nWelcome! here are your informations : \n" +
                "tom-008----13600989874-----chinamobile@eqweq.com\n\n");
    }

    @Test
    public void shouldLoginFail_by_username() {

        Users users = new Users();
        UserService userService = new UserService();

        assertEquals(userService.login(users,"tom-009", "likeEllen"), 0);

    }

    @Test
    public void shouldLoginFail_by_password() {

        Users users = new Users();
        UserService userService = new UserService();

        assertEquals(userService.login(users,"tom-008", "likeEllens"), 0);
    }

}