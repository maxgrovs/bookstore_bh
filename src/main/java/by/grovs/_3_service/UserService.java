package by.grovs._3_service;
import by.grovs._4_entity.User;

import java.util.List;

public interface UserService {

    //crud

    //create
    User addUser(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    User editUser(User user);

    //delete
    void delete(Long id);



}
