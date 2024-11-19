package mycode.onlinecatalog.app.users.service;

import mycode.onlinecatalog.app.users.dtos.UserResponse;

public interface UserQueryService {

    UserResponse findUserById(long id);

}
