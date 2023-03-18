package com.tanya.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanya.flightreservation.dto.ReservationRequest;
import com.tanya.flightreservation.entities.Flight;
import com.tanya.flightreservation.entities.Reservation;
import com.tanya.flightreservation.repos.FlightRepository;
import com.tanya.flightreservation.services.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).orElse(null);
		modelMap.addAttribute("flight", flight);
		return "CompleteReservation";
	}
		
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelmap) {
		Reservation reservation=reservationService.bookFlight(request);
		modelmap.addAttribute("msg", "Reservation created successfullt and the id is "+reservation.getId());
		return "reservationConfirmation";
	}
}

