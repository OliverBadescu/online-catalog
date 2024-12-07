package mycode.onlinecatalog.app.users.service;

import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.dtos.UserResponseList;
import mycode.onlinecatalog.app.users.model.User;

public interface UserQueryService {

    UserResponse findUserById(long id);

    UserResponseList getAllUsers();

    User findByEmail(String email);

}
