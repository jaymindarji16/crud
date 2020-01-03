package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.City;

@Repository
public class CityDAOImpl implements CityDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCity() {
		Session session = this.sessionFactory.getCurrentSession();
		List<City> cityList = session.createQuery("from City").list();
		for(City p : cityList){
			logger.info("City List::"+p);
		}
		return cityList;
	}

	@Override
	public City getCityById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		City p = (City) session.load(City.class, new Integer(id));
		logger.info("City loaded successfully, City details="+p);
		return p;
	}

/*	@Override
	public void removeCity(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		City p = (City) session.load(City.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("City deleted successfully, person details="+p);
	}*/

}
