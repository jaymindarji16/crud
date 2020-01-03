package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Country;

public interface CountryService {

	public List<Country> listCountry();
	public Country getCountryById(int id);
	
}
