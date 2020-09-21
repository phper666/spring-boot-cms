DROP TABLE IF EXISTS `schema_register`;
CREATE TABLE `test`.`schema_register`
(
    `id`             bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `schema_version` varchar(255)       NULL,
    `schema_id`      varchar(255)       NULL,
    `schema_type`    varchar(255)       NULL,
    `schema_data`    json               NULL,
    `updated_at`     bigint             NULL,
    `created_at`     bigint             NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- 插入数据
INSERT INTO `test`.`schema_register` (`schema_version`, `schema_id`, `schema_type`, `schema_data`, `updated_at`,
                                      `created_at`)
VALUES ('1', 'dk3234', 'AVRO', '{}', 1600396419000, 1600396419000);
INSERT INTO `test`.`schema_register` (`schema_version`, `schema_id`, `schema_type`, `schema_data`, `updated_at`,
                                      `created_at`)
VALUES ('2', 'dk3234', 'AVRO', '{}', 1600396419000, 1600396419000);
