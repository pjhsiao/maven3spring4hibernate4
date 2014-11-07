package hsiao.spring4hibernate4.dao.impl;

import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.entity.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class PersonDao implements IPersonDao{
		@Autowired
		private HibernateTemplate hibernateTemplate;
		
		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		@CachePut("persons")
		public void savePerson(Person person){
			hibernateTemplate.save(person);
		}
		@Override
		@Transactional(readOnly=true)
		@Cacheable("persons")
		public Person findByID(Integer id) {
			List persons =hibernateTemplate.find("from Person p where p.id=?", new Object[]{id});
			if(persons.isEmpty()){
				return null;
			}else{
				return (Person)persons.get(0);
			}
		}
		@Override
		@Transactional(readOnly=true)
//		@Cacheable("persons")
		public List<Person> findByAll() {
			return (List<Person>) hibernateTemplate.find("from Person p ", null);
		}
	}
