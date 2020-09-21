package com.github.phper666.schemaregistry.rest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.phper666.schemaregistry.rest.entity.User;
import com.github.phper666.schemaregistry.rest.mapper.UserMapper;
import com.github.phper666.schemaregistry.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 2:14 下午
 * @software IntelliJ IDEA
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User test() {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("username", "test");
        return userMapper.selectOne(qw);
    }
}
