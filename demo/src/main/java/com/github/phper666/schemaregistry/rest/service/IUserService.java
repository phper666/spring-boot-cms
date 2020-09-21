package com.github.phper666.schemaregistry.rest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.phper666.schemaregistry.rest.entity.User;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 2:13 下午
 * @software IntelliJ IDEA
 */
public interface IUserService extends IService<User> {

    User test();
}
