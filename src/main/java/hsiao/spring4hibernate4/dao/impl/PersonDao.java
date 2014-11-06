package hsiao.spring4hibernate4.dao.impl;

import hsiao.spring4hibernate4.dao.IPersonDao;
import hsiao.spring4hibernate4.entity.Person;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

@Transactional
public class PersonDao implements IPersonDao{
		@Autowired
		private HibernateTemplate hibernateTemplate;
		
		@Override
		public void savePerson(Person person){
			hibernateTemplate.save(person);
		}
		@Override
		public Person findByID(Integer id) {
			List persons =hibernateTemplate.find("from Person p where p.id=?", new Object[]{id});
			if(persons.isEmpty()){
				return null;
			}else{
				return (Person)persons.get(0);
			}
		}
	}
