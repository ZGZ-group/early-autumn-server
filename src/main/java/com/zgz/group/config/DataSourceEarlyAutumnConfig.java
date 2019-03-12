package com.zgz.group.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        basePackages = {DataSourceEarlyAutumnConfig.BASE_PACKAGE},
        sqlSessionFactoryRef = DataSourceEarlyAutumnConfig.SQL_SESSION_FACTORY)
public class DataSourceEarlyAutumnConfig {

    static final String BASE_PACKAGE = "com.zgz.group.dao";
    static final String SQL_SESSION_FACTORY = "sqlSessionFactoryEarlyAutumn";

    private static final Logger logger = LoggerFactory.getLogger(DataSourceEarlyAutumnConfig.class);
    private static final String DATA_SOURCE_PROPERTY = "dataSourcePropertyEarlyAutumn";
    private static final String MYBATIS_CONFIG = "classpath:mybatis/mybatis-config.xml";
    private static final String MYBATIS_MAPPERS = "classpath:com/zgz/group/dao/mapper/*.xml";
    private static final String TX_MANAGER = "txManagerEarlyAutumn";

    @Primary
    @Bean(name = DATA_SOURCE_PROPERTY)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(
            @Value("${database.earlyautumn.driver}") String driver,
            @Value("${database.earlyautumn.username}") String username,
            @Value("${database.earlyautumn.password}") String password,
            @Value("${database.earlyautumn.url}") String url
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATA_SOURCE_PROPERTY) DataSource dataSource) {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(MYBATIS_CONFIG));
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MYBATIS_MAPPERS));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("failed to create data sql session", e);
            throw new RuntimeException();
        }

    }

    @Bean(name = TX_MANAGER)
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DATA_SOURCE_PROPERTY) DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }

//    @Bean
//    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        SqlSessionTemplate templates = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
//        return templates;
//    }

}
