package com.smart.more;

import com.smart.more.dao.IGroup;
import com.smart.more.dao.IUser;
import com.smart.more.model.Group;
import com.smart.more.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TestMore {
    private SqlSessionFactory sqlSessionFactory;

    public  void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public  void testGetGroupAndUsers() {
       SqlSession session= sqlSessionFactory.openSession();
        IGroup gp=session.getMapper(IGroup.class);
        Group g=gp.getGroup(1);
        List<User> users=g.getUsers();
        System.out.println("Group=>"+g.getGroupName());
        for (User u:users) {
            System.out.println(u.getUsername());
        }
        IUser iu= session.getMapper(IUser.class);
    User user=iu.getUser(1);
        System.out.println("UserName=>"+user.getUsername());
   List<Group> groups= user.getGroups();
        for (Group group:groups) {
            System.out.println(group.getGroupName());
        }
    }

}
