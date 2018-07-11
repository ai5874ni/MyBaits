package com.smart.more.dao;

import com.smart.more.model.Group;
import com.smart.more.model.User;

import java.util.List;

public interface IUserGroup {
 List<User> getUsersByGroupId(int groupId);
 List<Group> getGroupsByUserId(int userId);
}
