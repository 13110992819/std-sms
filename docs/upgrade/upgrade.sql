

ALTER TABLE `tjc_sms_captcha` 
CHANGE COLUMN `mobile` `mobile` VARCHAR(255) NULL DEFAULT NULL COMMENT '手机号' ;

ALTER TABLE `tjc_configure` 
CHANGE COLUMN `v` `v` TEXT NULL DEFAULT NULL COMMENT 'value' ;

INSERT INTO `tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'aliyun', 'from', 'system@bcoin.im', '发件人');
INSERT INTO `tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'aliyun', 'host', 'smtp.mxhichina.com', '邮箱服务器');
INSERT INTO `tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'aliyun', 'password', 'Bei123coin', '邮箱授权码');
INSERT INTO `tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'aliyun', 'subject', 'bcoin bind email', '邮箱主题');
INSERT INTO `tjc_configure` (`company_code`, `channel`, `k`, `v`, `remark`) VALUES ('CD-COIN000017_email', 'aliyun', 'content', '尊敬的用户，您的验证码为%s', '内容模板');