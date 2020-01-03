package com.journaldev.spring;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.City;
import com.journaldev.spring.model.Country;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.State;
import com.journaldev.spring.service.CityService;
import com.journaldev.spring.service.CountryService;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.StateService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private CityService cityService;
	private StateService stateService;
	private CountryService countryService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="cityService")
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="stateService")
	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	@Autowired(required=true)
	@Qualifier(value="countryService")
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("city", new City());
		model.addAttribute("state", new State());
		model.addAttribute("country", new Country());
		model.addAttribute("uniqueId", ""+generateRandomInt(10000));
		
		model.addAttribute("listCity", this.cityService.listCity());
		model.addAttribute("listCountry", this.countryService.listCountry());
		model.addAttribute("listState", this.stateService.listState());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
