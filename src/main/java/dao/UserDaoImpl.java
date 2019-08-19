package dao;

import entity.User;

public class UserDaoImpl implements UserDao {


        @Override
        public User getUser(String login) {

            if (login.equals("login")) {
                return new User("login", "pwd");
            }

            return null;
        }

}
