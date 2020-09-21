package com.github.phper666.schemaregistry.rest.service.impl;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.phper666.schemaregistry.rest.entity.SchemaRegistry;
import com.github.phper666.schemaregistry.rest.entity.SchemaRegistryRecord;
import com.github.phper666.schemaregistry.rest.exception.SchemaRegistryException;
import com.github.phper666.schemaregistry.rest.mapper.SchemaRegistryMapper;
import com.github.phper666.schemaregistry.rest.mapper.SchemaRegistryRecordMapper;
import com.github.phper666.schemaregistry.rest.service.ISchemaRegistryService;
import com.github.phper666.schemaregistry.rest.vo.SchemaRegistryVo;
import org.apache.avro.Schema.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**id
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 10:25 上午
 * @software IntelliJ IDEA
 */
@Service
public class SchemaRegistryServiceImpl extends ServiceImpl<SchemaRegistryMapper, SchemaRegistry> implements ISchemaRegistryService {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public SchemaRegistryMapper schemaMapper;

    @Autowired
    public SchemaRegistryRecordMapper schemaRegistryRecordMapper;

    @Override
    public SchemaRegistryVo getSchema(String schemaId, String version) {
        logger.info("schema_id:" + schemaId + ",schema_version:" + version);

        QueryWrapper<SchemaRegistry> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        SchemaRegistry oneData = schemaMapper.selectOne(qw);
        return getSchemaRegistryVo(oneData);
    }

    @Override
    public List<SchemaRegistryVo> getAllVersions(String schemaId) {
        logger.info("id:" + schemaId);

        QueryWrapper<SchemaRegistry> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId);
        List<SchemaRegistry> list = schemaMapper.selectList(qw);
        List<SchemaRegistryVo> srvList = new ArrayList<>();
        list.forEach(SchemaRegistry -> {
            srvList.add(getSchemaRegistryVo(SchemaRegistry));
        });
        return srvList;
    }

    /**
     * 格式化时间
     * @param oneData
     * @return
     */
    private SchemaRegistryVo getSchemaRegistryVo(SchemaRegistry oneData) {
        SchemaRegistryVo srv = new SchemaRegistryVo();
        BeanUtils.copyProperties(oneData, srv);
        Date createdAt = DateUtil.date(oneData.getCreatedAt());
        Date updatedAt = DateUtil.date(oneData.getUpdatedAt());
        srv.setCreatedAt(DateUtil.formatDateTime(createdAt));
        srv.setUpdatedAt(DateUtil.formatDateTime(updatedAt));
        return srv;
    }

    @Override
    public Integer getSchemaCount(String schemaId) {
        QueryWrapper<SchemaRegistry> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId);
        Integer count = schemaMapper.selectCount(qw);

        logger.info("count:" + count);
        return count;
    }

    @Override
    public Integer deleteSchema(String schemaId, String version) {
        QueryWrapper<SchemaRegistry> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        return schemaMapper.delete(qw);
    }

    @Override
    public SchemaRegistryVo createSchema(SchemaRegistry schema) throws SchemaRegistryException {
        logger.debug(schema.getSchemaData());
        // 验证schema
        Parser sp = new Parser();
        sp.setValidate(true).parse(JSONUtil.toJsonStr(schema.getSchemaData()));

        // 生成版本号
        schema.setSchemaVersion(IdUtil.objectId());
        // 生成id
        schema.setSchemaId(IdUtil.objectId());
        Integer count = schemaMapper.insert(schema);
        if (count > 0) {
            SchemaRegistryRecord srrm = new SchemaRegistryRecord();
            srrm.setSchemaRegistryId(schema.getId());
            srrm.setOldSchemaData(schema.getSchemaData());
            srrm.setEditSchemaData(schema.getSchemaData());
            schemaRegistryRecordMapper.insert(srrm);
            return getSchemaRegistryVo(schema);
        }
        throw new SchemaRegistryException("添加数据失败", 400, 200);
    }

    @Override
    public SchemaRegistryVo createSchemaById(String schemaId, SchemaRegistry schema) throws SchemaRegistryException {
        logger.debug(schema.getSchemaData());
        // 验证schema
        Parser sp = new Parser();
        sp.setValidate(true).parse(JSONUtil.toJsonStr(schema.getSchemaData()));

        if (schemaId.isEmpty()) {
            throw new SchemaRegistryException("schema_id不能为空", 400, 200);
        }

        // 生成版本号
        schema.setSchemaVersion(IdUtil.objectId());
        schema.setSchemaId(schemaId);

        Integer count = schemaMapper.insert(schema);
        if (count > 0) {
            SchemaRegistryRecord srrm = new SchemaRegistryRecord();
            srrm.setSchemaRegistryId(schema.getId());
            srrm.setOldSchemaData(schema.getSchemaData());
            srrm.setEditSchemaData(schema.getSchemaData());
            schemaRegistryRecordMapper.insert(srrm);
            return getSchemaRegistryVo(schema);
        }
        throw new SchemaRegistryException("添加数据失败", 400, 200);
    }

    @Override
    public Integer updateSchema(String schemaId, String version, SchemaRegistry schema) {
        logger.debug(schema.getSchemaData());
        // 验证schema
        Parser sp = new Parser();
        sp.setValidate(true).parse(JSONUtil.toJsonStr(schema.getSchemaData()));

        QueryWrapper<SchemaRegistry> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        SchemaRegistry srOne = schemaMapper.selectOne(qw);
        schema.setSchemaId(schemaId);
        schema.setSchemaVersion(version);
        Integer count = schemaMapper.update(schema, qw);
        if (count > 0) {
            SchemaRegistryRecord srrm = new SchemaRegistryRecord();
            srrm.setSchemaRegistryId(srOne.getId());
            srrm.setOldSchemaData(srOne.getSchemaData());
            srrm.setEditSchemaData(schema.getSchemaData());
            schemaRegistryRecordMapper.insert(srrm);
        }
        return count;
    }
}
