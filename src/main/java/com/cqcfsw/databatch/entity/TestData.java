package com.cqcfsw.databatch.entity;

import java.io.Serializable;

/**

@author baofengxueque
@create 2020-05-19-17:33
*/
public class TestData implements Serializable {
    /**
    * ID
    */
    private Integer id;

    /**
    * 字段一
    */
    private String field1;

    /**
    * 字段二
    */
    private String field2;

    /**
    * 字段三
    */
    private String field3;

    private static final long serialVersionUID = 154866489421L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", field1=").append(field1);
        sb.append(", field2=").append(field2);
        sb.append(", field3=").append(field3);
        sb.append("]");
        return sb.toString();
    }
}