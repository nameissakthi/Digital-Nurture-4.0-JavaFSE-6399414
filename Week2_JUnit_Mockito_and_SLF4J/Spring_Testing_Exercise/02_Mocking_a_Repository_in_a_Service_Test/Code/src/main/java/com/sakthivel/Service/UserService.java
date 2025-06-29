package com.sakthivel.Service;

import com.sakthivel.Model.User;
import com.sakthivel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repo;

    public UserService( @Autowired UserRepository repo) {
        this.repo = repo;
    }

    public User getUserById(Long id){
        return repo.findById(id).orElse(null);
    }
}
