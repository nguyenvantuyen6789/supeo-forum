package com.tuyennguyen.supeo.forum.service;

import com.tuyennguyen.supeo.forum.entity.User;
import com.tuyennguyen.supeo.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll() {
        List<User> users = userRepo.findAll();
        users.removeIf(user -> user.getUsername().equals("nguyenvantuyen6789"));
        return users;
    }

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

}
