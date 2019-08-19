package dao;

import entity.User;

public interface UserDao {

    User getUser(String login);

}
