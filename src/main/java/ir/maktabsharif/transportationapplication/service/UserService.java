package ir.maktabsharif.transportationapplication.service;

import ir.maktabsharif.transportationapplication.dto.User.UserDtoRequest;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoResponse;
import ir.maktabsharif.transportationapplication.model.User;

import java.util.List;

public interface UserService extends BaseService<User>{
    UserDtoResponse entityToDto(User user);
    User dtoToEntity(UserDtoRequest userDto);
    List<UserDtoResponse> getAllUsers();
    UserDtoResponse saveOrUpdateUser(UserDtoRequest userDtoRequest);
    UserDtoResponse findUserById(Integer id);
    void deleteUserById(Integer id);
}
