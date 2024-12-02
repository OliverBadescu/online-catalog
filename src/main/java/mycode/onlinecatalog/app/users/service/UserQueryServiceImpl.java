package mycode.onlinecatalog.app.users.service;

import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.dtos.UserResponseList;
import mycode.onlinecatalog.app.users.exceptions.NoUserFound;
import mycode.onlinecatalog.app.users.mapper.UserMapper;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserQueryServiceImpl implements UserQueryService{

    private UserRepository userRepository;

    @Override
    public UserResponse findUserById(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));

        return UserMapper.userToResponseDto(user);
    }

    @Override
    public UserResponseList getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        list.forEach(user -> {
            responses.add(UserMapper.userToResponseDto(user));
        });

        return new UserResponseList(responses);
    }
}
