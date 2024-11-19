package mycode.onlinecatalog.app.users.web;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.users.dtos.CreateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UpdateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.service.UserCommandService;
import mycode.onlinecatalog.app.users.service.UserQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private UserCommandService userCommandService;
    private UserQueryService userQueryService;
    
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId){
        return new ResponseEntity<>(userQueryService.findUserById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody CreateUserRequest createUserRequest){
        return new ResponseEntity<>(userCommandService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long userId){
        return new ResponseEntity<>(userCommandService.deleteUser(userId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest updateUserRequest){
    return new ResponseEntity<>(userCommandService.updateUser(updateUserRequest, userId), HttpStatus.ACCEPTED);
    }
}
