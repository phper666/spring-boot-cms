package com.github.phper666.schemaregistry.rest.controller;

import com.github.phper666.schemaregistry.rest.entity.SchemaRegister;
import com.github.phper666.schemaregistry.rest.exception.SchemaRegisterException;
import com.github.phper666.schemaregistry.rest.service.ISchemaRegisterService;
import com.github.phper666.schemaregistry.rest.service.IUserService;
import com.github.phper666.schemaregistry.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 10:23 上午
 * @software IntelliJ IDEA
 */
@RestController
@RequestMapping("/api/schema")
public class SchemaController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ISchemaRegisterService schemaService;

    @GetMapping("/{schemaId}/version/{version}")
    public ResponseData getSchema(@PathVariable String schemaId, @PathVariable String version) {
        return ResponseData.success(schemaService.getSchema(schemaId, version));
    }

    @GetMapping("/{schemaId}/count")
    public ResponseData getSchemaCount(@PathVariable String schemaId) {
        return ResponseData.success(schemaService.getSchemaCount(schemaId));
    }

    @GetMapping("/{schemaId}")
    public ResponseData getAllVersions(@PathVariable String schemaId) {
        return ResponseData.success(schemaService.getAllVersions(schemaId));
    }

    @PostMapping("")
    public ResponseData createSchema(@RequestBody SchemaRegister schema) throws SchemaRegisterException {
        return ResponseData.success(schemaService.createSchema(schema));
    }

    @PostMapping("/{schemaId}")
    public ResponseData createSchemaById(@PathVariable String schemaId, @RequestBody SchemaRegister schema) throws SchemaRegisterException {
        return ResponseData.success(schemaService.createSchemaById(schemaId, schema));
    }

    @PutMapping("/{schemaId}/version/{version}")
    public ResponseData updateSchema(
            @PathVariable String schemaId,
            @PathVariable String version,
            @RequestBody SchemaRegister schema) {
        return ResponseData.success(schemaService.updateSchema(schemaId, version, schema));
    }

    @DeleteMapping("/{schemaId}/version/{version}")
    public ResponseData deleteSchema(@PathVariable String schemaId, @PathVariable String version) {
        return ResponseData.success(schemaService.deleteSchema(schemaId, version));
    }

    @GetMapping("/test")
    public ResponseData test() {
        return ResponseData.success(userService.test());
    }
}
