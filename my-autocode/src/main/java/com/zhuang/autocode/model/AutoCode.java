package com.zhuang.autocode.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhuang.data.orm.annotation.Id;
import com.zhuang.data.orm.annotation.Table;
import com.zhuang.data.orm.annotation.UnderscoreNaming;

import java.util.Date;

@UnderscoreNaming
@Table(name = "sys_autocode")
@TableName("sys_autocode")
public class AutoCode {
    @Id
	@TableId
    public String id;
    public String expression;
    public String codePrefix;
    public Integer codeSeq;
    public Date createTime;
    public Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public Integer getCodeSeq() {
        return codeSeq;
    }

    public void setCodeSeq(Integer codeSeq) {
        this.codeSeq = codeSeq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
