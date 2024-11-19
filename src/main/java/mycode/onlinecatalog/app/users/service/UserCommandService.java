package mycode.onlinecatalog.app.users.service;

import mycode.onlinecatalog.app.users.dtos.CreateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UpdateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UserResponse;

public interface UserCommandService {

    UserResponse createUser(CreateUserRequest createUserRequest);

    UserResponse deleteUser(long id);

    UserResponse updateUser(UpdateUserRequest updateUserRequest, long id);

}
