package xin.yuan.userMapper;

import xin.yuan.entity.User;

public interface UserMapper {
    User findUserById(int id);
    User findUserByIdForResultMap(int id);
}
