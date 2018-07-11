package com.smart.curd;

import com.smart.curd.dao.IUser;
import com.smart.curd.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

public class CurdTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        CurdTest.sqlSessionFactory = sqlSessionFactory;
    }



    public  void testUpdate() {
        SqlSession session = sqlSessionFactory.openSession();
        IUser userMapper = session.getMapper(IUser.class);
        User user = new User();
        user.setWebsite("setWebsite");
        user.setPhone("183");
        user.setName("chuange");
        user.setDept("dept");
        userMapper.updateUser(1, user);
        session.commit();
        // 显示更新之后User信息
        System.out.println("After update");
        getUserList();
        System.out.println("Test update finished...");

    }

    public  void tentInsert() {
        SqlSession session = sqlSessionFactory.openSession();
        IUser userMapper = session.getMapper(IUser.class);
        User user = new User();
        user.setDept("dept");
        user.setName("lyl");
        user.setPhone("183");
        user.setWebsite("www.smart.con");
        userMapper.insertUser(user);
        session.commit();

        // 显示插入之后User信息
        System.out.println("After insert");
        getUserList();
        System.out.println("Test insert finished...");

    }

    // 获取用户列表
    public  void getUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            IUser iuser = session.getMapper(IUser.class);
            // 显示User信息
            System.out.println("Test Get start...");
            printUsers(iuser.getUserList());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  void printUsers(final List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format(
                    "============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Dept: " + user.getDept());
            System.out.println("User Website: " + user.getWebsite());
        }
    }


}
