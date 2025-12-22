package ir.maktabsharif.transportationapplication.service.impl;

import ir.maktabsharif.transportationapplication.dto.User.UserDtoRequest;
import ir.maktabsharif.transportationapplication.dto.User.UserDtoResponse;
import ir.maktabsharif.transportationapplication.model.User;
import ir.maktabsharif.transportationapplication.repository.UserRepository;
import ir.maktabsharif.transportationapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository jpaRepository) {
        super(jpaRepository);
        this.userRepository=jpaRepository;
    }
    @Override
    public List<UserDtoResponse> getAllUsers(){
        return userRepository.findAll().stream().map(user->new UserDtoResponse(user.getName(), user.getRole())).toList();
    }
    @Override
    public UserDtoResponse saveOrUpdateUser(UserDtoRequest userDtoRequest){
        User user = dtoToEntity(userDtoRequest);
        User save = userRepository.save(user);
        return entityToDto(save);
    }

    @Override
    public UserDtoResponse findUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        return entityToDto(user);
    }

    @Override
    public void deleteUserById(Integer id) {
         userRepository.deleteById(id);

    }

    @Override
    public UserDtoResponse entityToDto(User user) {
        return new UserDtoResponse(user.getName(), user.getRole());
    }

    @Override
    public User dtoToEntity(UserDtoRequest userDto) {
        return User.builder()
                .name(userDto.name())
                .password(userDto.password())
                .role(userDto.role())
                .build();
    }

}
