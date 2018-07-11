package com.smart.moretomore.dao;

import com.smart.moretomore.model.Group;
import com.smart.moretomore.model.User;

import java.util.List;

public interface IUserGroup {
    public List<Group> getGroupsByUserId(int id);
    public List<User> getUsersByGroupId(int id);
}
