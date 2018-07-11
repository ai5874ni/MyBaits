package com.smart;

import com.smart.curd.CurdTest;
import com.smart.more.TestMore;
import com.smart.moretomore.TestMTM;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

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

    public static void main(String args[]) {
//        CurdTest curdTest=new CurdTest();
//        curdTest.setSqlSessionFactory(getSession());
//        curdTest.testUpdate();

//        TestMTM curdTest=new TestMTM();
//        curdTest.setSqlSessionFactory(getSession());
//        curdTest.testGetGroupAndUsers();

        TestMore testMore=new TestMore();
        testMore.setSqlSessionFactory(getSession());
        testMore.testGetGroupAndUsers();

    }
}
