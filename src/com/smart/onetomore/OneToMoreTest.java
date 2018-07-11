package com.smart.onetomore;

import com.smart.onetomore.dao.IUser;
import com.smart.onetomore.model.Post;
import com.smart.onetomore.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

public class OneToMoreTest {
    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;


    static {
        try {
            reader = Resources.getResourceAsReader("config/Config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getUserList();

    }
    // 获取用户列表
    public static void getUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            IUser iuser = session.getMapper(IUser.class);
            // 显示User信息
            System.out.println("Test Get start...");
            printUsers(iuser.getPosts(1));
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printUsers(final List<Post> posts) {

        for (Post post :posts) {
            System.out.println(post.getId());
            System.out.println(post.getTitle());
        }
    }
}
