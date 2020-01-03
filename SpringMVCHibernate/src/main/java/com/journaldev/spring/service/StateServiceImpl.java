package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.StateDAO;
import com.journaldev.spring.model.State;

@Service
public class StateServiceImpl implements StateService {
	
	private StateDAO stateDAO;

	public void setStateDAO(StateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}

	@Override
	@Transactional
	public List<State> listState() {
		return this.stateDAO.listState();
	}

	@Override
	@Transactional
	public State getStateById(int id) {
		return this.stateDAO.getStateById(id);
	}

}
