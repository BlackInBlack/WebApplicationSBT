package ru.aniskin.services;

import ru.aniskin.models.User;

public class AccountServiceImpl implements AccountService{
    @Override
    public boolean authenticate(String userLogin, String userPassword) {

        if(userPassword == null || userLogin.length() < 1 || userLogin == null) {
            return false;
        }
        return true;
    }

    @Override
    public int testData(String login, String password1, String password2, String email) {
        UserService userService = new UserServiceImpl();
        User user;
        try {
           user = userService.findUserByLogin(login);
        } catch (Exception e) {
            user = null;
        }
        if(user != null) {
            return -1;
        }
        else {
            if(login.length()>2 && email.contains("@") && email.length()>5 && password1.length()>2 && password1.equals(password2)) {
                User newUser = new User(login,password1,email);
                userService.saveUser(newUser);
                userService.updateUser(newUser);
                return 1;
            }
            else {
                return 0;
            }
        }

    }
}
