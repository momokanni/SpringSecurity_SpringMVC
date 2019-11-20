/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.1.73-log : Database - jupiter
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jupiter` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jupiter`;

/*Table structure for table `apply_allocate_detail` */

DROP TABLE IF EXISTS `apply_allocate_detail`;

CREATE TABLE `apply_allocate_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `itemId` int(10) unsigned NOT NULL DEFAULT '0',
  `allocatee` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=897 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_allocate_info` */

DROP TABLE IF EXISTS `apply_allocate_info`;

CREATE TABLE `apply_allocate_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `allocater` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '指派人',
  `allocatee` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '被指派人',
  `status` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '指派状态',
  `items` varchar(512) NOT NULL DEFAULT '' COMMENT '指派项目',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `prevAllocateId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上一环指派记录',
  `turnAble` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可转单',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_allocateeId` (`allocatee`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_allocate_record` */

DROP TABLE IF EXISTS `apply_allocate_record`;

CREATE TABLE `apply_allocate_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `allocater` int(10) unsigned NOT NULL DEFAULT '0',
  `allocatee` int(10) unsigned NOT NULL DEFAULT '0',
  `items` varchar(1024) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `fromAllocateId` int(10) unsigned NOT NULL DEFAULT '0',
  `toAllocateId` int(10) unsigned NOT NULL DEFAULT '0',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_audit_info` */

DROP TABLE IF EXISTS `apply_audit_info`;

CREATE TABLE `apply_audit_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `oldStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `newStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `remark` varchar(512) DEFAULT NULL,
  `auditUserId` int(10) unsigned NOT NULL DEFAULT '0',
  `oldAllocateStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `newAllocateStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `turnDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否出现在转单明细中',
  `allocateId` int(10) unsigned NOT NULL DEFAULT '0',
  `displayRemark` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示备注',
  `display` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示',
  `addition` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是追单',
  `additionId` int(10) unsigned NOT NULL DEFAULT '0',
  `newAdditionStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `oldAdditionStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `repayPlanId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '还款计划id',
  `fhk` tinyint(1) NOT NULL DEFAULT '0' COMMENT '放还款标识',
  `repayPlanHandleType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作的是放款还是还款',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=1063 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_base_info` */

DROP TABLE IF EXISTS `apply_base_info`;

CREATE TABLE `apply_base_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `argument` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '是否上会',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '客户姓名',
  `amount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '借款金额',
  `termCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '借款期限',
  `rate` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '借款利率',
  `platRate` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '公司点位',
  `platFee` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '公司收费',
  `returnRate` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '返费比例',
  `planUseDate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预计用款时间',
  `planRepayDate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预计还款时间',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `applyUserMobile` varchar(13) NOT NULL DEFAULT '' COMMENT '借款人联系方式',
  `applyUserIdCardNo` varchar(45) NOT NULL DEFAULT '' COMMENT '借款人身份号',
  `applyUserOtherInfo` varchar(1024) DEFAULT NULL COMMENT '借款人其他情况说明',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `assetCommonOwnerId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '共有人信息id',
  `contactId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '联系人id',
  `selfAsContact` tinyint(1) NOT NULL DEFAULT '0' COMMENT '联系人是否为本人',
  `termUnit` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '借款期限单位',
  `businessType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '业务类型',
  `totalRate` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '总收点位',
  `upEnterpriseId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上家id',
  `downEnterpriseId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '下家id',
  `userId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '录入用户id',
  `upEnterpriseRemark` varchar(512) DEFAULT NULL COMMENT '上家补充说明',
  `downEnterpriseRemark` varchar(512) DEFAULT NULL COMMENT '下家补充说明',
  `totalFee` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总收费',
  `returnFee` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '返费',
  `orderNo` varchar(45) DEFAULT NULL COMMENT '订单编号',
  `fileNo` varchar(45) DEFAULT NULL COMMENT '档案编号',
  `loanDate` date DEFAULT NULL COMMENT '放款日期',
  `display` tinyint(1) NOT NULL DEFAULT '0' COMMENT '台账显示',
  `allocateStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '业务分配状态',
  `interviewUserId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '指派的面谈人id',
  `businessCheckId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '业务审批id',
  `financeDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '财务部可见',
  `firstAuditDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '初审权限可见',
  `secondAuditDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '复审权限可见',
  `finalAuditDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '终审权限可见',
  `businessCheckDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '业务复核权限可见',
  `businessAuditDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '业务审批权限可见',
  `loanAuditDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '放款审批权限可见',
  `allocateDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '转单权限可见',
  `bossDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '总经办可见',
  `leaderDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '领导可见',
  `calendarDisplay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '日历可见',
  `fhAuditId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '业务复核操作的审核id',
  `handelUserIds` varchar(2048) DEFAULT NULL COMMENT '当前业务环节处理人',
  `defaultUpEnterpriseInfoId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上游企业id,apply_updown_info',
  `defaultDownEnterpriseId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '下游企业id',
  `additionalApply` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '是否追加借款',
  `mainBaseId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '主借款id',
  `creditAccompanior` varchar(512) DEFAULT NULL COMMENT '征信陪同人',
  `updownAccompanior` varchar(512) DEFAULT NULL COMMENT '上下家陪同人',
  `loaned` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有过放款',
  `reloanApply` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否展期',
  `reloanRepayplanId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '展期源还款计划',
  `hasSelfUseAmount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '是否含有自用资金',
  `selfUseAmount` decimal(14,2) DEFAULT NULL COMMENT '自用资金',
  `selfUseDate` date DEFAULT NULL COMMENT '自用资金用款日期',
  `selfUseTerm` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '自用资金用款天数',
  `selfUseRate` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '自用资金点位',
  `selfUseFee` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '自用资金费用',
  `backReason` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '撤件原因',
  `backRemark` varchar(512) DEFAULT NULL COMMENT '撤件补充说明',
  `backTime` datetime DEFAULT NULL COMMENT '撤件时间',
  `loanStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '融资状态',
  `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '产品id',
  `hasUpEnterprise` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有上家权证阶段',
  `upAccompanior` varchar(512) DEFAULT NULL COMMENT '上家陪同人',
  `downAccompanior` varchar(512) DEFAULT NULL COMMENT '下家陪同人',
  `repayAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '还款金额',
  `repayDate` date DEFAULT NULL COMMENT '还款日期',
  `repayTime` datetime DEFAULT NULL COMMENT '还款时间',
  `repayRemark` varchar(512) DEFAULT NULL COMMENT '还款备注',
  `propertyCertNo` varchar(128) DEFAULT NULL COMMENT '产权证号',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_business_check_info` */

DROP TABLE IF EXISTS `apply_business_check_info`;

CREATE TABLE `apply_business_check_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `checkUser` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `checkTime` datetime DEFAULT NULL,
  `parentId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_business_handle_info` */

DROP TABLE IF EXISTS `apply_business_handle_info`;

CREATE TABLE `apply_business_handle_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `item` int(10) unsigned NOT NULL DEFAULT '0',
  `handleUser` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `type` int(10) unsigned NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=908 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_business_info` */

DROP TABLE IF EXISTS `apply_business_info`;

CREATE TABLE `apply_business_info` (
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `applyUserDone` tinyint(1) NOT NULL DEFAULT '0',
  `certificateDone` tinyint(1) NOT NULL DEFAULT '0',
  `toHouseDone` tinyint(1) NOT NULL DEFAULT '0',
  `notarizationDone` tinyint(1) NOT NULL DEFAULT '0',
  `houseHistoryDone` tinyint(1) NOT NULL DEFAULT '0',
  `enforcementDone` tinyint(1) NOT NULL DEFAULT '0',
  `evaluationDone` tinyint(1) NOT NULL DEFAULT '0',
  `dishonestyDone` tinyint(1) NOT NULL DEFAULT '0',
  `creditDone` tinyint(1) NOT NULL DEFAULT '0',
  `updonwDone` tinyint(1) NOT NULL DEFAULT '0',
  `interviewDone` tinyint(1) NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `loanCardDone` tinyint(1) NOT NULL DEFAULT '0',
  `housePropertyDone` tinyint(1) NOT NULL DEFAULT '0',
  `upDone` tinyint(1) NOT NULL DEFAULT '0',
  `downDone` tinyint(1) NOT NULL DEFAULT '0',
  `datasDone` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`baseInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `apply_credit` */

DROP TABLE IF EXISTS `apply_credit`;

CREATE TABLE `apply_credit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL,
  `applyUserId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='征信';

/*Table structure for table `apply_credit_material` */

DROP TABLE IF EXISTS `apply_credit_material`;

CREATE TABLE `apply_credit_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `creditId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_creditId` (`creditId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='征信材料表';

/*Table structure for table `apply_datas_info` */

DROP TABLE IF EXISTS `apply_datas_info`;

CREATE TABLE `apply_datas_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `materialIds` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_dishonesty` */

DROP TABLE IF EXISTS `apply_dishonesty`;

CREATE TABLE `apply_dishonesty` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `dishonesty` tinyint(1) DEFAULT NULL COMMENT 'false',
  `applyUserId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COMMENT='失信人';

/*Table structure for table `apply_dishonesty_material` */

DROP TABLE IF EXISTS `apply_dishonesty_material`;

CREATE TABLE `apply_dishonesty_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dishonestyId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_dishonestyId` (`dishonestyId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='失信人材料';

/*Table structure for table `apply_downcompany` */

DROP TABLE IF EXISTS `apply_downcompany`;

CREATE TABLE `apply_downcompany` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `downCompanyId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='下家信息';

/*Table structure for table `apply_enforcement` */

DROP TABLE IF EXISTS `apply_enforcement`;

CREATE TABLE `apply_enforcement` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `applyUserId` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `enforcement` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_enforcement_material` */

DROP TABLE IF EXISTS `apply_enforcement_material`;

CREATE TABLE `apply_enforcement_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enforcementId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_enforcementId` (`enforcementId`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='强制执行材料';

/*Table structure for table `apply_file_seq` */

DROP TABLE IF EXISTS `apply_file_seq`;

CREATE TABLE `apply_file_seq` (
  `fileSeq` int(10) unsigned NOT NULL DEFAULT '0',
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_house_evaluation` */

DROP TABLE IF EXISTS `apply_house_evaluation`;

CREATE TABLE `apply_house_evaluation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `evaAmount` decimal(14,2) DEFAULT NULL,
  `evaCompanyId` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='房屋评估';

/*Table structure for table `apply_house_evaluation_material` */

DROP TABLE IF EXISTS `apply_house_evaluation_material`;

CREATE TABLE `apply_house_evaluation_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `evaluationId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_evaluationId` (`evaluationId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='房屋评估材料';

/*Table structure for table `apply_house_history` */

DROP TABLE IF EXISTS `apply_house_history`;

CREATE TABLE `apply_house_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `remark` varchar(1024) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `sealUp2Years` tinyint(1) DEFAULT NULL COMMENT '近两年是否有查封',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='房屋历史';

/*Table structure for table `apply_house_info` */

DROP TABLE IF EXISTS `apply_house_info`;

CREATE TABLE `apply_house_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `residentName` varchar(45) NOT NULL DEFAULT '' COMMENT '小区名称',
  `room` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '室',
  `mall` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '厅',
  `toilet` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '卫',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `houseType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '房屋性质',
  `years` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '产权年限',
  `firstAreaId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '第一级地区id',
  `address` varchar(128) NOT NULL DEFAULT '' COMMENT '房屋地址',
  `estimateAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '评估值',
  `evaCompanyId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '评估公司',
  `evaMarketId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '参考市场',
  `referenceLink` varchar(128) NOT NULL DEFAULT '' COMMENT '参考链接',
  `evaWebsiteId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '参考网站',
  `area` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '房屋面积',
  `secondAreaId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '第二级地区',
  `thirdAreaId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '第三级地区',
  `areaOther` varchar(256) DEFAULT NULL,
  `evaCompanyAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '评估公司的评估值',
  `evaMarketAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '参考市场的评估值',
  `evaWebsiteAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '参考网站的评估值',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_interview` */

DROP TABLE IF EXISTS `apply_interview`;

CREATE TABLE `apply_interview` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `address` varchar(256) NOT NULL DEFAULT '' COMMENT '面谈地址',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `riskOpinion` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '风控意见',
  `riskRemark` varchar(256) DEFAULT NULL COMMENT '风控备注',
  `interviewDate` date NOT NULL DEFAULT '0000-00-00' COMMENT '面谈日期',
  `spotId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '面谈地址Id',
  `interviewUserId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '面谈用户Id',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_loan_card` */

DROP TABLE IF EXISTS `apply_loan_card`;

CREATE TABLE `apply_loan_card` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `cardBank` varchar(45) NOT NULL DEFAULT '',
  `cardAccount` varchar(45) NOT NULL DEFAULT '',
  `cardNo` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `accompanior` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_loan_material` */

DROP TABLE IF EXISTS `apply_loan_material`;

CREATE TABLE `apply_loan_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `repayPlanId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_repayPlanId` (`repayPlanId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_notarization` */

DROP TABLE IF EXISTS `apply_notarization`;

CREATE TABLE `apply_notarization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `notarizationDate` date DEFAULT NULL,
  `notarizator` varchar(45) DEFAULT NULL COMMENT '公证办理人',
  `remark` varchar(512) DEFAULT NULL,
  `accompanior` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='房屋公证';

/*Table structure for table `apply_repay_material` */

DROP TABLE IF EXISTS `apply_repay_material`;

CREATE TABLE `apply_repay_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `repayPlanId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_repayPlanId` (`repayPlanId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_to_house` */

DROP TABLE IF EXISTS `apply_to_house`;

CREATE TABLE `apply_to_house` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `toHouseDate` date DEFAULT NULL,
  `accompanior` varchar(512) DEFAULT NULL COMMENT '陪同人',
  `remark` varchar(512) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_baseInfoId` (`baseInfoId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_upcompany` */

DROP TABLE IF EXISTS `apply_upcompany`;

CREATE TABLE `apply_upcompany` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `upCompanyId` int(10) unsigned NOT NULL DEFAULT '0',
  `upCompanyRemak` varchar(512) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `disMortgageOver` tinyint(1) NOT NULL DEFAULT '0' COMMENT '解抵押完成',
  `disMortgageRemark` varchar(512) DEFAULT NULL COMMENT '解抵押说明',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上家信息';

/*Table structure for table `apply_updown_info` */

DROP TABLE IF EXISTS `apply_updown_info`;

CREATE TABLE `apply_updown_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `enterpriseId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `cardAccount` varchar(45) NOT NULL DEFAULT '',
  `cardBank` varchar(45) NOT NULL DEFAULT '',
  `cardNo` varchar(45) NOT NULL DEFAULT '',
  `remark` varchar(1024) DEFAULT NULL,
  `hasCard` tinyint(1) NOT NULL DEFAULT '0',
  `repayAmount` decimal(14,2) DEFAULT NULL,
  `selfAmount` decimal(14,2) DEFAULT NULL,
  `repayDate` date DEFAULT NULL,
  `spAmount` decimal(14,2) DEFAULT NULL COMMENT '专项资金',
  `loanAmount` decimal(14,2) DEFAULT NULL COMMENT '实际放款',
  `preMaxAmount` decimal(14,2) DEFAULT NULL COMMENT '预计最高',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_updown_material` */

DROP TABLE IF EXISTS `apply_updown_material`;

CREATE TABLE `apply_updown_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `updownInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_updownId` (`updownInfoId`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_user_certificate` */

DROP TABLE IF EXISTS `apply_user_certificate`;

CREATE TABLE `apply_user_certificate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `tag` varchar(64) NOT NULL DEFAULT '0',
  `applyUserId` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `materialIds` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8 COMMENT='客户证件';

/*Table structure for table `apply_user_info` */

DROP TABLE IF EXISTS `apply_user_info`;

CREATE TABLE `apply_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mobile` varchar(13) DEFAULT NULL,
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `idCardNo` varchar(45) DEFAULT NULL,
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `marryStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '婚姻状态',
  `relationship` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '关系',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8;

/*Table structure for table `apply_user_info_tmp` */

DROP TABLE IF EXISTS `apply_user_info_tmp`;

CREATE TABLE `apply_user_info_tmp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mobile` varchar(13) DEFAULT NULL,
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `idCardNo` varchar(45) DEFAULT NULL,
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `marryStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `relationship` int(10) unsigned NOT NULL DEFAULT '0',
  `applyUserId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  `pinyin` varchar(128) DEFAULT NULL,
  `jianpin` varchar(128) DEFAULT NULL,
  `rank` int(10) unsigned NOT NULL DEFAULT '0',
  `typeId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187391 DEFAULT CHARSET=utf8;

/*Table structure for table `article_collection` */

DROP TABLE IF EXISTS `article_collection`;

CREATE TABLE `article_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NOT NULL COMMENT '文章ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `status` int(11) DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Table structure for table `article_forward` */

DROP TABLE IF EXISTS `article_forward`;

CREATE TABLE `article_forward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `article_img` */

DROP TABLE IF EXISTS `article_img`;

CREATE TABLE `article_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `number` varchar(25) DEFAULT NULL COMMENT '文章编号',
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `content` longtext NOT NULL COMMENT '内容',
  `category` tinyint(4) NOT NULL COMMENT '文章种类(0.图文，1.视频)',
  `typeId` int(11) NOT NULL COMMENT '文章类型',
  `labelId` int(11) DEFAULT NULL COMMENT '公众号标签',
  `thumb` varchar(200) DEFAULT NULL COMMENT '缩略图地址',
  `readCount` int(11) NOT NULL DEFAULT '0' COMMENT '阅读量',
  `collecCount` int(11) NOT NULL DEFAULT '0' COMMENT '收藏量',
  `forwardCount` int(11) NOT NULL DEFAULT '0' COMMENT '转发量',
  `laudCount` int(11) NOT NULL DEFAULT '0' COMMENT '点赞量',
  `ontop` tinyint(11) NOT NULL DEFAULT '0' COMMENT '置顶(0.否，1.置顶)',
  `blogId` int(11) NOT NULL COMMENT '公众号ID',
  `blogManagerId` int(11) NOT NULL COMMENT '公众号管理员Id',
  `status` tinyint(2) NOT NULL COMMENT '文章状态（0.草稿，1.待发布，2.已发布，3.下线）',
  `source` varchar(200) DEFAULT NULL COMMENT '文章来源（商户头像地址）',
  `sourceId` int(10) DEFAULT NULL COMMENT '文章来源ID',
  `audioName` varchar(50) DEFAULT NULL COMMENT '音频文件名称',
  `audioPath` varchar(200) DEFAULT NULL COMMENT '音频路径',
  `imgCount` int(3) DEFAULT '0' COMMENT '图片个数',
  `shareContent` varchar(200) DEFAULT NULL COMMENT '分享内容',
  `wordCount` int(11) DEFAULT '0' COMMENT '文章字数',
  `share` tinyint(2) NOT NULL DEFAULT '0' COMMENT '分享状态 0.未分享，1.已分享',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `otherStatus` varchar(100) DEFAULT NULL,
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8576 DEFAULT CHARSET=utf8;

/*Table structure for table `article_key_words` */

DROP TABLE IF EXISTS `article_key_words`;

CREATE TABLE `article_key_words` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关键字ID',
  `blogId` int(11) NOT NULL COMMENT '商户ID',
  `name` varchar(100) NOT NULL COMMENT '关键字名称',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `article_laud` */

DROP TABLE IF EXISTS `article_laud`;

CREATE TABLE `article_laud` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `articleId` int(10) DEFAULT '0',
  `userId` int(10) DEFAULT '0',
  `status` int(10) DEFAULT '0',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00',
  `updateTime` datetime DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Table structure for table `article_read` */

DROP TABLE IF EXISTS `article_read`;

CREATE TABLE `article_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NOT NULL COMMENT '文章Id',
  `userId` int(11) NOT NULL COMMENT '用户Id',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1948 DEFAULT CHARSET=utf8;

/*Table structure for table `article_share_relation` */

DROP TABLE IF EXISTS `article_share_relation`;

CREATE TABLE `article_share_relation` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '分享赚ID',
  `articleId` int(10) NOT NULL COMMENT '文章ID',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=405 DEFAULT CHARSET=utf8;

/*Table structure for table `article_type` */

DROP TABLE IF EXISTS `article_type`;

CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '类型名称',
  `seq` tinyint(3) DEFAULT NULL COMMENT '菜单排序',
  `status` tinyint(4) NOT NULL COMMENT '状态(0.无效，1.有效)',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `audit_material` */

DROP TABLE IF EXISTS `audit_material`;

CREATE TABLE `audit_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `auditId` int(10) unsigned NOT NULL DEFAULT '0',
  `materialId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_auditId` (`auditId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '公众号名称',
  `description` varchar(200) DEFAULT NULL COMMENT '公众号描述',
  `type` tinyint(4) NOT NULL COMMENT '账号类型（0.个人号，1.公司号）',
  `enterpriseName` varchar(25) DEFAULT NULL COMMENT '企业名称',
  `enterpriseType` tinyint(4) DEFAULT NULL COMMENT '企业类型(0.个体商户，1.企业)',
  `scc` varchar(20) DEFAULT NULL COMMENT '社会信用代码',
  `email` varchar(25) DEFAULT NULL COMMENT '公司邮箱',
  `headImg` varchar(100) DEFAULT NULL COMMENT '头像',
  `headImgMb` varchar(100) DEFAULT NULL COMMENT 'mobile头像',
  `status` tinyint(4) NOT NULL COMMENT '状态（0.无效，1.有效）',
  `authStatus` tinyint(4) NOT NULL COMMENT '认证状态（0.未认证，1.已认证）',
  `fansCount` int(11) NOT NULL COMMENT '粉丝数',
  `pushUrl` varchar(200) DEFAULT NULL COMMENT '推送接口',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Table structure for table `blog_focus` */

DROP TABLE IF EXISTS `blog_focus`;

CREATE TABLE `blog_focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogId` int(11) NOT NULL COMMENT '公众号ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `status` tinyint(3) DEFAULT NULL COMMENT '关注状态(0.未关注，1.已关注)',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Table structure for table `blog_label` */

DROP TABLE IF EXISTS `blog_label`;

CREATE TABLE `blog_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `name` varchar(50) NOT NULL COMMENT '标签名称',
  `description` varchar(50) DEFAULT NULL COMMENT '标签描述',
  `status` tinyint(5) DEFAULT NULL COMMENT '标签状态(0.无效，1.有效)',
  `blogId` int(11) NOT NULL COMMENT '公众号ID',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Table structure for table `blog_manager` */

DROP TABLE IF EXISTS `blog_manager`;

CREATE TABLE `blog_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号',
  `name` varchar(20) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `cardNo` varchar(128) DEFAULT NULL COMMENT '身份证',
  `isManager` tinyint(4) DEFAULT NULL COMMENT '是否为管理员(0.否，1.是)',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态（1.有效, 0.无效）',
  `blogId` int(11) DEFAULT NULL COMMENT '公众号ID',
  `authorities` varchar(800) DEFAULT NULL COMMENT '权限',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

/*Table structure for table `blog_manager_permit` */

DROP TABLE IF EXISTS `blog_manager_permit`;

CREATE TABLE `blog_manager_permit` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bmId` int(10) NOT NULL COMMENT '管理员ID',
  `blogId` int(10) NOT NULL COMMENT '商户ID',
  `bpId` int(10) NOT NULL COMMENT '权限ID',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `updateDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16171 DEFAULT CHARSET=utf8;

/*Table structure for table `blog_notice` */

DROP TABLE IF EXISTS `blog_notice`;

CREATE TABLE `blog_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeId` int(11) NOT NULL COMMENT '公告ID',
  `blogId` int(11) NOT NULL COMMENT '公众号ID',
  `status` tinyint(4) NOT NULL COMMENT '公告状态(0.未读，1.已读)',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `blog_permit` */

DROP TABLE IF EXISTS `blog_permit`;

CREATE TABLE `blog_permit` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商户权限ID',
  `name` varchar(50) NOT NULL COMMENT '商户权限名称',
  `parentId` int(10) NOT NULL COMMENT '商户权限父节点',
  `url` varchar(200) DEFAULT NULL COMMENT '权限路径',
  `level` int(10) NOT NULL COMMENT '权限层级',
  `sequence` int(10) NOT NULL COMMENT '排序',
  `personalType` tinyint(3) DEFAULT '0' COMMENT '个人账号权限类别(0:默认权限，1.商户自定义权限)',
  `companyType` tinyint(3) NOT NULL DEFAULT '0' COMMENT '公司账号权限类别（0：默认权限，1：商户自定义权限）',
  `type` tinyint(3) DEFAULT NULL COMMENT '权限类型（0. 菜单权限 1.其他权限）',
  `authorize` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `elementId` varchar(50) DEFAULT NULL COMMENT '页面标签ID属性',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `updateDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Table structure for table `business_type` */

DROP TABLE IF EXISTS `business_type`;

CREATE TABLE `business_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `clerk_role` */

DROP TABLE IF EXISTS `clerk_role`;

CREATE TABLE `clerk_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='投资人外的角色';

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(255) DEFAULT '' COMMENT '商品描述',
  `marketPrice` decimal(14,2) DEFAULT '0.00' COMMENT '市场价',
  `ourPrice` decimal(14,2) DEFAULT '0.00' COMMENT '本店价',
  `type` int(11) DEFAULT '0' COMMENT '商品类型',
  `headImg` varchar(255) DEFAULT NULL COMMENT '首图',
  `largeImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Table structure for table `commodity_order` */

DROP TABLE IF EXISTS `commodity_order`;

CREATE TABLE `commodity_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) unsigned NOT NULL DEFAULT '0',
  `productId` int(10) unsigned NOT NULL DEFAULT '0',
  `orderTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `orderNo` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `company_info` */

DROP TABLE IF EXISTS `company_info`;

CREATE TABLE `company_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `baseRate` decimal(4,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `company_rate` */

DROP TABLE IF EXISTS `company_rate`;

CREATE TABLE `company_rate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `companyId` int(10) unsigned NOT NULL DEFAULT '0',
  `rate` decimal(4,2) NOT NULL DEFAULT '0.00',
  `termCountStart` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `title` varchar(128) NOT NULL DEFAULT '',
  `termCountEnd` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '产品id',
  PRIMARY KEY (`id`),
  KEY `idx_companyId` (`companyId`),
  KEY `idx_productId` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `condition_info` */

DROP TABLE IF EXISTS `condition_info`;

CREATE TABLE `condition_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `template` varchar(256) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `title` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Table structure for table `condition_param` */

DROP TABLE IF EXISTS `condition_param`;

CREATE TABLE `condition_param` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conditionId` int(10) unsigned NOT NULL DEFAULT '0',
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seq` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `condition_param_option` */

DROP TABLE IF EXISTS `condition_param_option`;

CREATE TABLE `condition_param_option` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conditionParamId` int(10) unsigned NOT NULL DEFAULT '0',
  `val` int(10) unsigned NOT NULL DEFAULT '0',
  `text` varchar(64) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seq` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `cooperation_org` */

DROP TABLE IF EXISTS `cooperation_org`;

CREATE TABLE `cooperation_org` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '客户名称',
  `type` int(4) NOT NULL DEFAULT '0' COMMENT '客户类型',
  `shortName` varchar(128) DEFAULT '' COMMENT '客户简称',
  `number` varchar(128) NOT NULL DEFAULT '' COMMENT '客户编号',
  `businessScope` varchar(255) NOT NULL DEFAULT '',
  `certType` int(4) NOT NULL DEFAULT '0' COMMENT '证件类型',
  `certNo` varchar(128) NOT NULL DEFAULT '' COMMENT '证件号码',
  `accountBank` varchar(255) NOT NULL DEFAULT '' COMMENT '开户行',
  `accountNo` varchar(128) NOT NULL DEFAULT '' COMMENT '对公账户',
  `legalName` varchar(128) NOT NULL DEFAULT '' COMMENT '企业法人',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '企业邮箱',
  `contactName` varchar(128) NOT NULL DEFAULT '' COMMENT '企业联系人',
  `contactMobile` varchar(64) NOT NULL DEFAULT '' COMMENT '联系人电话',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '企业联系地址',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '1-禁用,0-启用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `dept_info` */

DROP TABLE IF EXISTS `dept_info`;

CREATE TABLE `dept_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `companyId` int(10) unsigned NOT NULL DEFAULT '0',
  `deptType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门类别',
  PRIMARY KEY (`id`),
  KEY `idx_companyId` (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Table structure for table `eva_company` */

DROP TABLE IF EXISTS `eva_company`;

CREATE TABLE `eva_company` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评估公司';

/*Table structure for table `eva_market` */

DROP TABLE IF EXISTS `eva_market`;

CREATE TABLE `eva_market` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评估市场';

/*Table structure for table `eva_website` */

DROP TABLE IF EXISTS `eva_website`;

CREATE TABLE `eva_website` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评估网站';

/*Table structure for table `excel_handle` */

DROP TABLE IF EXISTS `excel_handle`;

CREATE TABLE `excel_handle` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `status` int(11) unsigned NOT NULL,
  `fileName` varchar(100) DEFAULT NULL COMMENT '上传文件名称',
  `fileMD5` varchar(50) DEFAULT NULL COMMENT '文件的MD5码',
  `excelTotal` int(64) unsigned DEFAULT '0' COMMENT '导入excel的总条数',
  `handleNums` int(64) unsigned DEFAULT '0' COMMENT '已处理的条数',
  `failNums` int(64) unsigned DEFAULT '0' COMMENT '处理失败的条数',
  `repetitionNums` int(64) unsigned DEFAULT '0' COMMENT '重复条数',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `startTime` datetime DEFAULT NULL COMMENT '开始处理时间',
  `endTime` datetime DEFAULT NULL COMMENT '处理结束时间',
  `type` varchar(50) NOT NULL COMMENT '导入的类型',
  `excelFilePath` varchar(255) NOT NULL COMMENT '导入excel文件存放路径',
  `failCause` varchar(255) DEFAULT NULL COMMENT '解析失败原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='处理导入数据';

/*Table structure for table `fae_bank_card` */

DROP TABLE IF EXISTS `fae_bank_card`;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='银行卡表';

/*Table structure for table `fae_clique` */

DROP TABLE IF EXISTS `fae_clique`;

CREATE TABLE `fae_clique` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '集团全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '集团简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8 COMMENT='集团表';

/*Table structure for table `fae_danbao` */

DROP TABLE IF EXISTS `fae_danbao`;

CREATE TABLE `fae_danbao` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '担保方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '担保方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='担保方表';

/*Table structure for table `fae_entrusted` */

DROP TABLE IF EXISTS `fae_entrusted`;

CREATE TABLE `fae_entrusted` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '受托管理方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '受托管理方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='受托管理方表';

/*Table structure for table `fae_establish_info` */

DROP TABLE IF EXISTS `fae_establish_info`;

CREATE TABLE `fae_establish_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL DEFAULT '0' COMMENT '产品id',
  `establishDate` date DEFAULT NULL COMMENT '成立日',
  `phase` int(4) NOT NULL DEFAULT '0' COMMENT '成立期数',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间(导入时间)',
  `establishAmount` decimal(14,2) DEFAULT '0.00' COMMENT '成立金额',
  `dueDate` date DEFAULT NULL COMMENT '产品到期日',
  `incomeTerm` int(4) NOT NULL DEFAULT '0' COMMENT '这一期的投资收益期（天）',
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '0-未成立,1-处理中,2-已成立',
  `buyCount` int(11) NOT NULL DEFAULT '0' COMMENT '认购笔数',
  PRIMARY KEY (`id`),
  KEY `idx_productId` (`productId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品成立信息表';

/*Table structure for table `fae_invest_record` */

DROP TABLE IF EXISTS `fae_invest_record`;

CREATE TABLE `fae_invest_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(11) NOT NULL DEFAULT '0' COMMENT '投资人id',
  `bankCardId` int(11) NOT NULL DEFAULT '0' COMMENT 'fae_bank_card(id)',
  `investAmount` decimal(14,2) DEFAULT '0.00' COMMENT '认购金额',
  `investTime` datetime DEFAULT NULL COMMENT '认购时间',
  `establishId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_establish_info(id)',
  `productId` int(11) NOT NULL DEFAULT '0' COMMENT '产品Id',
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '0-投资未回款,1-部分回款,2-全部回款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='投资记录表';

/*Table structure for table `fae_investor` */

DROP TABLE IF EXISTS `fae_investor`;

CREATE TABLE `fae_investor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(10) unsigned DEFAULT '1' COMMENT '投资人类型(1 个人投资人, 2 企业投资人)',
  `realName` varchar(50) DEFAULT NULL COMMENT '个人投资人真实姓名',
  `idCardNo` varchar(20) DEFAULT NULL COMMENT '个人投资人身份证号',
  `mobile` varchar(20) DEFAULT NULL COMMENT '个人投资人手机号',
  `userSource` int(11) unsigned DEFAULT NULL COMMENT '用户来源',
  `referrer` int(11) unsigned DEFAULT NULL COMMENT '推荐人',
  `companyName` varchar(60) DEFAULT NULL COMMENT '公司名称',
  `creditCode` varchar(64) DEFAULT NULL COMMENT '企业统一社会信用代码',
  `businessLicense` varchar(64) DEFAULT NULL COMMENT '企业营业执照编号',
  `legalPersonName` varchar(50) DEFAULT NULL COMMENT '企业法人姓名',
  `contacts` varchar(50) DEFAULT NULL COMMENT '企业联系人',
  `contactsTel` varchar(20) DEFAULT NULL COMMENT '企业联系人电话',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='投资人表';

/*Table structure for table `fae_investor_account` */

DROP TABLE IF EXISTS `fae_investor_account`;

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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `fae_investor_repay_phase` */

DROP TABLE IF EXISTS `fae_investor_repay_phase`;

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
  PRIMARY KEY (`id`),
  KEY `idx_repayinfoid` (`repayInfoId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='投资人回款计划';

/*Table structure for table `fae_issue` */

DROP TABLE IF EXISTS `fae_issue`;

CREATE TABLE `fae_issue` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '发行方全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '发行方简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `cliqueId` int(10) NOT NULL DEFAULT '0' COMMENT '所属集团id(fae_clique)',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='发行人表';

/*Table structure for table `fae_product` */

DROP TABLE IF EXISTS `fae_product`;

CREATE TABLE `fae_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productType` int(4) NOT NULL DEFAULT '0' COMMENT '产品类型1-定向融资,2-收益权转让',
  `productName` varchar(128) NOT NULL DEFAULT '' COMMENT '产品名称',
  `issueId` int(11) NOT NULL DEFAULT '0' COMMENT '发行方id(fae_issue)',
  `underwriterId` int(11) NOT NULL DEFAULT '0' COMMENT '承销商id(fae_underwriter)',
  `danbaoId` int(11) NOT NULL DEFAULT '0' COMMENT '担保id(fae_danbao)',
  `entrustedId` int(11) NOT NULL DEFAULT '0' COMMENT '受托管理方id(fae_entrusted)',
  `raiseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '募集规模',
  `term` int(11) NOT NULL DEFAULT '0' COMMENT '产品期限',
  `termUnit` int(4) NOT NULL DEFAULT '1' COMMENT '期限单位1-天,2-月',
  `expectRate` decimal(4,2) DEFAULT '0.00' COMMENT '预期收益费率',
  `baseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '认购基数',
  `increaseAmount` decimal(14,2) DEFAULT '0.00' COMMENT '递增基数',
  `buyType` int(4) NOT NULL DEFAULT '0' COMMENT '认购方式1-线上,2-线下',
  `holdCalType` int(4) NOT NULL DEFAULT '0' COMMENT '存续期计算方式1-固定,2-递减',
  `endDate` date DEFAULT NULL COMMENT '截止日',
  `dueDate` date DEFAULT NULL COMMENT '到期日',
  `trans` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可以转让0否,1是',
  `lockTerm` int(4) NOT NULL DEFAULT '0' COMMENT '锁定期',
  `lockUnit` int(4) NOT NULL DEFAULT '0' COMMENT '锁定期单位1-天,2-月',
  `minEstablishAmount` decimal(14,2) DEFAULT '0.00' COMMENT '最低成立金额',
  `establishType` int(4) NOT NULL DEFAULT '0' COMMENT '成立方式1-手动成立,2-自动成立',
  `establishDay` varchar(64) DEFAULT '' COMMENT '成立时间(每个自然月？日)',
  `yearCalType` int(8) NOT NULL DEFAULT '0' COMMENT '年化单位(360天,365天)',
  `settlementType` int(4) NOT NULL DEFAULT '0' COMMENT '结算方式(1-本息一次,2-按月付息,3-按季付息,4-半年付息,5-按年付息)',
  `fixed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否固定日期还息(0-否,1-固定)',
  `fixedMonth` int(4) NOT NULL DEFAULT '0' COMMENT '固定还息月',
  `fixedDay` int(4) NOT NULL DEFAULT '0' COMMENT '固定还息日',
  `hasHang` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有挂牌费0-无,1-有',
  `hangMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '挂牌费最低额',
  `hangRate` decimal(4,2) DEFAULT '0.00' COMMENT '挂牌年化费率',
  `hangFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '挂牌收费方式(1-前置,2-扣收,3-月结)',
  `hangYjDay` int(4) NOT NULL DEFAULT '0' COMMENT '挂牌费月结日',
  `hasCx` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有承销商费0-无,1-有',
  `cxMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '承销商费最低额',
  `cxRate` decimal(4,2) DEFAULT '0.00' COMMENT '承销商费年化费率',
  `cxFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '承销商费收费方式(1-前置,2-扣收,3-月结)',
  `cxYjDay` int(4) NOT NULL DEFAULT '0' COMMENT '承销商费月结日',
  `hasSt` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有担保费(0-无,1-有)',
  `stMinFee` decimal(14,2) DEFAULT '0.00' COMMENT '担保费最低额',
  `stRate` decimal(4,2) DEFAULT '0.00' COMMENT '担保费年化费率',
  `stFeeType` int(4) NOT NULL DEFAULT '0' COMMENT '担保费收费方式(1-前置,2-扣收,3-月结)',
  `stYjDay` int(4) NOT NULL COMMENT '受托管理费月结日',
  `amountUse` varchar(255) DEFAULT '' COMMENT '资金用途',
  `increaseCredit` varchar(255) DEFAULT '' COMMENT '增信措施',
  `remark` varchar(255) DEFAULT '' COMMENT '特殊事项备注',
  `productStatus` int(4) NOT NULL DEFAULT '0' COMMENT '0-待提交,1-待审核,2-审核通过,3-审核驳回,4-待挂牌,5-待排期,6-排期中,7-投标中,8-已满标,9-已结清',
  `createTime` datetime NOT NULL COMMENT '创建时间(导入时间)',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`productStatus`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `fae_repay_info` */

DROP TABLE IF EXISTS `fae_repay_info`;

CREATE TABLE `fae_repay_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `establishId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '对应的成立信息(fae_establish_info)',
  `repayPhase` int(4) NOT NULL DEFAULT '0' COMMENT '还款期数',
  `repayPrincipal` decimal(14,2) DEFAULT '0.00' COMMENT '还款本金',
  `repayInterest` decimal(14,2) DEFAULT '0.00' COMMENT '还款利息',
  `repayStatus` int(4) NOT NULL DEFAULT '0' COMMENT '0-未还,1-还款中.2-已还',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `repayDate` date DEFAULT NULL COMMENT '还款日期',
  `productId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '产品id',
  `issueId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '发行方',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='借款人还款计划';

/*Table structure for table `fae_underwriter` */

DROP TABLE IF EXISTS `fae_underwriter`;

CREATE TABLE `fae_underwriter` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '承销商全称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '承销商简称',
  `creditCode` varchar(64) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='承销商表';

/*Table structure for table `fae_underwriter_investor` */

DROP TABLE IF EXISTS `fae_underwriter_investor`;

CREATE TABLE `fae_underwriter_investor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investorId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_investor的Id',
  `underwriterId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'fae_underwriter的id',
  PRIMARY KEY (`id`),
  KEY `idx_investor` (`investorId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='投资人对应承销商表';

/*Table structure for table `house_type` */

DROP TABLE IF EXISTS `house_type`;

CREATE TABLE `house_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `interview_spot` */

DROP TABLE IF EXISTS `interview_spot`;

CREATE TABLE `interview_spot` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `issue_org` */

DROP TABLE IF EXISTS `issue_org`;

CREATE TABLE `issue_org` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orgName` varchar(128) NOT NULL COMMENT '发行机构名称',
  `shortName` varchar(128) NOT NULL DEFAULT '' COMMENT '平台简称',
  `technologyRate` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '技术服务费率',
  `settlementRate` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '结算费率',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '0有效,1失效',
  `desciption` varchar(255) DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `loan` */

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `loanNo` varchar(128) NOT NULL DEFAULT '' COMMENT '网金的标的编号',
  `jjsLoanNo` varchar(128) NOT NULL DEFAULT '' COMMENT '金交所标的编号',
  `loanName` varchar(128) NOT NULL DEFAULT '',
  `saleAmount` decimal(14,2) DEFAULT NULL COMMENT '起投金额',
  `amount` decimal(14,2) DEFAULT NULL COMMENT '发行规模(标的金额)',
  `leftAmount` decimal(14,2) DEFAULT NULL COMMENT '剩余可售金额',
  `investDays` int(10) NOT NULL DEFAULT '0' COMMENT '投资期限',
  `rate` decimal(6,2) DEFAULT NULL COMMENT '利率',
  `issueOrgId` int(10) NOT NULL DEFAULT '0' COMMENT '发行机构Id对应表issue_org',
  `raiseAmount` decimal(14,2) DEFAULT NULL COMMENT '实际募集金额',
  `platStatus` int(4) NOT NULL DEFAULT '0' COMMENT '0-未入库,1-已入库,2-待上架,3-已上架,4-已下架,5-售罄',
  `jjsStatus` varchar(64) NOT NULL DEFAULT '' COMMENT '可售sell,售罄sellout,待售waitsell,下架offshelf',
  `platCreateTime` datetime DEFAULT NULL COMMENT '平台创建时间',
  `jjsCreateTime` date DEFAULT NULL COMMENT '金交所创建时间',
  `loanTag` varchar(255) DEFAULT '' COMMENT '标的标签',
  `autoShelf` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否自动上架0-否,1-是',
  `shelfTime` datetime DEFAULT NULL COMMENT '上架时间',
  `raiseStartTime` date DEFAULT NULL COMMENT '募集开始时间',
  `raiseEndTime` date DEFAULT NULL COMMENT '募集结束时间',
  `loanDueTime` date DEFAULT NULL COMMENT '标的到期时间',
  `repayDate` date DEFAULT NULL COMMENT '标的兑付日期',
  `actualRepayDate` date DEFAULT NULL COMMENT '实际还款日',
  `interestDate` date DEFAULT NULL COMMENT '标的起息日',
  `repayWay` int(4) NOT NULL DEFAULT '0' COMMENT '1-一次性还款付息',
  `riskType` varchar(64) DEFAULT '' COMMENT 'R1-低风险,R2-中低风险,R3-中风险,R4-中高风险,R5-高风险',
  `incomeExplain` varchar(255) DEFAULT '' COMMENT '收益说明',
  `contractType` int(4) DEFAULT '0' COMMENT '1-国内保理合同,2-贸易合同',
  `contractNo` varchar(255) DEFAULT '' COMMENT '合同编号',
  `contractAmount` decimal(14,2) DEFAULT '0.00' COMMENT '合同金额',
  `discount` decimal(8,2) DEFAULT '0.00' COMMENT '折扣率',
  `contractStartDate` date DEFAULT NULL COMMENT '合同起始日期',
  `contractEndDate` date DEFAULT NULL COMMENT '合同结束日期',
  `contractRate` decimal(6,2) DEFAULT '0.00' COMMENT '合同利率',
  `borrowerId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '标的借款人,对应cooperation_org',
  `danbaoId` int(10) NOT NULL DEFAULT '0' COMMENT '标的担保人,对应cooperation_org',
  `payerId` int(10) NOT NULL DEFAULT '0' COMMENT '应收账款付款方,对应cooperation_org',
  `reciveId` int(10) NOT NULL DEFAULT '0' COMMENT '应收账款收款方,对应cooperation_org',
  `packageRate` decimal(6,2) DEFAULT '0.00' COMMENT '打包费率',
  `technologyRate` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '技术服务费率',
  `settlementRate` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '结算费率',
  `hzPlatFeeRate` decimal(6,2) NOT NULL DEFAULT '0.00' COMMENT '合作平台费率(技术服务费率+结算费率)',
  `hzPlatFee` decimal(14,2) DEFAULT '0.00' COMMENT '合作平台服务费',
  `platFeeRate` decimal(6,2) DEFAULT '0.00' COMMENT '平台费率(打包费率-合作平台费率)',
  `platFee` decimal(14,2) DEFAULT '0.00' COMMENT '平台服务费',
  `actualSettlement` decimal(14,2) DEFAULT '0.00' COMMENT '实际放款金额',
  PRIMARY KEY (`id`),
  KEY `idx_loanName` (`loanName`),
  KEY `idx_platStatus` (`platStatus`) USING BTREE,
  KEY `idx_jjsStatus` (`jjsStatus`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8;

/*Table structure for table `loan_invest` */

DROP TABLE IF EXISTS `loan_invest`;

CREATE TABLE `loan_invest` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `loanId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '标的id',
  `investNo` varchar(64) NOT NULL DEFAULT '' COMMENT '投资记录(平台)流水号',
  `investorId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '投资人id',
  `investAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '投资金额',
  `investTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '投资时间',
  `handleStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '处理状态，当前被用于提成计算',
  `orderStatus` varchar(64) NOT NULL DEFAULT '' COMMENT '订单状态',
  `orderNo` varchar(64) NOT NULL DEFAULT '' COMMENT '交易所订单编号',
  `refreshTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT ' 刷新时间',
  `expectIncome` decimal(14,2) DEFAULT '0.00' COMMENT '预期收益',
  PRIMARY KEY (`id`),
  KEY `idx_investUserId` (`investorId`),
  KEY `idx_handleStatus` (`handleStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=12343 DEFAULT CHARSET=utf8 COMMENT='投资记录';

/*Table structure for table `loan_invest_royalty` */

DROP TABLE IF EXISTS `loan_invest_royalty`;

CREATE TABLE `loan_invest_royalty` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `investId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '投资记录id',
  `stockPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '投资发生时的存量本金',
  `incrementalPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '投资发生时的增量本金',
  `stockRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量提成',
  `incrementalRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '增量提成',
  `clerkId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '经纪人id',
  `investAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '投资额',
  `royaltyId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'royalty_info 表的id',
  `royaltyUserId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'royalty_user_info表的id',
  `roytalTop` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量top',
  PRIMARY KEY (`id`),
  KEY `idx_investId` (`investId`),
  KEY `idx_clerkId` (`clerkId`)
) ENGINE=InnoDB AUTO_INCREMENT=33169 DEFAULT CHARSET=utf8 COMMENT='投资提成';

/*Table structure for table `material_info` */

DROP TABLE IF EXISTS `material_info`;

CREATE TABLE `material_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `typeId` int(10) unsigned NOT NULL DEFAULT '0',
  `typeTag` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `img1` varchar(256) NOT NULL DEFAULT '',
  `img2` varchar(256) DEFAULT NULL,
  `img3` varchar(256) DEFAULT NULL,
  `userId` int(10) unsigned NOT NULL DEFAULT '0',
  `img1WxLocalId` varchar(256) DEFAULT NULL,
  `img1WxDowned` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`),
  KEY `idx_wxDowned` (`img1WxDowned`)
) ENGINE=InnoDB AUTO_INCREMENT=978 DEFAULT CHARSET=utf8;

/*Table structure for table `material_type` */

DROP TABLE IF EXISTS `material_type`;

CREATE TABLE `material_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='图片类别';

/*Table structure for table `message_info` */

DROP TABLE IF EXISTS `message_info`;

CREATE TABLE `message_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `deptType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '给哪个部门看',
  `userId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '进件录入人员',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `applyStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '进件状态',
  `permitId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作权限id',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `auditId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '状态变化id',
  `op` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是操作消息',
  `opType` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作类别',
  `viewerId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '只能某个用户看',
  `allocateStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '分配状态',
  `allocateId` int(10) unsigned NOT NULL DEFAULT '0',
  `reject` tinyint(1) NOT NULL DEFAULT '0' COMMENT '驳回',
  `warrantStatus` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '权证消息状态',
  `warrant` tinyint(1) NOT NULL DEFAULT '0',
  `messengerId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '沟通记录id',
  `viewed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已读',
  `addition` tinyint(1) NOT NULL DEFAULT '0',
  `mainBaseInfoId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '原始进件id',
  `reloan` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_deptId` (`deptType`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2512 DEFAULT CHARSET=utf8;

/*Table structure for table `message_user_info` */

DROP TABLE IF EXISTS `message_user_info`;

CREATE TABLE `message_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `messageId` int(10) unsigned NOT NULL DEFAULT '0',
  `userId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_messageId_userId` (`messageId`,`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8;

/*Table structure for table `messenger_info` */

DROP TABLE IF EXISTS `messenger_info`;

CREATE TABLE `messenger_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(2048) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `sender` int(10) unsigned NOT NULL DEFAULT '0',
  `sendTos` varchar(512) NOT NULL DEFAULT '',
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `applyStatus` int(10) unsigned NOT NULL DEFAULT '0',
  `addition` tinyint(1) NOT NULL DEFAULT '0',
  `additionBaseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`),
  KEY `idx_mainBaseInfoId` (`additionBaseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Table structure for table `mobile_available` */

DROP TABLE IF EXISTS `mobile_available`;

CREATE TABLE `mobile_available` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) NOT NULL DEFAULT '',
  `ip` varchar(45) NOT NULL DEFAULT '',
  `cookie` varchar(256) NOT NULL DEFAULT '',
  `checkTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Table structure for table `mobile_check_token` */

DROP TABLE IF EXISTS `mobile_check_token`;

CREATE TABLE `mobile_check_token` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) unsigned NOT NULL DEFAULT '0',
  `tokenType` int(10) unsigned NOT NULL DEFAULT '0',
  `sendTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `checkTime` datetime DEFAULT NULL,
  `ip` varchar(45) NOT NULL DEFAULT '',
  `cookie` varchar(256) NOT NULL DEFAULT '',
  `mobile` varchar(20) NOT NULL,
  `availableTime` datetime NOT NULL,
  `token` varchar(128) NOT NULL DEFAULT '',
  `source` int(10) NOT NULL DEFAULT '0',
  `mode` int(10) unsigned NOT NULL DEFAULT '0',
  `idCardNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_token` (`token`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '公告标题',
  `content` text COMMENT '内容',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-待发布,1-已发布,2-已失效',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '公告类型0.平台内部，1.商户',
  `validType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '发布类型0-立即发布,1-定时发布',
  `releaseTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '发布时间',
  `createTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `pay_request_info` */

DROP TABLE IF EXISTS `pay_request_info`;

CREATE TABLE `pay_request_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `requestTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `requestInfo` text NOT NULL,
  `responseInfo` varchar(512) DEFAULT NULL,
  `responseCode` varchar(64) DEFAULT NULL,
  `responseMess` varchar(64) DEFAULT NULL,
  `statusCode` int(10) unsigned NOT NULL DEFAULT '0',
  `exceptionName` varchar(256) DEFAULT NULL,
  `requestUrl` varchar(256) DEFAULT NULL,
  `synLoanRecordId` int(10) NOT NULL DEFAULT '0' COMMENT 'syn_loan_record的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8;

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `position_info` */

DROP TABLE IF EXISTS `position_info`;

CREATE TABLE `position_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `deptId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `companyId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_deptId` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='岗位表';

/*Table structure for table `position_level` */

DROP TABLE IF EXISTS `position_level`;

CREATE TABLE `position_level` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `deptId` int(10) unsigned NOT NULL DEFAULT '0',
  `positionId` int(10) unsigned NOT NULL DEFAULT '0',
  `companyId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_positionId` (`positionId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `logoPath` varchar(256) NOT NULL DEFAULT '',
  `description` varchar(1024) DEFAULT NULL,
  `feature` varchar(128) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(64) NOT NULL DEFAULT '',
  `productNo` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `reg_sms_check` */

DROP TABLE IF EXISTS `reg_sms_check`;

CREATE TABLE `reg_sms_check` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) NOT NULL DEFAULT '',
  `code` varchar(6) NOT NULL DEFAULT '',
  `ip` varchar(45) NOT NULL DEFAULT '',
  `cookie` varchar(256) NOT NULL DEFAULT '',
  `sendTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `checkTime` datetime DEFAULT NULL,
  `lastSendTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ref` int(10) unsigned NOT NULL DEFAULT '0',
  `channel` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_ip` (`ip`),
  KEY `idx_ip_cookie` (`ip`,`cookie`(255)),
  KEY `idx_cookie_mobile` (`mobile`,`cookie`(255))
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Table structure for table `repay_plan` */

DROP TABLE IF EXISTS `repay_plan`;

CREATE TABLE `repay_plan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phase` int(10) unsigned NOT NULL DEFAULT '0',
  `principal` decimal(14,2) NOT NULL DEFAULT '0.00',
  `interest` decimal(14,2) NOT NULL DEFAULT '0.00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `baseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `planRepayDate` date DEFAULT NULL,
  `loanDate` date DEFAULT NULL,
  `repayDate` date DEFAULT NULL,
  `mainBaseInfoId` int(10) unsigned NOT NULL DEFAULT '0',
  `addition` tinyint(1) NOT NULL DEFAULT '0',
  `planLoanAmount` decimal(14,2) NOT NULL DEFAULT '0.00',
  `loanAmount` decimal(14,2) NOT NULL DEFAULT '0.00',
  `loanTime` datetime DEFAULT NULL,
  `loanRemark` varchar(512) DEFAULT NULL,
  `totalRate` decimal(6,2) NOT NULL DEFAULT '0.00',
  `termCount` int(10) unsigned NOT NULL DEFAULT '0',
  `planLoanDate` date NOT NULL DEFAULT '0000-00-00',
  `repayAmount` decimal(14,2) NOT NULL DEFAULT '0.00',
  `repayTime` datetime DEFAULT NULL,
  `repayRemark` varchar(512) DEFAULT NULL,
  `source` int(10) unsigned NOT NULL DEFAULT '0',
  `sourceId` int(10) unsigned NOT NULL DEFAULT '0',
  `parentId` int(10) unsigned NOT NULL DEFAULT '0',
  `display` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否会显示',
  `base` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是最原始还款计划',
  `reloanPreRepayPlanId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '展期上一环节还款计划',
  `reloanBaseRepayPlanId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '展期原始还款计划',
  `reloan` tinyint(1) NOT NULL DEFAULT '0',
  `interestPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '用于计息的本金',
  PRIMARY KEY (`id`),
  KEY `idx_baseInfoId` (`baseInfoId`),
  KEY `idx_mainBaseInfoId` (`mainBaseInfoId`),
  KEY `idx_parentId` (`parentId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Table structure for table `royalty_info` */

DROP TABLE IF EXISTS `royalty_info`;

CREATE TABLE `royalty_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `startDate` date NOT NULL DEFAULT '0000-00-00' COMMENT '起始日期',
  `endDate` date NOT NULL DEFAULT '0000-00-00' COMMENT '结束日期',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `finishTime` datetime DEFAULT NULL,
  `achieve` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '本期业绩',
  `royalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '本期提成',
  `stockPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量本金',
  `incrementalPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '增量本金',
  `stockRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量提成',
  `incrementalRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '增量提成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='业绩周期表';

/*Table structure for table `royalty_param` */

DROP TABLE IF EXISTS `royalty_param`;

CREATE TABLE `royalty_param` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `period` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0 按月 1 时间段',
  `periodDay` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '每月结算日， period=0时生效',
  `royaltyDate` date DEFAULT NULL COMMENT '固定结算日， period=1时生效',
  `lastRoyaltyDate` date DEFAULT NULL COMMENT '上一结算日',
  `lastRoyaltyMonth` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上一结算月',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `royalty_strategy` */

DROP TABLE IF EXISTS `royalty_strategy`;

CREATE TABLE `royalty_strategy` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `roleId` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='提成策略主表';

/*Table structure for table `royalty_strategy_detail` */

DROP TABLE IF EXISTS `royalty_strategy_detail`;

CREATE TABLE `royalty_strategy_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `strategyId` int(10) unsigned NOT NULL DEFAULT '0',
  `start` decimal(14,2) NOT NULL DEFAULT '0.00',
  `end` decimal(14,2) NOT NULL DEFAULT '0.00',
  `lt` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 无  1 小于  2小于等于',
  `gt` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 无  1大于  2 大于等于',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `stockRoyaltyRate` decimal(4,2) NOT NULL DEFAULT '0.00',
  `incrementalRoyaltyRate` decimal(4,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `idx_strategyId` (`strategyId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `royalty_user_info` */

DROP TABLE IF EXISTS `royalty_user_info`;

CREATE TABLE `royalty_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `royaltyId` int(10) unsigned NOT NULL DEFAULT '0',
  `achieve` decimal(14,2) NOT NULL DEFAULT '0.00',
  `royalty` decimal(14,2) NOT NULL DEFAULT '0.00',
  `clerkId` int(10) unsigned NOT NULL DEFAULT '0',
  `stockPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量本金',
  `incrementalPrincipal` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '增量本金',
  `stockRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '存量提成',
  `incrementalRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '增量提成',
  `royaltyNo` varchar(32) DEFAULT NULL COMMENT '业绩编号',
  PRIMARY KEY (`id`),
  KEY `idx_royaltyIdclerkId` (`royaltyId`,`clerkId`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COMMENT='单个用户的提成统计';

/*Table structure for table `share_info` */

DROP TABLE IF EXISTS `share_info`;

CREATE TABLE `share_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '文章类型',
  `articleCategory` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '文章类别',
  `pic` varchar(256) NOT NULL COMMENT '图片路径',
  `content` text COMMENT '文章内容',
  `title` varchar(256) NOT NULL COMMENT '标题',
  `pos` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '推荐位',
  `status` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '状态',
  `createDate` datetime NOT NULL,
  `readCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '阅读数',
  `shareCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '分享数',
  `shareReadCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '分享阅读数',
  `readCostId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '阅读费用id',
  `shareCostId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '分享费用id',
  `keyword` varchar(50) DEFAULT NULL COMMENT '关键字',
  `regCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '注册数',
  `shareTitle` varchar(128) NOT NULL COMMENT '分享标题',
  `shareDesc` varchar(128) NOT NULL COMMENT '分享内容',
  `qunfa` tinyint(2) DEFAULT '0',
  `otherLink` varchar(256) DEFAULT NULL,
  `publishFlag` tinyint(1) NOT NULL DEFAULT '0',
  `publishTime` datetime DEFAULT NULL,
  `rewardId` int(12) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_status` (`status`) USING BTREE,
  KEY `index_read_cost_id` (`readCostId`) USING BTREE,
  KEY `index_share_cost_id` (`shareCostId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1856 DEFAULT CHARSET=utf8;

/*Table structure for table `sms_trace` */

DROP TABLE IF EXISTS `sms_trace`;

CREATE TABLE `sms_trace` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` text NOT NULL,
  `content` varchar(512) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  `seq` varchar(128) DEFAULT NULL,
  `ret` varchar(256) DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  `lastTryTime` datetime DEFAULT NULL,
  `tryTimes` int(10) unsigned NOT NULL DEFAULT '0',
  `channel` varchar(45) DEFAULT NULL,
  `smsType` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=907 DEFAULT CHARSET=utf8;

/*Table structure for table `sms_trace_detail` */

DROP TABLE IF EXISTS `sms_trace_detail`;

CREATE TABLE `sms_trace_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `traceId` int(10) unsigned NOT NULL DEFAULT '0',
  `tryTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mobile` text NOT NULL,
  `content` varchar(512) NOT NULL DEFAULT '',
  `ret` varchar(256) DEFAULT NULL,
  `succ` tinyint(1) NOT NULL DEFAULT '0',
  `channel` varchar(45) NOT NULL DEFAULT '',
  `seq` varchar(128) NOT NULL,
  `template` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_traceId` (`traceId`)
) ENGINE=InnoDB AUTO_INCREMENT=762 DEFAULT CHARSET=utf8;

/*Table structure for table `syn_loan_record` */

DROP TABLE IF EXISTS `syn_loan_record`;

CREATE TABLE `syn_loan_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `status` int(11) NOT NULL COMMENT '0-开始同步,1-同步中,2-同步成功,3-失败',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

/*Table structure for table `sysRolePermit` */

DROP TABLE IF EXISTS `sysRolePermit`;

CREATE TABLE `sysRolePermit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `refId` int(11) NOT NULL COMMENT '菜单ID',
  `permit` tinyint(4) NOT NULL DEFAULT '0' COMMENT '授权状态',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2716 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `sysUserPermit` */

DROP TABLE IF EXISTS `sysUserPermit`;

CREATE TABLE `sysUserPermit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(8) NOT NULL DEFAULT '0',
  `refId` int(8) NOT NULL DEFAULT '0',
  `permit` tinyint(1) NOT NULL DEFAULT '1',
  `roleId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_operate_log` */

DROP TABLE IF EXISTS `sys_operate_log`;

CREATE TABLE `sys_operate_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sysUserId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '系统用户Id',
  `logMessage` varchar(255) DEFAULT '',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_permit` */

DROP TABLE IF EXISTS `sys_permit`;

CREATE TABLE `sys_permit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `action` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '路径',
  `roleId` int(10) unsigned NOT NULL COMMENT '角色ID',
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'menu' COMMENT '权限类型（menu：菜单，other：其他权限）',
  `displayseq` int(10) unsigned NOT NULL COMMENT '菜单层级',
  `modleName` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `parentId` int(10) unsigned NOT NULL COMMENT '父节点',
  `defaultPermit` tinyint(1) unsigned NOT NULL,
  `tag` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authCode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roleKey` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=503 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `auth` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色权限验证标识',
  `department` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'customerService',
  `status` tinyint(2) unsigned DEFAULT NULL COMMENT '状态(0.无效，1.有效)',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT '',
  `deptId` int(10) unsigned DEFAULT '0',
  `levelId` int(10) unsigned DEFAULT '0',
  `loginName` varchar(45) DEFAULT '',
  `mobile` varchar(45) DEFAULT '',
  `registerTime` datetime DEFAULT '0001-01-01 00:00:00',
  `passwd` varchar(128) DEFAULT '',
  `passwdChanged` tinyint(1) DEFAULT '0',
  `status` int(10) unsigned DEFAULT '0',
  `companyId` int(10) unsigned DEFAULT '0',
  `roleId` int(10) unsigned DEFAULT '0',
  `gender` int(10) unsigned DEFAULT '0',
  `positionId` int(10) unsigned DEFAULT '0',
  `leaderId` int(10) unsigned DEFAULT '0',
  `lockStatus` int(2) unsigned DEFAULT '0' COMMENT '锁定状态 0.未锁定，1.锁定',
  `authorities` varchar(200) DEFAULT NULL COMMENT '权限列表',
  `enabled` int(2) unsigned DEFAULT '0' COMMENT '是否启用 0.已启用，1.未启用',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00',
  `updatetime` datetime DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_loginName` (`loginName`),
  KEY `idx_mobile` (`mobile`),
  KEY `idx_companyId_deptId` (`companyId`,`deptId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

/*Table structure for table `testtb` */

DROP TABLE IF EXISTS `testtb`;

CREATE TABLE `testtb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `t` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=340968 DEFAULT CHARSET=utf8;

/*Table structure for table `testtb2` */

DROP TABLE IF EXISTS `testtb2`;

CREATE TABLE `testtb2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=319773 DEFAULT CHARSET=utf8;

/*Table structure for table `top_history` */

DROP TABLE IF EXISTS `top_history`;

CREATE TABLE `top_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) unsigned NOT NULL DEFAULT '0',
  `investId` int(10) unsigned NOT NULL DEFAULT '0',
  `top` decimal(14,2) NOT NULL DEFAULT '0.00',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=29711 DEFAULT CHARSET=utf8 COMMENT='top值历史表';

/*Table structure for table `updown_enterprise` */

DROP TABLE IF EXISTS `updown_enterprise`;

CREATE TABLE `updown_enterprise` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(64) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `updown_enterprise_tag` */

DROP TABLE IF EXISTS `updown_enterprise_tag`;

CREATE TABLE `updown_enterprise_tag` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `enterpriseId` int(10) unsigned NOT NULL DEFAULT '0',
  `tagId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_enterpriseId` (`enterpriseId`),
  KEY `idx_tagId` (`tagId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Table structure for table `updown_tag` */

DROP TABLE IF EXISTS `updown_tag`;

CREATE TABLE `updown_tag` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(45) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `user_main` */

DROP TABLE IF EXISTS `user_main`;

CREATE TABLE `user_main` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL,
  `realName` varchar(64) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(64) NOT NULL DEFAULT '',
  `inviteCode` varchar(128) DEFAULT NULL COMMENT '邀请码',
  `refCode` varchar(128) DEFAULT NULL COMMENT '受邀码',
  `idCardType` varchar(64) DEFAULT NULL COMMENT '身份证 PRC_ID 、护照 PASSPORT 、港澳台同胞回乡证 COMPATRIOTS_CARD、外国人永久居住证 PERMANENT_RESIDENCE',
  `idCardNo` varchar(128) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '0-正常,1-禁用',
  `registerTime` datetime DEFAULT NULL,
  `registerChannel` varchar(128) DEFAULT NULL,
  `clerk` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否经纪人',
  `roytalTop` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '提成top值',
  `clerkRoleId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '内部用户角色',
  PRIMARY KEY (`id`),
  KEY `idx_inviteCode` (`inviteCode`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=6737 DEFAULT CHARSET=utf8;

/*Table structure for table `user_statistic` */

DROP TABLE IF EXISTS `user_statistic`;

CREATE TABLE `user_statistic` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `totalStockRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总存量提成',
  `totalIncrementalRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总增量提成',
  `totalRoyalty` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总提成',
  `totalInvestAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总投资额',
  `totalRoyaltied` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总贡献提成',
  `totalRoyaltyInvestAmount` decimal(14,2) NOT NULL DEFAULT '0.00' COMMENT '总提成贡献投资额',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6737 DEFAULT CHARSET=utf8 COMMENT='用户统计表';

/*Table structure for table `wap_user` */

DROP TABLE IF EXISTS `wap_user`;

CREATE TABLE `wap_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
