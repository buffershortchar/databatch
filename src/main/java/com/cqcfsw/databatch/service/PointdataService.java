package com.cqcfsw.databatch.service;

import com.cqcfsw.databatch.entity.Pointdata;
import java.util.List;
    /**

@author baofengxueque
@create 2020-05-19-22:38
*/
public interface PointdataService{


    int deleteByPrimaryKey(Integer id);

    int insert(Pointdata record);

    int insertOrUpdate(Pointdata record);

    int insertOrUpdateSelective(Pointdata record);

    int insertSelective(Pointdata record);

    Pointdata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pointdata record);

    int updateByPrimaryKey(Pointdata record);

    int updateBatch(List<Pointdata> list);

    int batchInsert(List<Pointdata> list);

}
