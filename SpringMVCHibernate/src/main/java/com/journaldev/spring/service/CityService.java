package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.City;

public interface CityService {

	public List<City> listCity();
	public City getCityById(int id);
	
}
