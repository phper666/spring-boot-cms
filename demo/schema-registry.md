### Schema-Registry
Schema Registry is mainly used to manage schemas. Data from specified schema files can be obtained according to the schema ID and version number

#### Schema-Registry table design
This is the table design for The Schema Registry   
```
CREATE TABLE `schema_register` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `schema_version` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `schema_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `schema_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'schema的type，暂时只支持AVRO, (AVRO 和 PROTOBUF)',
  `schema_data` json DEFAULT NULL COMMENT 'schema文件数据',
  `updated_at` bigint DEFAULT NULL,
  `created_at` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```
Each schema will have a corresponding version and ID    

Schema modification record sheet design   
```
CREATE TABLE `test`.`schema_registry_record`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT,
    `schema_registry_id`       bigint unsigned         DEFAULT NULL,
    `old_schema_data`    json                          DEFAULT NULL COMMENT '修改前的schema文件数据',
    `edit_schema_data`    json                         DEFAULT NULL COMMENT '修改schema文件数据',
    `updated_at`     bigint                            DEFAULT NULL,
    `created_at`     bigint                            DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
```

#### Schema-validation
At present, the Schema format only supports AVro provided by Apache, so the verification also USES the SDK package provided by Apache. Please check the documentation for details   
[APACHE ARVO DOCUMENT](http://avro.apache.org/docs/current/spec.html)

#### Schema-Registry apis
Below are all the apis provided by The Schema Registry
```
/{schemaId}/version/{version}  --method=GET  --desc=Gets the contents of the schema

/{schemaId}/count --method=GET --desc=Gets the total number of current schemas

/{schemaId} --method=GET --desc=Gets data for all versions of the current schema

/   --method=POST --desc=Creating schema data

/{schemaId} --method=POST --desc=Creating schema data for the specified ID automatically generates a new schema version number

/{schemaId}/version/{version} --method=PUT --desc=Update schema data

/{schemaId}/version/{version} --method=DELETE --desc=Delete schema data
```

#### Schema-Registry DEMO
1、Create Schema   
POST http://localhost:8094/api/schema
```
{
    "schema_data": {
        "type": "record",
        "name": "LongList",
        "aliases": [
            "LinkedLongs"
        ],
        "fields": [
            {
                "name": "value",
                "type": "long"
            },
            {
                "name": "next",
                "type": [
                    "null",
                    "LongList"
                ]
            } 
        ]
    }
}

Result：
{
    "errcode": 0,
    "errmsg": "ok",
    "data": {
        "id": 11,
        "schemaVersion": "5f680ffd480e44e495b48af3",
        "schemaId": "5f680ffd480e44e495b48af4",
        "schemaData": {
            "aliases": [
                "LinkedLongs"
            ],
            "name": "LongList",
            "type": "record",
            "fields": [
                {
                    "name": "value",
                    "type": "long"
                },
                {
                    "name": "next",
                    "type": [
                        "null",
                        "LongList"
                    ]
                }
            ]
        },
        "createdAt": "2020-09-21 10:29:17",
        "updatedAt": "2020-09-21 10:29:17"
    }
}
```
2、Update Schema   
PUT http://localhost:8094/api/schema/5f680ffd480e44e495b48af4/version/5f680ffd480e44e495b48af3
```
{
    "schema_data": {
        "type": "record",
        "name": "LongList",
        "aliases": [
            "LinkedLongs"
        ],
        "fields": [
            {
                "name": "value_update",
                "type": "long"
            }
        ]
    }
}

Result：
{
    "errcode": 0,
    "errmsg": "ok",
    "data": 1
}
```
3、Get Schema  
GET http://localhost:8094/api/schema/5f680ffd480e44e495b48af4/version/5f680ffd480e44e495b48af3
```
Result：
{
    "errcode": 0,
    "errmsg": "ok",
    "data": {
        "id": 11,
        "schemaVersion": "5f680ffd480e44e495b48af3",
        "schemaId": "5f680ffd480e44e495b48af4",
        "schemaData": {
            "aliases": [
                "LinkedLongs"
            ],
            "name": "LongList",
            "type": "record",
            "fields": [
                {
                    "name": "value_update",
                    "type": "long"
                }
            ]
        },
        "createdAt": "2020-09-21 10:29:17",
        "updatedAt": "2020-09-21 10:31:43"
    }
}
```
4、Delete Schema  
DELETE http://localhost:8094/api/schema/5f680ffd480e44e495b48af4/version/5f680ffd480e44e495b48af3
```
Result：
{
    "errcode": 0,
    "errmsg": "ok",
    "data": 1
}
```



1、要看到所有的schema文件
2、服务链路追踪+log service，猎豹
3、日志使用阿里云log