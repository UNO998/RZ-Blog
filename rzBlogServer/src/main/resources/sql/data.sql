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

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('56', 'Vue22', '2017-12-21');
INSERT INTO `category` VALUES ('58', 'ControlLife', '2017-12-21');
INSERT INTO `category` VALUES ('60', 'JavaEE', '2017-12-21');
INSERT INTO `category` VALUES ('61', 'Git', '2017-12-21');
INSERT INTO `category` VALUES ('62', 'Linux', '2017-12-21');
INSERT INTO `category` VALUES ('64', 'MongoDB', '2017-12-23');

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('66', '666');
INSERT INTO `tags` VALUES ('35', 'Ajax');
INSERT INTO `tags` VALUES ('36', 'Dubbo');
INSERT INTO `tags` VALUES ('40', 'git');
INSERT INTO `tags` VALUES ('33', 'Linux');
INSERT INTO `tags` VALUES ('45', 'mongodb');
INSERT INTO `tags` VALUES ('42', 'spring');
INSERT INTO `tags` VALUES ('44', 'SpringSecurity');
INSERT INTO `tags` VALUES ('37', 'websocket');
INSERT INTO `tags` VALUES ('34', 'Zookeeper');
INSERT INTO `tags` VALUES ('50', 'Unix');
INSERT INTO `tags` VALUES ('51', 'Ubuntu');
INSERT INTO `tags` VALUES ('41', 'Mac');
INSERT INTO `tags` VALUES ('65', 'Windowns');

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('108', 'Linux install zookeeper', '最近打算出一个系列，介绍Dubbo的使用。', 'htmlConent', 'summary', '60', '6', '2017-12-24 09:34:29', '2017-12-24 09:34:29', '1', '5');
INSERT INTO `article` VALUES ('109', 'Ajax上传图片以及上传之前先预览', '手头上有几个小项目用到了easyUI，', 'htmlConent', 'summary','56', '6', '2017-12-24 09:35:06', '2017-12-24 09:35:06', '1', '0');
INSERT INTO `article` VALUES ('110', '一个简单的案例带你入门Dubbo分布式框架666', '相信有很多小伙伴都知道，dubbo是一个分布式、', 'htmlConent', 'summary','60', '6', '2017-12-21 22:33:31', '2017-12-21 22:33:31', '1', '0');
INSERT INTO `article` VALUES ('111', 'WebSocket刨根问底(一)', '年初的时候，写过两篇博客介绍在Spring Boot中如何使用WebSocket', 'htmlConent', 'summary','60', '6', '2017-12-21 22:34:02', '2017-12-21 22:34:02', '2', '0');
INSERT INTO `article` VALUES ('113', 'WebSocket刨根问底(三)之群聊', '前两篇文章【[WebSocket刨根问底(一) ]', 'htmlConent', 'summary','60', '6', '2017-12-21 22:34:35', '2017-12-21 22:34:35', '2', '4');
INSERT INTO `article` VALUES ('114', '一点点Github上的学习资料', '## 缘起\n从年初到现在，在GitHub上也积累了几个开源项目，', 'htmlConent', 'summary','61', '7', '2017-12-21 22:35:20', '2017-12-21 22:35:20', '1', '55');
INSERT INTO `article` VALUES ('115', '投稿指南', '年初做这个公号的初衷是希望能够和各位JavaEE同行有一个交流的平台，', 'htmlConent', 'summary','60', '6', '2017-12-21 22:40:16', '2017-12-21 22:40:16', '2', '99');
INSERT INTO `article` VALUES ('116', 'SpringBoot+SpringSecurity处理Ajax登录请求', '最近在项目中遇到了这样一个问题：前后端', 'htmlConent', 'summary','60', '6', '2017-12-21 23:34:33', '2017-12-21 23:34:33', '1', '15');
INSERT INTO `article` VALUES ('117', '人生感悟', '人生感悟人生感悟人生感悟人生感悟人生感悟人生感悟人生感悟人生感悟人生感悟人生', 'htmlConent', 'summary','58', '7', null, '2017-12-22 10:22:33', '2', '0');
INSERT INTO `article` VALUES ('118', '初识MongoDB中的索引', '索引就像图书的目录一样，可以让我们快速定位到需要的内容，关系型数据', 'htmlConent', 'summary','64', '6', '2017-12-23 21:42:59', '2017-12-23 21:42:59', '1', '999');
INSERT INTO `article` VALUES ('119', 'Git学习资料', '关于Git的用法我们已经写七篇文章，介绍了Git的不少用法，这些足以应付工作中90%的需求', 'htmlConent', 'summary','61', '7', '2017-12-24 09:00:05', '2017-12-24 09:00:05', '1', '2');
INSERT INTO `article` VALUES ('120', '人生感悟2222666666666', '人生感悟2人生感悟2人生感悟2人生感悟2人生感悟2人生感悟2人', 'htmlConent', 'summary','58', '6', '2017-12-24 10:10:33', '2017-12-24 10:10:33', '1', '5');
INSERT INTO `article` VALUES ('121', '感悟感悟', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 'htmlConent', 'summary','58', '7', '2017-12-24 22:32:20', '2017-12-24 22:32:20', '1', '3');
-- ----------------------------
-- Records of article_tags
-- ----------------------------
INSERT INTO `article_tags` VALUES ('26', '116', '42');
INSERT INTO `article_tags` VALUES ('27', '116', '44');
INSERT INTO `article_tags` VALUES ('28', '116', '35');
INSERT INTO `article_tags` VALUES ('29', '118', '45');
INSERT INTO `article_tags` VALUES ('32', '119', '40');
INSERT INTO `article_tags` VALUES ('33', '119', '41');
INSERT INTO `article_tags` VALUES ('36', '109', '35');
INSERT INTO `article_tags` VALUES ('37', '109', '50');
INSERT INTO `article_tags` VALUES ('38', '109', '51');
INSERT INTO `article_tags` VALUES ('39', '110', '36');
INSERT INTO `article_tags` VALUES ('48', '108', '33');
INSERT INTO `article_tags` VALUES ('49', '108', '34');
INSERT INTO `article_tags` VALUES ('50', '120', '66');
INSERT INTO `article_tags` VALUES ('51', '120', '65');

-- ----------------------------
-- Records of pv
-- ----------------------------
INSERT INTO `pv` VALUES ('1', '2017-12-24', '20', '6');
INSERT INTO `pv` VALUES ('2', '2017-12-24', '14', '7');
INSERT INTO `pv` VALUES ('4', '2017-12-25', '40', '6');
INSERT INTO `pv` VALUES ('5', '2017-12-25', '23', '7');
INSERT INTO `pv` VALUES ('6', '2017-12-26', '11', '6');
INSERT INTO `pv` VALUES ('7', '2017-12-26', '32', '7');
INSERT INTO `pv` VALUES ('26', '2017-12-23', '2', '6');
INSERT INTO `pv` VALUES ('27', '2017-12-23', '77', '7');