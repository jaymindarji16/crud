package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.State;

public interface StateDAO {

	public List<State> listState();
	public State getStateById(int id);
	
}
