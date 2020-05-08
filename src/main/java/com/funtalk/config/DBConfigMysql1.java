package com.funtalk.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
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
@MapperScan(basePackages = "com.funtalk.mapper", sqlSessionFactoryRef = "mysql1SqlSessionFactory")
public class DBConfigMysql1 {

    private Logger logger = Logger.getLogger(DBConfigMysql1.class);

    @Value("${spring.datasource.mysql1.url}")
    private String dbUrl;

    @Value("${spring.datasource.mysql1.username}")
    private String username;

    @Value("${spring.datasource.mysql1.password}")
    private String password;

    @Value("${spring.datasource.mysql1.driverClassName}")
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

    @Autowired WallFilter wallFilter;

    // @methodDesc: 功能描述:(配置mysql1数据库)
    @Bean(name = "mysql1DataSource")
    //@ConfigurationProperties(prefix = "spring.datasource.mysql1")
    @Primary
    public DataSource mysql1DataSource() {

        // springboot1.5.x默认使用数据库连接池:org.apache.tomcat.jdbc.pool.DataSource
        // DataSource db =DataSourceBuilder.create().build();
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
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
        } catch (Exception e) {
            logger.error("druid configuration initialization filter", e);
        }

        List filterList=new ArrayList<>();
        filterList.add(wallFilter());
        datasource.setProxyFilters(filterList);

        datasource.setConnectionProperties(connectionProperties);

        logger.info("--------mysqldbsource------------"+datasource.toString());

        return datasource;

    }

    @Bean
    public WallFilter wallFilter(){

        WallFilter wallFilter=new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;

    }

    @Bean
    public WallConfig wallConfig(){

        WallConfig config =new WallConfig();

        //允许一次执行多条语句,不配置的话,执行多条不同表删除会报错   同时，数据源连接字符串也要加上allowMultiQueries=true
        //url: jdbc:mysql://127.0.0.1:3306/machinedatabase?useSSL=false&zeroDateTimeBehavior=convertToNull&autoReconnect=true&allowMultiQueries=true&characterEncoding=UTF-8&characterSetResults=UTF-8

        config.setMultiStatementAllow(true);
        config.setNoneBaseStatementAllow(true);//允许非基本语句的其他语句

        return config;

    }



    /* @methodDesc: 功能描述:(mysql1 sql会话工厂)  */
    @Bean(name = "mysql1SqlSessionFactory")
    @Primary
    public SqlSessionFactory mysql1SqlSessionFactory(@Qualifier("mysql1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/mysql1/*.xml"));
        return bean.getObject();
    }

    /* @methodDesc: 功能描述:(mysql1 事物管理)*/
    @Bean(name = "mysql1TransactionManager")
    @Primary
    public DataSourceTransactionManager mysql1TransactionManager(@Qualifier("mysql1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysql1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mysql1SqlSessionTemplate(
            @Qualifier("mysql1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
