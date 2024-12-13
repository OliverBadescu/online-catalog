package mycode.onlinecatalog.app.users.dtos;


import mycode.onlinecatalog.app.system.security.UserRole;

public record LoginResponse(String jwtToken,
                            Long id,
                            String fullName,
                            String phone,
                            String email,
                            UserRole userRole) {
}
