package com.cqcfsw.databatch.job;

import com.cqcfsw.databatch.entity.TestData;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author baofengxueque
 * @create 2020-05-18-17:19
 */
@Component
public class DataSourceItemReaderDemo {

    @Resource
    private JobBuilderFactory jobBuilderFactory;
    @Resource
    private StepBuilderFactory stepBuilderFactory;
    @Resource(name = "ds1SqlSessionFactory")
    private SqlSessionFactory ds1SqlSessionFactory;
    @Resource(name = "ds2SqlSessionFactory")
    private SqlSessionFactory ds2SqlSessionFactory;

    @Bean
    public Job dataSourceItemReaderJob() throws Exception {
        return jobBuilderFactory.get("dataSourceItemReaderJob")
                .start(step())
                .build();
    }

    private Step step() throws Exception {

        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(1000)
                .reader(mybatisItemReader())
                .processor(batchProcess())
//                .writer(list -> list.forEach(System.out::println))
                .writer(mybatisItemWriter())
                .build();
    }

    private ItemProcessor<TestData, TestData> batchProcess() {
        ItemProcessor processor = new ItemProcessor() {
            @Override
            public Object process(Object item) throws Exception {
                TestData pointdata = (TestData) item;
                pointdata.setField1("Batch "+pointdata.getField1());
                return pointdata;
            }
        };
        return processor;
    }

    private ItemReader<TestData> mybatisItemReader() throws Exception {
        MyBatisPagingItemReader<TestData> reader = new MyBatisPagingItemReader<>();
        reader.setSqlSessionFactory(ds1SqlSessionFactory);
        reader.setQueryId("com.cqcfsw.databatch.mapper.TestDataMapper.selectList");
        reader.setPageSize(1000);
        return reader;
    }

    private ItemWriter<TestData> mybatisItemWriter() throws Exception {
        MyBatisBatchItemWriter<TestData> writer = new MyBatisBatchItemWriter<>();
        writer.setSqlSessionFactory(ds2SqlSessionFactory);
        writer.setStatementId("com.cqcfsw.databatch.mapper.TestDataMapper.insert");

        return writer;
    }

}