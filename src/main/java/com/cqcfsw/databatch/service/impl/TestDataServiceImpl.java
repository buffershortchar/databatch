package com.cqcfsw.databatch.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.cqcfsw.databatch.mapper.TestDataMapper;
import java.util.List;
import com.cqcfsw.databatch.entity.TestData;
import com.cqcfsw.databatch.service.TestDataService;
/**

@author baofengxueque
@create 2020-05-19-17:33
*/
@Service
public class TestDataServiceImpl implements TestDataService{

    @Resource
    private TestDataMapper testDataMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return testDataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TestData record) {
        return testDataMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(TestData record) {
        return testDataMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(TestData record) {
        return testDataMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(TestData record) {
        return testDataMapper.insertSelective(record);
    }

    @Override
    public TestData selectByPrimaryKey(Integer id) {
        return testDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TestData record) {
        return testDataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TestData record) {
        return testDataMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<TestData> list) {
        return testDataMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TestData> list) {
        return testDataMapper.batchInsert(list);
    }

}
