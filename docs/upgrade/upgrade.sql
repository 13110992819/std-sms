

ALTER TABLE `tjc_sms_captcha` 
CHANGE COLUMN `mobile` `mobile` VARCHAR(255) NULL DEFAULT NULL COMMENT '手机号' ;

ALTER TABLE `tjc_configure` 
CHANGE COLUMN `v` `v` TEXT NULL DEFAULT NULL COMMENT 'value' ;

INSERT INTO `std_sms`.`tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'QQ', 'from', '417109736@qq.com', '发件人');
INSERT INTO `std_sms`.`tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'QQ', 'host', 'smtp.qq.com', '邮箱服务器');
INSERT INTO `std_sms`.`tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'QQ', 'password', 'tybveqzbvoefbhii', '邮箱授权码');
INSERT INTO `std_sms`.`tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'QQ', 'subject', 'bcoin bind email', '邮箱主题');
INSERT INTO `std_sms`.`tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'QQ', 'content', '尊敬的用户，您的验证码为%s', '内容模板');