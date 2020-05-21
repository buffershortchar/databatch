package com.cqcfsw.databatch;

import com.cqcfsw.databatch.entity.TestData;
import com.cqcfsw.databatch.mapper.TestDataMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class DatabatchApplicationTests {
    /*
     @RunWith(SpringRunner.class)
     @SpringBootTest
     @Transactional
     @Rollback(false)

    单独的@Transactional是回滚事务，
    在添加@Transactional的情况下如果要提交事务，
    只需要增加@Rollback(false)：
    @Rollback可以用在方法上

     */

    @Autowired
    private TestDataMapper testDataMapper;

    @Resource(name = "ds1SqlSessionFactory")
    private SqlSessionFactory ds1SqlSessionFactory;

    @Test
    public void testInsert1() {
        TestData testData = new TestData();
        testData.setId(1);
        testData.setField1("2");
        testData.setField2("1");
        testData.setField3("2");
        testDataMapper.insert(testData);
    }

    @Test
    public void testInsert2() {
        TestData testData = new TestData();
        testData.setId(2);
        testData.setField1("2");
        testData.setField2("1");
        testData.setField3("2");
        testDataMapper.insert(testData);
    }

    @Test
    public void testSelectAll() {
        List<TestData> testDataList = testDataMapper.selectAll();
        testDataList.forEach(testData -> {
            System.out.println(testData);
        });
    }
}
