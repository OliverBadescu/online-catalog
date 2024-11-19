package mycode.onlinecatalog.app.users.service;

import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.exceptions.NoUserFound;
import mycode.onlinecatalog.app.users.mapper.UserMapper;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
