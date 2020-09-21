DROP TABLE IF EXISTS `schema_registry_record`;
CREATE TABLE `schema_registry_record`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT,
    `schema_registry_id`       bigint unsigned                                     DEFAULT NULL,
    `old_schema_data`    json                                                      DEFAULT NULL COMMENT '修改前的schema文件数据',
    `edit_schema_data`    json                                                     DEFAULT NULL COMMENT '修改schema文件数据',
    `updated_at`     bigint                                                        DEFAULT NULL,
    `created_at`     bigint                                                        DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
