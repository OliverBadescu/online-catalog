package mycode.onlinecatalog.app.users.web;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.users.dtos.CreateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UpdateUserRequest;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.dtos.UserResponseList;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.service.UserCommandService;
import mycode.onlinecatalog.app.users.service.UserQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    private UserCommandService userCommandService;
    private UserQueryService userQueryService;
    
    @GetMapping(path = "/getUserById/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId){
        return new ResponseEntity<>(userQueryService.findUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody CreateUserRequest createUserRequest){
        return new ResponseEntity<>(userCommandService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable long userId){
        return new ResponseEntity<>(userCommandService.deleteUser(userId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest updateUserRequest){
    return new ResponseEntity<>(userCommandService.updateUser(updateUserRequest, userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<UserResponseList> getAllUsers(){
        return new ResponseEntity<>(userQueryService.getAllUsers(),HttpStatus.OK);
    }
}
