package com.github.phper666.schemaregistry.rest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.phper666.schemaregistry.rest.entity.SchemaRegistry;
import com.github.phper666.schemaregistry.rest.exception.SchemaRegistryException;
import com.github.phper666.schemaregistry.rest.vo.SchemaRegistryVo;

import java.util.List;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 10:24 上午
 * @software IntelliJ IDEA
 */
public interface ISchemaRegistryService extends IService<SchemaRegistry> {
    /**
     * 根据schemaid获取最新的schema版本的数据
     * @param schemaId
     * @return
     */
//    Schema getSchemaLatestVersion(String schemaId);

    /**
     * 根据schemaid和版本号获取schema
     * @param schemaId
     * @param version
     * @return
     */
    SchemaRegistryVo getSchema(String schemaId, String version);

    /**
     *
     * @param schemaId
     * @return
     */
    Integer getSchemaCount(String schemaId);

    /**
     * 生成schema
     * @param schema
     * @return
     */
    SchemaRegistryVo createSchema(SchemaRegistry schema) throws SchemaRegistryException;

    /**
     * 生成schema
     * @param schemaId
     * @param schema
     * @return
     */
    SchemaRegistryVo createSchemaById(String schemaId, SchemaRegistry schema) throws SchemaRegistryException;

    /**
     * 会根据id来更新schema
     * @param schemaId
     * @param version
     * @param schema
     * @return
     */
    Integer updateSchema(String schemaId, String version, SchemaRegistry schema);

    /**
     * 删除指定的schema
     * @param schemaId
     * @param version
     * @return
     */
    Integer deleteSchema(String schemaId, String version);

    /**
     * 删除最新schema
     * @param schemaId
     * @return
     */
//    boolean deleteSchemaLatestVersion(String schemaId);

    /**
     * 根据schemaid获取所有的版本下的schema
     * @param schemaId
     * @return
     */
    List<SchemaRegistryVo> getAllVersions(String schemaId);
}
