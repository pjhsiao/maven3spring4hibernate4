package hsiao.spring4hibernate4.config;

import hsiao.spring4hibernate4.aop.Audience;
import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.dao.impl.PersonDao;
import hsiao.spring4hibernate4.entity.Person;

import java.util.Arrays;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration 
@EnableTransactionManagement
@EnableAspectJAutoProxy 
@EnableCaching
public class AppConfig {  
	
	
	@Bean  
        public IPersonDao personDao() {  
           return new PersonDao();  
        }
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(getDataSource())
		   .addAnnotatedClasses(Person.class)
		   .setProperty("hibernate.show_sql", "false")
		   .setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect")
		   .buildSessionFactory();
	}
	
	//c3p0 datasource
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource(); 
		try {
		    dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    dataSource.setJdbcUrl("jdbc:sqlserver://140.124.191.176:1433;databasename=test");
		    dataSource.setUser("test");
		    dataSource.setPassword("test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
	
	/**
	 * To enable @AspectJ support with Java @Configuration add the @EnableAspectJAutoProxy annotation:
	 * Aspect Bean
	 * @return
	 */
	@Bean 
	public Audience audience(){
		return new Audience();
	}
	
	
	/**
	 * Spring Cache 
	 * A bean of type CacheManager must be registered, as there is no reasonable default that the framework can use as a convention. 
	 * And whereas the <cache:annotation-driven> element assumes a bean named "cacheManager", @EnableCaching searches for a cache manager bean by type. 
	 * Therefore, naming of the cache manager bean method is not significant.
	 * @return
	 */
	 @Bean
     public CacheManager cacheManager() {
         // configure and return an implementation of Spring's CacheManager SPI
         SimpleCacheManager cacheManager = new SimpleCacheManager();
         cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default"), new ConcurrentMapCache("persons")));
         return cacheManager;
     }
} 