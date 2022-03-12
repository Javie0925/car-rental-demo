-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL default '' comment 'name',
  `password` varchar(100) NOT NULL default '' comment 'pwd',
  `role` varchar(15) NOT NULL default '' comment 'role',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renter
-- ----------------------------
INSERT INTO `renter` VALUES ('1', 'alex', 'alex', 'admin');
INSERT INTO `renter` VALUES ('2', 'user', 'user', 'user');
INSERT INTO `renter` VALUES ('3', '1', '1', 'admin');
INSERT INTO `renter` VALUES ('4', '2', '2', 'admin');
INSERT INTO `renter` VALUES ('22', '3', '3', 'user');
INSERT INTO `renter` VALUES ('25', '4', '4', 'user');


DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `carModel ` varchar(10) NOT NULL default '' comment 'car model',
  `total` int(10) NOT NULL default '0' comment 'company total carEntity',
  `stock` int(10) NOT NULL default '0' comment 'role',
  `lockTime` bigint default '0' comment 'lock time',
  `rentTime` bigint default '0' comment 'rent time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', 'Toyota Camry', '2', '2');
INSERT INTO `car` VALUES ('2', 'BMW 650', '2', '2');



DROP TABLE IF EXISTS `rental_car`;
CREATE TABLE `user_car` (
  `rentalId` int(10) NOT NULL default '0' comment 'user table primary key',
  `carId` int(10) NOT NULL default '0' comment 'carEntity table primary key',
  `count` int(10)NOT NULL default '0' comment 'rent car count'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

