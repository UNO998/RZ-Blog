-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'ADMIN');
INSERT INTO `roles` VALUES ('2', 'USER');
INSERT INTO `roles` VALUES ('3', 'TEST_ROLE_1');
INSERT INTO `roles` VALUES ('4', 'TEST_ROLE_2');
INSERT INTO `roles` VALUES ('5', 'TEST_ROLE_3');


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'laihaotao', 'Eric', '202cb962ac59075b964b07152d234b70', '1', 'laihaotao@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920326&di=44a6fa6b597d86f475c2b15fa93008dd&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-12%2F023019564.jpg', '2017-12-08 09:30:22');
INSERT INTO `user` VALUES ('7', 'shenyiran', 'Bernie', '202cb962ac59075b964b07152d234b70', '1', 'shenyiran@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-21 13:30:29');
INSERT INTO `user` VALUES ('10', 'houjingye', 'Jack', '202cb962ac59075b964b07152d234b70', '1', 'houjingye@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('13', 'luoqinwei', 'Lqw', '202cb962ac59075b964b07152d234b70', '0', 'luoqinwei@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('14', 'libo', 'bob', '202cb962ac59075b964b07152d234b70', '0', 'libo@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('15', 'caihongbin', 'caizhidao', '202cb962ac59075b964b07152d234b70', '1', 'caihongbin@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('16', 'root1', 'chaojiguanli', '202cb962ac59075b964b07152d234b70', '1', 'chuliuxiang@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('17', 'baizhantang', 'baizhantang', '202cb962ac59075b964b07152d234b70', '0', 'baizhantang@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('18', 'renwoxing', 'renwoxing', '202cb962ac59075b964b07152d234b70', '1', 'renwoxing@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('19', 'zuolengchan', 'zuolengchan', '202cb962ac59075b964b07152d234b70', '1', 'zuolengchan@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');
INSERT INTO `user` VALUES ('20', 'fengqingyang', 'fengqingyang', '202cb962ac59075b964b07152d234b70', '1', 'fengqingyang@qq.com', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '2017-12-24 06:30:46');


-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES ('8', '2', '7');
INSERT INTO `roles_user` VALUES ('17', '5', '7');
INSERT INTO `roles_user` VALUES ('106', '2', '14');
INSERT INTO `roles_user` VALUES ('108', '2', '16');
INSERT INTO `roles_user` VALUES ('109', '2', '17');
INSERT INTO `roles_user` VALUES ('110', '2', '18');
INSERT INTO `roles_user` VALUES ('111', '2', '19');
INSERT INTO `roles_user` VALUES ('112', '2', '20');
INSERT INTO `roles_user` VALUES ('119', '2', '15');
INSERT INTO `roles_user` VALUES ('120', '5', '15');
INSERT INTO `roles_user` VALUES ('121', '2', '6');
INSERT INTO `roles_user` VALUES ('123', '2', '13');
INSERT INTO `roles_user` VALUES ('124', '3', '13');
INSERT INTO `roles_user` VALUES ('128', '2', '10');
INSERT INTO `roles_user` VALUES ('129', '5', '10');
INSERT INTO `roles_user` VALUES ('130', '1', '16');