package by.grovs._5_dao;
import by.grovs._4_entity.User;

import java.util.List;

public interface UserDao {

    //read
    List<User> getUsers();

    User getById(Long id);

}
