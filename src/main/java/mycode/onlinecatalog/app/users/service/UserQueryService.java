package mycode.onlinecatalog.app.users.service;

import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.dtos.UserResponseList;

public interface UserQueryService {

    UserResponse findUserById(long id);

    UserResponseList getAllUsers();

}
