package mycode.onlinecatalog.app.users.dtos;


import mycode.onlinecatalog.app.system.security.UserRole;

public record RegisterResponse(String jwtToken,
                               String fullName,
                               String phone,
                               String email,
                               UserRole userRole) {
}
