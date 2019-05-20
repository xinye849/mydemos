package xin.yuan.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xin.yuan.entity.Friend;
import xin.yuan.entity.User;
import xin.yuan.service.UserService;

import static org.junit.Assert.*;

public class UserMapperTest {
ApplicationContext ac;
    @Before
    public void setUp() throws Exception {

       ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void findTestByIdTest(){
        UserService userService = (UserService) ac.getBean("userService");


        User user = userService.findUserById(3);
        System.out.println("======"+user+"=======");
    }

    @Test
    public void findFriendByIdGenerator(){
        FriendMapper friendMapper = (FriendMapper) ac.getBean("friendMapper");
        Friend friend = friendMapper.selectByPrimaryKey(3);
        System.out.println("========="+friend+"======");
    }
}