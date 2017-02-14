package qeqs;

import java.sql.Driver;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@MapperScan("qeqs.mappers")
public class DataConfig {

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(ResourceBundle.getBundle("/postgres").getString("db.driver")));        
        dataSource.setUsername(ResourceBundle.getBundle("/postgres").getString("db.user"));
        dataSource.setUrl( ResourceBundle.getBundle("/postgres").getString("db.url"));
        dataSource.setPassword(ResourceBundle.getBundle("/postgres").getString("db.password"));

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws ClassNotFoundException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("qeqs.entities");
        return sessionFactory;
    }
}