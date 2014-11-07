package hsiao.spring4hibernate4.dao;

import hsiao.spring4hibernate4.entity.Person;

import java.util.List;

public interface IPersonDao {
	  public void savePerson(Person person);
	  public Person findByID(Integer id);
	  public List<Person> findByAll();
} 