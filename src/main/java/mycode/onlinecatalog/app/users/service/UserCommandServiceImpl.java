package mycode.onlinecatalog.app.users.service;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.users.dtos.CreateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UpdateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.exceptions.NoUserFound;
import mycode.onlinecatalog.app.users.exceptions.UserAlreadyExists;
import mycode.onlinecatalog.app.users.mapper.UserMapper;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserCommandServiceImpl implements UserCommandService{

    private UserRepository userRepository;


    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user  = User.builder()
                .phone(createUserRequest.phone())
                .password(createUserRequest.password())
                .fullName(createUserRequest.fullName())
                .email(createUserRequest.email())
                .build();

        List<User> list = userRepository.findAll();

        list.forEach( user1 -> {
            if(user.getEmail().equals(user1.getEmail())){
                throw new UserAlreadyExists("User with this email already exists");
            }
        });

        userRepository.saveAndFlush(user);

        return UserMapper.userToResponseDto(user);
    }

    @Override
    public UserResponse deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));


        UserResponse response = UserMapper.userToResponseDto(user);

        userRepository.delete(user);

        return response;
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest up, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));

        List<User> list = userRepository.findAll();
        list.remove(user);

        list.forEach( user1 -> {
            if(up.email().equals(user1.getEmail())){
                throw new UserAlreadyExists("User with this email already exists, please enter a different email address");
            }
        });
        user.setEmail(up.email());
        user.setFullName(up.fullName());
        user.setPassword(up.password());
        user.setPhone(up.phone());

        userRepository.save(user);

        return UserMapper.userToResponseDto(user);
    }
}
