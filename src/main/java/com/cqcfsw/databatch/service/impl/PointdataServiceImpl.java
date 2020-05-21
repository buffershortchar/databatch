package com.cqcfsw.databatch.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.cqcfsw.databatch.entity.Pointdata;
import java.util.List;
import com.cqcfsw.databatch.mapper.PointdataMapper;
import com.cqcfsw.databatch.service.PointdataService;
/**

@author baofengxueque
@create 2020-05-19-22:38
*/
@Service
public class PointdataServiceImpl implements PointdataService{

    @Resource
    private PointdataMapper pointdataMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pointdataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Pointdata record) {
        return pointdataMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Pointdata record) {
        return pointdataMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Pointdata record) {
        return pointdataMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Pointdata record) {
        return pointdataMapper.insertSelective(record);
    }

    @Override
    public Pointdata selectByPrimaryKey(Integer id) {
        return pointdataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Pointdata record) {
        return pointdataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pointdata record) {
        return pointdataMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Pointdata> list) {
        return pointdataMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Pointdata> list) {
        return pointdataMapper.batchInsert(list);
    }

}
