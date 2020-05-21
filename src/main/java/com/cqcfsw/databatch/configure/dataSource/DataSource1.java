package com.cqcfsw.databatch.configure.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author baofengxueque
 * @create 2020-05-20-10:25
 */
@Configuration
public class DataSource1 {
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "ds1SqlSessionFactory")
    public SqlSessionFactory batchSqlSessionFactory(@Qualifier("ds1") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "ds1SqlSessionTemplate")
    public SqlSessionTemplate batchSqlsessiontemplate(
            @Qualifier("ds1SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    /**
     * 返回 ds1 数据库的事务
     */
    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("ds1") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}