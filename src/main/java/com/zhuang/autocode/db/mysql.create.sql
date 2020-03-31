
DROP TABLE IF EXISTS sys_autocode;
CREATE TABLE sys_autocode (
  id varchar(36) NOT NULL,
  expression varchar(50) DEFAULT NULL,
  code_prefix varchar(50) DEFAULT NULL,
  code_seq int(11) NOT NULL,
  create_time datetime DEFAULT NULL,
  modify_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
);
