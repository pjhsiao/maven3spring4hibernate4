package hsiao.spring4hibernate4.config;

import hsiao.spring4hibernate4.aop.Audience;
import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.dao.impl.PersonDao;
import hsiao.spring4hibernate4.entity.Person;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
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
		   .setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect")
		   .buildSessionFactory();
	}
	
	//c3p0 datasource
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource(); 
		try {
		    dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    dataSource.setJdbcUrl("jdbc:sqlserver://127.0.0.1:1433;databasename=test");
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
	 * Aspect Bean
	 * @return
	 */
	@Bean 
	public Audience audience(){
		return new Audience();
	}
} 