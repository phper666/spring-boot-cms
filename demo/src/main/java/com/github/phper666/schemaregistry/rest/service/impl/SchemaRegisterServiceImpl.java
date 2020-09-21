package com.github.phper666.schemaregistry.rest.service.impl;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.phper666.schemaregistry.rest.entity.SchemaRegister;
import com.github.phper666.schemaregistry.rest.exception.SchemaRegisterException;
import com.github.phper666.schemaregistry.rest.mapper.SchemaRegisterMapper;
import com.github.phper666.schemaregistry.rest.service.ISchemaRegisterService;
import com.github.phper666.schemaregistry.rest.vo.SchemaRegisterVo;
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
public class SchemaRegisterServiceImpl extends ServiceImpl<SchemaRegisterMapper, SchemaRegister> implements ISchemaRegisterService {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public SchemaRegisterMapper schemaMapper;

    @Override
    public SchemaRegisterVo getSchema(String schemaId, String version) {
        logger.info("schema_id:" + schemaId + ",schema_version:" + version);

        QueryWrapper<SchemaRegister> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        SchemaRegister oneData = schemaMapper.selectOne(qw);
        return getSchemaRegisterVo(oneData);
    }

    @Override
    public List<SchemaRegisterVo> getAllVersions(String schemaId) {
        logger.info("id:" + schemaId);

        QueryWrapper<SchemaRegister> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId);
        List<SchemaRegister> list = schemaMapper.selectList(qw);
        List<SchemaRegisterVo> srvList = new ArrayList<>();
        list.forEach(schemaRegister -> {
            srvList.add(getSchemaRegisterVo(schemaRegister));
        });
        return srvList;
    }

    /**
     * 格式化时间
     * @param oneData
     * @return
     */
    private SchemaRegisterVo getSchemaRegisterVo(SchemaRegister oneData) {
        SchemaRegisterVo srv = new SchemaRegisterVo();
        BeanUtils.copyProperties(oneData, srv);
        Date createdAt = DateUtil.date(oneData.getCreatedAt());
        Date updatedAt = DateUtil.date(oneData.getUpdatedAt());
        srv.setCreatedAt(DateUtil.formatDateTime(createdAt));
        srv.setUpdatedAt(DateUtil.formatDateTime(updatedAt));
        return srv;
    }

    @Override
    public Integer getSchemaCount(String schemaId) {
        QueryWrapper<SchemaRegister> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId);
        Integer count = schemaMapper.selectCount(qw);

        logger.info("count:" + count);
        return count;
    }

    @Override
    public Integer deleteSchema(String schemaId, String version) {
        QueryWrapper<SchemaRegister> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        return schemaMapper.delete(qw);
    }

    @Override
    public SchemaRegisterVo createSchema(SchemaRegister schema) throws SchemaRegisterException {
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
            return getSchemaRegisterVo(schema);
        }
        throw new SchemaRegisterException("添加数据失败", 400, 200);
    }

    @Override
    public SchemaRegisterVo createSchemaById(String schemaId, SchemaRegister schema) throws SchemaRegisterException {
        logger.debug(schema.getSchemaData());
        // 验证schema
        Parser sp = new Parser();
        sp.setValidate(true).parse(JSONUtil.toJsonStr(schema.getSchemaData()));

        if (schemaId.isEmpty()) {
            throw new SchemaRegisterException("schema_id不能为空", 400, 200);
        }

        // 生成版本号
        schema.setSchemaVersion(IdUtil.objectId());
        schema.setSchemaId(schemaId);

        Integer count = schemaMapper.insert(schema);
        if (count > 0) {
            return getSchemaRegisterVo(schema);
        }
        throw new SchemaRegisterException("添加数据失败", 400, 200);
    }

    @Override
    public Integer updateSchema(String schemaId, String version, SchemaRegister schema) {
        logger.debug(schema.getSchemaData());
        // 验证schema
        Parser sp = new Parser();
        sp.setValidate(true).parse(JSONUtil.toJsonStr(schema.getSchemaData()));

        QueryWrapper<SchemaRegister> qw = new QueryWrapper<>();
        qw.eq("schema_id", schemaId).eq("schema_version", version);
        schema.setSchemaId(schemaId);
        schema.setSchemaVersion(version);
        return schemaMapper.update(schema, qw);
    }
}
