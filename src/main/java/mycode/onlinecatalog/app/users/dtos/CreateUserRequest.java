package mycode.onlinecatalog.app.users.dtos;

import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotNull String fullName,
                                @NotNull String email,
                                @NotNull String password,
                                @NotNull String phone) {
}
