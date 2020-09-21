package com.github.phper666.schemaregistry.rest.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/18 10:27 上午
 * @software IntelliJ IDEA
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert field....");
        Long time = System.currentTimeMillis();
        this.setFieldValByName("createdAt", time, metaObject);
        this.setFieldValByName("updatedAt", time, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedAt", System.currentTimeMillis(), metaObject);
    }
}
