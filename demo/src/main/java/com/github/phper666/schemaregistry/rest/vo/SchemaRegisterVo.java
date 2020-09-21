package com.github.phper666.schemaregistry.rest.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/18 11:57 上午
 * @software IntelliJ IDEA
 */
@Data
public class SchemaRegisterVo {
    private Long id;

    private String schemaVersion;

    private String schemaId;

    private JSONObject schemaData;

    private String createdAt;

    private String updatedAt;
}
