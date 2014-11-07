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
   	  
   	  
//   	  	Person person = pdao.findByID(1);
//   		System.out.println(person.getId());
//   	  	System.out.println(person.getName());
   	  	
   	  /**
   	   * test spring cache
   	   */
	   	  for (int i = 0; i < 2	; i++) {
	   		for(Person person: pdao.findByAll()){
		  			System.out.println(person.getName());
		  		}
	   		System.out.println("---------------------------");
	   	  }
	   	  
	   	  Person person = new Person();
	   	  person.setName("hell X13");
	   	  pdao.savePerson(person);
	   	  
	   	for (int i = 0; i < 2	; i++) {
	   		for(Person person2: pdao.findByAll()){
		  			System.out.println(person2.getName());
		  		}
	   		System.out.println("---------------------------");
	   	  }
	   	 
	   	 
	   	 
	    }
}
