package com.cqcfsw.databatch.configure.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author baofengxueque
 * @create 2020-05-20-14:40
 */
@Configuration
public class BaseDataSource {

    @Bean(name = "base")
    @Primary //主数据源
    @ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactory batchSqlSessionFactory(@Qualifier("base") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate batchSqlsessiontemplate(
            @Qualifier("baseSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    @Bean(name = "baseTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("base") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
