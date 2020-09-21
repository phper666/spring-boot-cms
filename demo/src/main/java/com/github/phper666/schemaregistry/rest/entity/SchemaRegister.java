package com.github.phper666.schemaregistry.rest.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 3:09 下午
 * @software IntelliJ IDEA
 */
@TableName("schema_register")
@Data
public class SchemaRegister implements Serializable {
    private Long id;

    private String schemaVersion;

    private String schemaId;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject schemaData;

    private String schemaType;

    @TableField(fill = FieldFill.INSERT)
    private Long createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedAt;

    @JsonCreator
    public SchemaRegister(@JsonProperty("schema_version") String schemaVersion,
                          @JsonProperty("id") Long id,
                          @JsonProperty("schema_id") String schemaId,
                          @JsonProperty("schema_data") JSONObject schemaData,
                          @JsonProperty("created_at") Long createdAt,
                          @JsonProperty("updated_at") Long updatedAt,
                          @JsonProperty("schema_type") String schemaType) {
        this.schemaVersion = schemaVersion;
        this.id = id;
        this.schemaType = schemaType != null ? schemaType : "AVRO";
        this.schemaData = schemaData;
        this.schemaId = schemaId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SchemaRegister() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchemaRegister schema1 = (SchemaRegister) o;
        return Objects.equals(id, schema1.id)
                && Objects.equals(schemaVersion, schema1.schemaVersion)
                && Objects.equals(schemaId, schema1.schemaId)
                && Objects.equals(id, schema1.id)
                && Objects.equals(schemaType, schema1.schemaType)
                && Objects.equals(schemaData, schema1.schemaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schemaVersion, schemaData, schemaType);
    }
}