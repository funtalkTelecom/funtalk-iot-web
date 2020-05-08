package com.funtalk.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.funtalk.oraclemapper", sqlSessionFactoryRef = "oracle1SqlSessionFactory")
public class DBConfigOracle1 {

    Logger logger=Logger.getLogger(DBConfigOracle1.class);


    @Value("${spring.datasource.oracle1.url}")
    private String dbUrl;

    @Value("${spring.datasource.oracle1.username}")
    private String username;

    @Value("${spring.datasource.oracle1.password}")
    private String password;

    @Value("${spring.datasource.oracle1.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${spring.datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;

    // @methodDesc: 功能描述:(配置mysql1数据库)
    @Bean(name = "oracle1DataSource")
    //@ConfigurationProperties(prefix = "spring.datasource.oracle1")
    public DataSource oracle1DataSource() {

        // springboot1.5.x默认使用数据库连接池:org.apache.tomcat.jdbc.pool.DataSource
        // DataSource db =DataSourceBuilder.create().build();
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }


        datasource.setConnectionProperties(connectionProperties);

        logger.info("--------mysqldbsource------------"+datasource.toString());

        return datasource;

    }


    /*  @methodDesc: 功能描述:(oracle1 sql会话工厂) */
    @Bean(name = "oracle1SqlSessionFactory")
    public SqlSessionFactory oracle1SqlSessionFactory(@Qualifier("oracle1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/oracle1/*.xml"));
        return bean.getObject();
    }

    /*  @methodDesc: 功能描述:(oracle1 事物管理) */
    @Bean(name = "oracle1TransactionManager")
    public DataSourceTransactionManager oracle1TransactionManager(@Qualifier("oracle1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "oracle1SqlSessionTemplate")
    public SqlSessionTemplate oracle1SqlSessionTemplate(
            @Qualifier("oracle1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
