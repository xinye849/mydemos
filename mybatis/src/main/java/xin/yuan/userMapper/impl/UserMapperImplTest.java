package xin.yuan.userMapper.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xin.yuan.entity.User;
import xin.yuan.userMapper.UserMapper;
import org.apache.ibatis.io.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserMapperImplTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {

        InputStream in = null;
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //mybaties的配置文件
      /*  String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";*//*
//将配置文件读入输入流中
        try {
            in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        //创建会话工厂
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void findUserById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.findUserById(5);
        System.out.println("====="+u+"======");
    }

    @Test
    public void findUserByIdForResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper u = sqlSession.getMapper(UserMapper.class);
        User user = u.findUserByIdForResultMap(5);
        System.out.println("====="+user+"======");
    }


    /*mybatis 默认开启一级缓存，不需手动开启，
    一级缓存就是在sqlsession不关闭的情况下，
    在第二次查询相同的数据时，不需向服务器发起请求，
    而是在第一次查询时会把数据存入sqlsession的hashmap，
    所以第二次查询直接从sqlsession中取数据
    如果sqlsession发起commit操作（增，删，改），会清除一级缓存，清除的
    目的是为了让hashmap中的数据保存最新，避免脏读。
    */

    @Test
    public void findUserByIdCache1(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper u = sqlSession.getMapper(UserMapper.class);
        //第一次发起查询请求，向服务器查询，并把查询存入hashmap中
        User user1 = u.findUserByIdForResultMap(5);
        System.out.println("====="+user1+"======");


        //第二次发起请求，不会向服务器发起请求，而是先向hashmap中查，查不到再向服务器查
        User user2 = u.findUserByIdForResultMap(5);
        System.out.println("====="+user2+"======");
        sqlSession.close();
    }


    /*mybatis ,默认关闭二级缓存，需手动开启
    * 二级缓存中，同一个namespace中的sqlsession共享同一个二级缓存区
    * 如果相同namespace中的sqlsession发起commit操作（增，删，改），会清除该二级缓存，清除的
    目的是为了让hashmap中的数据保存最新，避免脏读。
    sqlsession必须close才会将数据加入二级缓存中

    */

    @Test
    public void findUserByIdCache2(){
//这三个sqlsession共享同一个二级缓存区
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper u1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper u2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper u3 = sqlSession3.getMapper(UserMapper.class);
        //第一次发起查询请求，向服务器查询，并把查询存入hashmap中
        User user1 = u1.findUserByIdForResultMap(5);
        System.out.println("====="+user1+"======");
        //必须close才会提交到二级缓存
        sqlSession1.close();

        sqlSession3.commit();
        User user2 = u2.findUserByIdForResultMap(5);





        System.out.println("====="+user2+"======");
    }
}