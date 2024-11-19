package mycode.onlinecatalog.app.users.dtos;

public record UserResponse(long id,String email, String password, String fullName, String phone) {
}
