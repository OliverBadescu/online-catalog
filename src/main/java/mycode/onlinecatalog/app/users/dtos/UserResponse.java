package mycode.onlinecatalog.app.users.dtos;

import mycode.onlinecatalog.app.system.security.UserRole;

public record UserResponse(long id, String email, String password, String fullName, String phone, UserRole userRole) {
}
