package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServiceImpl implements UserService{


    private UserDao userDao = new UserDaoImpl();

    public UserServiceImpl(){};

    public boolean checkIfValid(String login, String password){
        User user = userDao.getUser(login);

        return user != null
                && user.getLogin().equals(login)
                && user.getPassword().equals(password);
    }

}
