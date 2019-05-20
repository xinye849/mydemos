package xin.yuan.service.impl;

import xin.yuan.entity.User;
import xin.yuan.mapper.FriendMapper;
import xin.yuan.mapper.UserMapper;
import xin.yuan.service.UserService;

/**
 * @authorknightx
 * @create2019/3/10
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {
private FriendMapper friendMapper;

    public void setFriendMapper(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public User findUserById(int id) {

        User user = userMapper.findUserById(id);
        return null;
    }
}
