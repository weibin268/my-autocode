DROP TABLE IF EXISTS sys_autocode;
CREATE TABLE sys_autocode (
  id varchar(50) NOT NULL,
  expression varchar(500) NOT NULL,
  description varchar(500) DEFAULT NULL,
  PRIMARY KEY (id)
);


DROP TABLE IF EXISTS sys_autocode_detail;
CREATE TABLE sys_autocode_detail (
  id varchar(50) NOT NULL,
  autocode_id varchar(50) NOT NULL,
  prefix_code varchar(100) DEFAULT NULL,
  seq int(11) NOT NULL,
  created_time datetime DEFAULT NULL,
  modified_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
);
