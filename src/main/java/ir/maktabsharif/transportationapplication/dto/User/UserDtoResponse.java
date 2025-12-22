package ir.maktabsharif.transportationapplication.dto.User;

import ir.maktabsharif.transportationapplication.model.Role;
import jakarta.validation.constraints.NotNull;

public record UserDtoResponse(
   @NotNull String name,

   @NotNull Role role
) {}
