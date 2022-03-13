/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50736
Source Host           : localhost:3306
Source Database       : car_rental

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-03-13 13:50:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carModel` varchar(255) NOT NULL,
  `lockTime` bigint(20) DEFAULT '0' COMMENT 'if the car is ordered but not confirm, it will be locked for 1 hour',
  `rentTime` bigint(20) DEFAULT '0' COMMENT 'the time a car is rented',
  `renterId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT 'car status: 0 -> free, 1 -> lock, 2 -> rented',
  `picture` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', 'Toyota Camry ', '1647101868063', null, '2', '1', '/img/ToyotaCamry-1.png', 'pretty good');
INSERT INTO `car` VALUES ('2', 'BMW 650 ', '1647088090600', null, '1', '1', '/img/BMW650-1.png', 'good');
INSERT INTO `car` VALUES ('3', 'Toyota Camry ', '0', null, null, '1', '/img/ToyotaCamry-2.png', 'new');
INSERT INTO `car` VALUES ('4', 'BMW 650 ', '0', null, null, '0', '/img/BMW650-2.png', 'old but good');

-- ----------------------------
-- Table structure for renter
-- ----------------------------
DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_phone` (`phone`) USING BTREE,
  UNIQUE KEY `key_name_phone` (`name`,`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renter
-- ----------------------------
INSERT INTO `renter` VALUES ('1', 'Javie', '15659807545', '');
INSERT INTO `renter` VALUES ('2', 'name', '15659887744', 'wall street');
