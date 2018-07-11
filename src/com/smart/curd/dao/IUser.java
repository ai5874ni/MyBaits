package com.smart.curd.dao;

import com.smart.curd.model.User;

import java.util.List;

public interface  IUser {
    public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(int userId, User user);

    public void deleteUser(int id);

    public User getUser(int id);


}
