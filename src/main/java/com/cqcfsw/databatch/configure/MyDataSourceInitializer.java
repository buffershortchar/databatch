package com.cqcfsw.databatch.configure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
/**
 * 为其它数据源初始化建表
 * @author baofengxueque
 * @create 2020-05-20-14:29
 */
@Configuration
public class MyDataSourceInitializer {
    /**
     * 构建Resource对象
     */
    @Value("classpath:schema/ds1/schema-test.sql")
    private Resource ds1resource;
    @Value("classpath:schema/ds2/schema-test.sql")
    private Resource ds2resource;

    /**
     * 自定义Bean实现业务的特殊需求,写入到ds1数据源
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer1(@Qualifier("ds1") DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator1());
        return initializer;
    }

    private DatabasePopulator databasePopulator1() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(ds1resource);
        return populator;
    }

    /**
     * 自定义Bean实现业务的特殊需求,写入到ds2数据源
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer2(@Qualifier("ds2") DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator2());
        return initializer;
    }

    private DatabasePopulator databasePopulator2() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(ds2resource);
        return populator;
    }
}