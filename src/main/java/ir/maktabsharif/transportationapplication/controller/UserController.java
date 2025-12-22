package ir.maktabsharif.transportationapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.maktabsharif.transportationapplication.dto.Purchase.PurchaseDtoResponse;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoRequest;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoResponse;
import ir.maktabsharif.transportationapplication.service.PurchaseService;
import ir.maktabsharif.transportationapplication.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User APIs", description = "APIs for managing Users")
public class UserController {
    private final UserService userService;
    private final PurchaseService purchaseService;


    @GetMapping
    @Operation(summary = "return the list of all users ")
    public List<UserDtoResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "use this for saving or updating a user in database")
    public UserDtoResponse saveOrUpdateUser(@RequestBody UserDtoRequest userDtoRequest) {
        return userService.saveOrUpdateUser(userDtoRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "find a user by the id")
    public UserDtoResponse findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a user by id")
    public void deleteUserById(@PathVariable Integer id) {
       userService.deleteUserById(id);
    }

    @GetMapping("/purchases/{userId}")
    public List<PurchaseDtoResponse> getUserPurchases(@PathVariable Integer userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }
}
