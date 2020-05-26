/*
Navicat MySQL Data Transfer

Source Server         : innovation
Source Server Version : 50721
Source Host           : 58.206.100.146:3306
Source Database       : cnki

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-05-26 12:16:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cnki
-- ----------------------------
DROP TABLE IF EXISTS `cnki`;
CREATE TABLE `cnki` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `spidertime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cnki
-- ----------------------------
INSERT INTO `cnki` VALUES ('1', '大学生论文检测系统PMLC-专科、本科毕业论文定稿', '398.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('2', '学术不端文献检测系统5.3-硕士、博士毕业论文定稿', '598.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('3', '科技期刊文献检测系统AMLC-期刊杂志投稿、职称评审', '88.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('4', '大分解论文检测系统-专、本、硕、博毕业论文初稿', '218.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('5', '小分解论文检测系统-专、本、硕、博毕业论文初稿', '88.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('6', '大学生毕业设计管理系统-特定高校专本定稿', '350.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('7', '课程作业管理系统-本、专、硕、博课程作业', '188.00', '2020-05-22 11:24:48');
INSERT INTO `cnki` VALUES ('9', '大学生论文检测系统PMLC-专科、本科毕业论文定稿', '398.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('10', '学术不端文献检测系统5.3-硕士、博士毕业论文定稿', '680.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('11', '科技期刊文献检测系统AMLC-期刊杂志投稿、职称评审', '88.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('12', '大分解论文检测系统-专、本、硕、博毕业论文初稿', '218.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('13', '小分解论文检测系统-专、本、硕、博毕业论文初稿', '88.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('14', '大学生毕业设计管理系统-特定高校专本定稿', '350.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('15', '课程作业管理系统-本、专、硕、博课程作业', '188.00', '2020-05-24 11:26:25');
INSERT INTO `cnki` VALUES ('16', '大学生论文检测系统PMLC-专科、本科毕业论文定稿', '398.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('17', '学术不端文献检测系统5.3-硕士、博士毕业论文定稿', '880.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('18', '科技期刊文献检测系统AMLC-期刊杂志投稿、职称评审', '88.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('19', '大分解论文检测系统-专、本、硕、博毕业论文初稿', '218.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('20', '小分解论文检测系统-专、本、硕、博毕业论文初稿', '88.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('21', '大学生毕业设计管理系统-特定高校专本定稿', '350.00', '2020-05-26 11:26:40');
INSERT INTO `cnki` VALUES ('22', '课程作业管理系统-本、专、硕、博课程作业', '188.00', '2020-05-26 11:26:40');

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `isspider` int(11) DEFAULT '0',
  `spidertime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url
-- ----------------------------
INSERT INTO `url` VALUES ('1', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 11:24:47');
INSERT INTO `url` VALUES ('2', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 11:26:25');
INSERT INTO `url` VALUES ('3', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 11:26:40');
INSERT INTO `url` VALUES ('4', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 12:24:56');
INSERT INTO `url` VALUES ('5', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 12:28:13');
INSERT INTO `url` VALUES ('6', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 12:28:13');
INSERT INTO `url` VALUES ('7', 'http://www.cnkisci.com/cnki/', '1', '2020-05-26 12:33:45');
SET FOREIGN_KEY_CHECKS=1;
