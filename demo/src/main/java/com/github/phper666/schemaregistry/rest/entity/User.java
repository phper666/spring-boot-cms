package com.github.phper666.schemaregistry.rest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 2:02 下午
 * @software IntelliJ IDEA
 */
@TableName("user")
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
}
