package xin.yuan.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xin.yuan.entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @authorknightx
 * @create2019/3/4
 * @since 1.0.0
 */
public class UserDao {
    @Test
    //查询一条记录
    public void findUserByName(){
        InputStream in = null;

        //mybaties的配置文件
        String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";
//将配置文件读入输入流中
        try {
             in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlsession操作数据库,dao.findUserByName:namespace+sql语句标识符id
       User user = sqlSession.selectOne("dao.findUserByName","zs");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    //查询多条记录
    public void findUserByNames(){
        InputStream in = null;

        //mybaties的配置文件
        String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";
//将配置文件读入输入流中
        try {
            in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
            User u = new User();
            u.setName("zs");
        //通过sqlsession操作数据库,dao.findUserByName:namespace+sql语句标识符id,"zs%'OR name like '%ls"插入这句可对${}进行sql注入
        List<User> user = sqlSession.selectList("dao.findUserByNames",u);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    //添加记录
    public void addUser(){
        InputStream in = null;

        //mybaties的配置文件
        String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";
//将配置文件读入输入流中
        try {
            in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlsession操作数据库,
        User u = new User();
        u.setName("xiong");
        u.setSex("m");
        u.setMoney(1000);
        sqlSession.insert("dao.addUser",u);
        System.out.println("添加用户成功");
        //手动提交事务
        sqlSession.commit();
        System.out.println(u.getMyId());
        //关闭session
        sqlSession.close();
    }
@Test
//删除操作
    public void deleteUserById(){
        InputStream in = null;

        //mybaties的配置文件
        String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";
//将配置文件读入输入流中
        try {
            in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlsession操作数据库,
        User u = new User();
        u.setMyId(7);
        sqlSession.delete("dao.deleteUserById",u);
        System.out.println("删除用户成功");
        //手动提交事务
        sqlSession.commit();

        //关闭session
        sqlSession.close();
    }

    @Test
//跟新操作
    public void updateUser(){
        InputStream in = null;

        //mybaties的配置文件
        String resource = "E:\\ideaWorkspace\\mybatis\\src\\main\\resource\\SqlMapConfig.xml";
//将配置文件读入输入流中
        try {
            in  = new FileInputStream(new File(resource));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        //通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlsession操作数据库,
        User u = new User();
        u.setMyId(6);
        u.setName("hxxxahaha");
        u.setMoney(1210);
        u.setSex("f");
        sqlSession.update("dao.updateUser",u);
        System.out.println("跟新用户成功");
        //手动提交事务
        sqlSession.commit();

        //关闭session
        sqlSession.close();
    }
}
