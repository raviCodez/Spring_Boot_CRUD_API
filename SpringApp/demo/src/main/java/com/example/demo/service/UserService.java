package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        // add user
        public User addUser(User user) {
            return userRepository.save(user);
        }

        // get user
        public List<User> getUsers() {
            return userRepository.findAll();  
        }


        //update user
        public User updateUser(User user , int id) {
            User updateUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            return userRepository.save(updateUser);
        }

        //delete user
        public void deleteUser(int id) {
            userRepository.deleteById(id);
        }
}
