package com.smart.moretomore.dao;

import com.smart.moretomore.model.User;

import java.util.List;

public interface IUser {
    public List<User> getUser(int groupId);
}
