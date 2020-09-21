package com.github.phper666.schemaregistry.rest.validator;

import org.apache.avro.Schema.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/18 3:24 下午
 * @software IntelliJ IDEA
 */
public class SchemaValidate implements ISchemaValidate {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public boolean validate(String schemaData) {
        try {
            Parser sp = new Parser();
            sp.setValidate(true).parse(schemaData);
        } catch (Exception e) {
            logger.error("schema验证出错：错误%s", e.getMessage());
            return false;
        }
        return true;
    }
}
