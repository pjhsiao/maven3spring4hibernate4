package hsiao.spring4hibernate4.dao;

import hsiao.spring4hibernate4.entity.Person;

public interface IPersonDao {
	  public void savePerson(Person person);
	  public Person findByID(Integer id);
} 