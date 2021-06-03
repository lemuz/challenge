package com.equifax.dev.conf;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:Application.properties")
@PropertySource("classpath:properties/challenge-dev.properties")
public class DBConf {

	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	@Value("${hibernate.show.sql}")
	private String hibernateShowSql;
	@Value("${hibernate.generate-ddl}")
	private boolean generatedDdl;
	@Value("${hibernate.datasource.url}")
	private String datasourceUrl;
	@Value("${hibernate.datasource.username}")
	private String username;
	@Value("${hibernate.datasource.password}")
	private String password;
	@Value("${hibernate.datasource.driver-class-name}")
	private String driver;

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) throws Exception {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter.setGenerateDdl(generatedDdl);
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan("com.equifax.dev");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.afterPropertiesSet();
		SessionFactory sf = factoryBean.getObject();
		return sf;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName(driver)
          .url(datasourceUrl)
          .username(username)
          .password(password)
          .build();	
    }
}
