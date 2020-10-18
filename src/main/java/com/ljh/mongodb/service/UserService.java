package com.ljh.mongodb.service;

import com.ljh.mongodb.bean.User;
import com.ljh.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findOne(String id){
        return userRepository.findById(id).get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public int modifyAgeById(int age,String id){
        return userRepository.modifyAgeById(age,id);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
