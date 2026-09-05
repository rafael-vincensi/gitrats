package com.gitrats.user;

import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserId(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userUpdate) {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (userUpdate.getDisplayName() != null) user.setDisplayName(userUpdate.getDisplayName());
            if (userUpdate.getBio() != null) user.setBio(userUpdate.getBio());
            if (userUpdate.getProfilePicture() != null) user.setProfilePicture(
                    userUpdate.getProfilePicture());

            return userRepository.save(user);
        }
        return null;
    }

    public List<User> searchBar(String query){
        return userRepository.findByUsernameContainingIgnoreCaseOrDisplayNameContainingIgnoreCase(query, query);
    }
}
