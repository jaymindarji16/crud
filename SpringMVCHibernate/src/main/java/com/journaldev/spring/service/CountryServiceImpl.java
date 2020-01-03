package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.CountryDAO;
import com.journaldev.spring.model.Country;

@Service
public class CountryServiceImpl implements CountryService {
	
	private CountryDAO countryDAO;

	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	@Override
	@Transactional
	public List<Country> listCountry() {
		return this.countryDAO.listCountry();
	}

	@Override
	@Transactional
	public Country getCountryById(int id) {
		return this.countryDAO.getCountryById(id);
	}

}
