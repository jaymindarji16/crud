package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.State;

public interface StateService {

	public List<State> listState();
	public State getStateById(int id);
	
}
