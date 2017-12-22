--
-- table: wb_article
--
CREATE TABLE `wb_article` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_author` varchar(20) NOT NULL,
  `c_content` varchar(20) NOT NULL,
  `c_date` timestamp NOT NULL,
  `c_browsertime` int(11) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- table: wb_account
--
CREATE TABLE `wb_account` (
  `a_id` int(11) NOT NULL,
  `a_name` varchar(20) NOT NULL,
  `a_age` int(11) NOT NULL,
  `a_desc` varchar(50) NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- table: wb_subscribe
--
CREATE TABLE `wb_subscribe` (
  `s_id` int(11) NOT NULL,
  `s_master_id` int(11)  NOT NULL,
  `s_follower_id` int(11) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `wb_log` (
  `l_id` int(11) NOT NULL auto_increment,
  `l_article_id` int(11) NOT NULL,
  `l_ope` varchar(25) NOT NULL,
  `l_time` timestamp NOT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


--add data to weiboreadnumber
insert into weiboreadnumber values(1,'laiyongkui',6);