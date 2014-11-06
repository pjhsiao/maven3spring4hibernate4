package hsiao.spring4hibernate4.main;

import hsiao.spring4hibernate4.config.AppConfig;
import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.entity.Person;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * main program
 *
 */
public class App{
    public static void main( String[] args ){
     AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      ctx.register(AppConfig.class);
   	  ctx.refresh();
   	  IPersonDao pdao = ctx.getBean(IPersonDao.class);
   	  
//   	  Person person = new Person();
//   	  person.setName("jen");
//   	  pdao.savePerson(person);
   	  
   	  
   	  	Person person = pdao.findByID(1);
   		System.out.println(person.getId());
   	  	System.out.println(person.getName());
   	  
   	  
    }
}
