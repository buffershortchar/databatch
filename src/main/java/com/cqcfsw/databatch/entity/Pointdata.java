package com.cqcfsw.databatch.entity;

import java.io.Serializable;
import java.util.Date;

/**

@author baofengxueque
@create 2020-05-19-22:38
*/
public class Pointdata implements Serializable {
    private Integer id;

    private Double data;

    private Date date;

    private String description;

    private Double maxdata;

    private Double mindata;

    private Integer pointid;

    private String pointepc;

    private String region;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMaxdata() {
        return maxdata;
    }

    public void setMaxdata(Double maxdata) {
        this.maxdata = maxdata;
    }

    public Double getMindata() {
        return mindata;
    }

    public void setMindata(Double mindata) {
        this.mindata = mindata;
    }

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }

    public String getPointepc() {
        return pointepc;
    }

    public void setPointepc(String pointepc) {
        this.pointepc = pointepc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", date=").append(date);
        sb.append(", description=").append(description);
        sb.append(", maxdata=").append(maxdata);
        sb.append(", mindata=").append(mindata);
        sb.append(", pointid=").append(pointid);
        sb.append(", pointepc=").append(pointepc);
        sb.append(", region=").append(region);
        sb.append("]");
        return sb.toString();
    }
}