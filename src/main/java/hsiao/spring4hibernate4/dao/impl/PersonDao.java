package hsiao.spring4hibernate4.dao.impl;

import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.entity.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class PersonDao implements IPersonDao{
		@Autowired
		private HibernateTemplate hibernateTemplate;
		
		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		@CacheEvict(value="persons", allEntries=true) // allEntries=true ,  clear cache all entries 
		public void savePerson(Person person){
			hibernateTemplate.save(person);
		}
		@Override
		@Cacheable(value="persons")
		@Transactional(readOnly=true)
		public Person findByID(Integer id) {
			List persons =hibernateTemplate.find("from Person p where p.id=?", new Object[]{id});
			if(persons.isEmpty()){
				return null;
			}else{
				return (Person)persons.get(0);
			}
		}
		@Override
		@Cacheable(value="persons")
		@Transactional(readOnly=true)
		public List<Person> findByAll() {
			return (List<Person>) hibernateTemplate.find("from Person p ", null);
		}
	}
