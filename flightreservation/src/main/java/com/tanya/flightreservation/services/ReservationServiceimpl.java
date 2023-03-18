package com.tanya.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanya.flightreservation.dto.ReservationRequest;
import com.tanya.flightreservation.entities.Flight;
import com.tanya.flightreservation.entities.Passenger;
import com.tanya.flightreservation.entities.Reservation;
import com.tanya.flightreservation.repos.FlightRepository;
import com.tanya.flightreservation.repos.PassengerRepository;
import com.tanya.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceimpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		//Make Payment
		
		Long flightId = request.getflightId();
		Flight flight = flightRepository.findById(flightId).orElse(null);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		return savedReservation;
	}

}
