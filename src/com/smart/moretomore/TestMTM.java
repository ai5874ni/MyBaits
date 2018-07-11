package com.smart.moretomore;

import com.smart.curd.CurdTest;
import com.smart.moretomore.dao.IGroup;
import com.smart.moretomore.model.Group;
import com.smart.moretomore.model.User;
import com.smart.moretomore.model.UserGroup;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TestMTM {
    private  SqlSessionFactory sqlSessionFactory;

    public  void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public  void testGetGroupAndUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IGroup groupMaper = session.getMapper(IGroup.class);
            Group group = groupMaper.getGropById(1);
            System.out.println("Group => " + group.getGroupName());
            List<User> users = group.getUsers();
            for (User user : users) {
                System.out.println("\t:" + user.getId() + "\t"
                        + user.getUsername());
            }
        } finally {
            session.close();
        }
    }

}
