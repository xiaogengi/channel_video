/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : channel

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/01/2020 14:51:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '直播间id',
  `channel_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xg_user
-- ----------------------------
DROP TABLE IF EXISTS `xg_user`;
CREATE TABLE `xg_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(180) DEFAULT NULL COMMENT '用户昵称',
  `user_sex` int(1) DEFAULT NULL COMMENT '用户性别 0男  1女',
  `user_pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `user_account` varchar(50) DEFAULT NULL COMMENT '账号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xg_video
-- ----------------------------
DROP TABLE IF EXISTS `xg_video`;
CREATE TABLE `xg_video` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `video_name` varchar(255) DEFAULT NULL COMMENT '视频名称',
  `img_file` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `video_file` varchar(255) DEFAULT NULL COMMENT '视频',
  `user_id` int(10) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
