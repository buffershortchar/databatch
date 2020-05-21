package com.cqcfsw.databatch.mapper;

import com.cqcfsw.databatch.entity.Pointdata;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**

@author baofengxueque
@create 2020-05-19-22:38
*/
@Mapper
public interface PointdataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pointdata record);

    int insertOrUpdate(Pointdata record);

    int insertOrUpdateSelective(Pointdata record);

    int insertSelective(Pointdata record);

    Pointdata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pointdata record);

    int updateByPrimaryKey(Pointdata record);

    int updateBatch(List<Pointdata> list);

    int batchInsert(@Param("list") List<Pointdata> list);
}