DROP TABLE IF EXISTS `schema_registry`;
CREATE TABLE `schema_registry`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT,
    `schema_version` varchar(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL,
    `schema_id`      varchar(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL,
    `schema_type`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'schema的type，暂时只支持AVRO, (AVRO 和 PROTOBUF)',
    `schema_data`    json                                                          DEFAULT NULL COMMENT 'schema文件数据',
    `updated_at`     bigint                                                        DEFAULT NULL,
    `created_at`     bigint                                                        DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 插入数据
INSERT INTO `schema_registry` (`schema_version`, `schema_id`, `schema_type`, `schema_data`, `updated_at`,
                                      `created_at`)
VALUES ('1', 'dk3234', 'AVRO', '{}', 1600396419000, 1600396419000);
INSERT INTO `schema_registry` (`schema_version`, `schema_id`, `schema_type`, `schema_data`, `updated_at`,
                                      `created_at`)
VALUES ('2', 'dk3234', 'AVRO', '{}', 1600396419000, 1600396419000);
