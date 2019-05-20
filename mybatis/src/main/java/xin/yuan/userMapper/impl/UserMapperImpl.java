package xin.yuan.userMapper.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xin.yuan.entity.User;
import xin.yuan.userMapper.UserMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @authorknightx
 * @create2019/3/5
 * @since 1.0.0
 * 通过mapper代理开发，用map接口代替传统的dao接口，直接通过mapper代理接口，从而不需要执行更多的增删改查操作，直接通过接口方法映射到map文件中。
 */
public class UserMapperImpl implements UserMapper {

        private SqlSessionFactory sqlSessionFactory;
    @Override
    public User findUserById(int id) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建mapper代理对象，UserMapper接口=传统dao接口
         UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
         //接口方法必须要跟map映射文件中的statement ID一致，否则无法完成映射
         User u = userMapper.findUserById(5);
         System.out.println("====="+u+"======");



        return u;
    }

    @Override
    public User findUserByIdForResultMap(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper u = sqlSession.getMapper(UserMapper.class);
        User user = u.findUserByIdForResultMap(5);
        return user;
    }
}
