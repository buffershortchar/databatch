package com.cqcfsw.databatch.mapper;

import com.cqcfsw.databatch.entity.TestData;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**

@author baofengxueque
@create 2020-05-19-17:33
*/
@Mapper
public interface TestDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestData record);

    int insertOrUpdate(TestData record);

    int insertOrUpdateSelective(TestData record);

    int insertSelective(TestData record);

    TestData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestData record);

    int updateByPrimaryKey(TestData record);

    int updateBatch(List<TestData> list);

    int batchInsert(@Param("list") List<TestData> list);

    List<TestData> selectAll();
}