package com.tanya.flightreservation.services;

import com.tanya.flightreservation.dto.ReservationRequest;
import com.tanya.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
