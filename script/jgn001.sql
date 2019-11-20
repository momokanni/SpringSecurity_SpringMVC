CREATE TABLE `fae_clique` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '集团全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '集团简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime`  datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='集团表';


CREATE TABLE `fae_issue` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '发行方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '发行方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `cliqueId` int(10) NOT NULL DEFAULT '0' COMMENT '所属集团id(fae_clique)',
  `createTime`  datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发行人表';

CREATE TABLE `fae_danbao` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '担保方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '担保方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime`  datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='担保方表';

CREATE TABLE `fae_entrusted` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '受托管理方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '受托管理方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime`  datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='受托管理方表';

CREATE TABLE `excel_handle` (
                          `id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
                          `status`  int(11) UNSIGNED NOT NULL ,
                          `fileName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '上传文件名称' ,
                          `fileMD5`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件的MD5码' ,
                          `excelTotal`  int(64) UNSIGNED NULL DEFAULT 0 COMMENT '导入excel的总条数' ,
                          `handleNums`  int(64) UNSIGNED NULL DEFAULT 0 COMMENT '已处理的条数' ,
                          `failNums`  int(64) UNSIGNED NULL DEFAULT 0 COMMENT '处理失败的条数' ,
                          `repetitionNums`  int(64) UNSIGNED DEFAULT 0 NULL COMMENT '重复条数' ;
                          `createTime`  datetime NULL COMMENT '创建时间' ,
                          `startTime`  datetime NULL COMMENT '开始处理时间' ,
                          `endTime`  datetime NULL COMMENT '处理结束时间' ,
                          `type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导入的类型',
                          `excelFilePath`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导入excel文件存放路径' ,
                          `failCause`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '解析失败原因' ,
                          PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='处理导入数据';

CREATE TABLE `fae_investor` (
                          `id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
                          `type`  int(10) UNSIGNED DEFAULT 1 COMMENT '投资人类型(1 个人投资人, 2 企业投资人)' ,
                          `realName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人投资人真实姓名' ,
                          `idCardNo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人投资人身份证号' ,
                          `mobile`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人投资人手机号' ,
                          `userSource`  int(11) UNSIGNED NULL COMMENT '用户来源' ,
                          `referrer`  int(11) UNSIGNED NULL COMMENT '推荐人' ,
                          `companyName`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公司名称' ,
                          `creditCode`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业统一社会信用代码' ,
                          `businessLicense`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业营业执照编号' ,
                          `legalPersonName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业法人姓名' ,
                          `contacts`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业联系人' ,
                          `contactsTel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业联系人电话' ,
                          `createTime`  datetime NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='投资人表'
;

CREATE TABLE `fae_bank_card` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bankCode` varchar(64) DEFAULT '' COMMENT '银行卡号',
  `bankName` varchar(64) DEFAULT '' COMMENT '开户行名称',
  `slaveName` varchar(255) DEFAULT '' COMMENT '开户行支行',
  `investorId` int(11) NOT NULL DEFAULT '0' COMMENT 'fae_investor的Id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0-历史卡(导入的都是0),1-正在使用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_investorId` (`investorId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡表';

CREATE TABLE `fae_investor_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_investor的Id',
  `balance` decimal(14,2) DEFAULT '0.00' COMMENT '账户余额',
  `toCollectPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '待收本金',
  `toCollectInterest` decimal(14,2) DEFAULT '0.00' COMMENT '待收利息',
  `frozenAmount` decimal(14,2) DEFAULT '0.00' COMMENT '冻结金额',
  `totalInvest` decimal(14,2) DEFAULT '0.00' COMMENT '累计投资',
  `totalIncome` decimal(14,2) DEFAULT '0.00' COMMENT '累计收益',
  PRIMARY KEY (`id`),
  KEY `idx_investorid` (`investorId`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `fae_underwriter_investor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_investor的Id',
  `underwriterId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_underwriter的id',
  PRIMARY KEY (`id`),
  KEY `idx_investor` (`investorId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资人对应承销商表';


CREATE TABLE `fae_repay_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `establishId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '对应的成立信息(fae_establish_info)',
  `repayPhase` int(4) NOT NULL DEFAULT '0' COMMENT '还款期数',
  `repayPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '还款本金',
  `repayInterest` decimal(14,2) DEFAULT '0.00' COMMENT '还款利息',
  `repayStatus` int(4) NOT NULL DEFAULT '0' COMMENT '0-未还,1-还款中.2-已还',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `repayDate` date DEFAULT NULL COMMENT '还款日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借款人还款计划';


CREATE TABLE `fae_investor_repay_phase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '投资人id',
  `investRecordId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '投资记录Id',
  `phase` int(4) NOT NULL DEFAULT '0' COMMENT '回款期数',
  `repayInfoId` int(10) unsigned NOT NULL COMMENT 'fae_repay_info(id)',
  `repayPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '回款本金',
  `repayInterest` decimal(14,2) DEFAULT '0.00' COMMENT '回款利息',
  `back` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已经回款',
  `repayDate` date DEFAULT NULL COMMENT '回款日期',
  `actualRepayTime` datetime DEFAULT NULL COMMENT '实际回款时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资人回款计划';


CREATE TABLE `fae_invest_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(11) NOT NULL DEFAULT '0' COMMENT '投资人id',
  `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_product的id',
  `phase` int(4) NOT NULL DEFAULT '0' COMMENT '成立期数',
  `bankCardId` int(11) NOT NULL DEFAULT '0' COMMENT 'fae_bank_card(id)',
  `investAmount` decimal(14,2) DEFAULT '0.00' COMMENT '认购金额',
  `investTime` datetime DEFAULT NULL COMMENT '认购时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资记录表';


CREATE TABLE `fae_establish_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL DEFAULT '0' COMMENT '产品id',
  `establishDate` date DEFAULT NULL COMMENT '成立日',
  `phase` int(4) NOT NULL DEFAULT '0' COMMENT '成立期数',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间(导入时间)',
  `establishAmount` decimal(14,2) DEFAULT '0.00' COMMENT '成立金额',
  `dueDate` date DEFAULT NULL COMMENT '产品到期日',
  PRIMARY KEY (`id`),
  KEY `idx_productId` (`productId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品成立信息表';

ALTER TABLE `sys_user`
  ADD COLUMN `email`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户邮箱' AFTER `userId`,
  ADD COLUMN `sex`  int(3) UNSIGNED NULL DEFAULT 3 COMMENT '用户性别 1 男 2 女 3 未知' AFTER `email`,
  ADD COLUMN `reportRoleId`  int(11) UNSIGNED NULL COMMENT '汇报对象Id' AFTER `sex`,
  MODIFY COLUMN `deptId`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `name`,
  MODIFY COLUMN `levelId`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `deptId`,
  MODIFY COLUMN `companyId`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `status`,
  MODIFY COLUMN `gender`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `roleId`,
  MODIFY COLUMN `positionId`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `gender`,
  MODIFY COLUMN `leaderId`  int(10) UNSIGNED NULL DEFAULT 0 AFTER `positionId`,
  MODIFY COLUMN `userId`  int(10) UNSIGNED NULL DEFAULT 0 COMMENT '关联user_main' AFTER `leaderId`,
  MODIFY COLUMN `email`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱' AFTER `userId`,
  MODIFY COLUMN `sex`  int(3) UNSIGNED NOT NULL DEFAULT 3 COMMENT '用户性别 1 男 2 女 3 未知' AFTER `email`,
  MODIFY COLUMN `reportRoleId`  int(11) UNSIGNED NOT NULL COMMENT '汇报对象Id' AFTER `sex`;


ALTER TABLE `sys_role`
  ADD COLUMN `department`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门' AFTER `roleName`,
  ADD COLUMN `createTime`  datetime NULL COMMENT '创建时间' AFTER `department`,
  ADD COLUMN `modifyTime`  datetime NULL COMMENT '创建时间' AFTER `createTime`,
  ADD COLUMN `status`  int(10) UNSIGNED DEFAULT 1 COMMENT '岗位状态' AFTER `modifyTime`;

