package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.State;

@Repository
public class StateDAOImpl implements StateDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StateDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> listState() {
		Session session = this.sessionFactory.getCurrentSession();
		List<State> StateList = session.createQuery("from State").list();
		for(State p : StateList){
			logger.info("State List::"+p);
		}
		return StateList;
	}

	@Override
	public State getStateById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		State p = (State) session.load(State.class, new Integer(id));
		logger.info("State loaded successfully, State details="+p);
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
