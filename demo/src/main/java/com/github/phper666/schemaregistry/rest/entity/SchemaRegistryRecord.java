package com.github.phper666.schemaregistry.rest.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 3:09 下午
 * @software IntelliJ IDEA
 */
@TableName("schema_registry_record")
@Data
public class SchemaRegistryRecord implements Serializable {
    private Long id;

    private Long schemaRegistryId;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject oldSchemaData;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject editSchemaData;

    @TableField(fill = FieldFill.INSERT)
    private Long createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedAt;
}