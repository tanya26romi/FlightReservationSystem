package com.tanya.flightreservation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanya.flightreservation.entities.Flight;
import com.tanya.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping(value="/findFlights", method=RequestMethod.POST)
	//public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to, ModelMap modelMap) {
		List<Flight> flights = flightRepository.findFlight(from, to);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}
}
