package ir.maktabsharif.transportationapplication.dto.User;

import ir.maktabsharif.transportationapplication.model.Role;
import jakarta.validation.constraints.NotNull;

public record UserDtoRequest(
        @NotNull String name,
        @NotNull String password,
        @NotNull Role role
) {}
