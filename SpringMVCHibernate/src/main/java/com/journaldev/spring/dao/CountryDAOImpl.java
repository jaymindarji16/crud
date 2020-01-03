package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> listCountry() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		for(Country p : countryList){
			logger.info("Country List::"+p);
		}
		return countryList;
	}

	@Override
	public Country getCountryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Country p = (Country) session.load(Country.class, new Integer(id));
		logger.info("Country loaded successfully, Country details="+p);
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
