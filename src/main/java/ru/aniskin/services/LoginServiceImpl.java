package ru.aniskin.services;

public class LoginServiceImpl implements LoginService{
    @Override
    public boolean authenticate(String userLogin, String userPassword) {

        if(userPassword == null || userLogin.length() < 1 || userLogin == null) {
            return false;
        }
        return true;
    }
}
