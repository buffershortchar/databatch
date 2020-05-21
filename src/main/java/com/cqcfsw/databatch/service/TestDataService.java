package com.cqcfsw.databatch.service;

import java.util.List;
import com.cqcfsw.databatch.entity.TestData;
    /**

@author baofengxueque
@create 2020-05-19-17:33
*/
public interface TestDataService{


    int deleteByPrimaryKey(Integer id);

    int insert(TestData record);

    int insertOrUpdate(TestData record);

    int insertOrUpdateSelective(TestData record);

    int insertSelective(TestData record);

    TestData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestData record);

    int updateByPrimaryKey(TestData record);

    int updateBatch(List<TestData> list);

    int batchInsert(List<TestData> list);

}
