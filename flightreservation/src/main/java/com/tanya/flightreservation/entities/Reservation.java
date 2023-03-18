package com.tanya.flightreservation.entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation extends AbstractEntity{
	//@Column(name = "CHECKED_IN")
	private Boolean checkedIn;
	//@Column(name = "NUMBER_OF_BAGS")
	private int numberOfBags;
	@OneToOne   //passenger is foreign key and has one to one relation
	//@Column(name = "PASSENGER_ID")
	private Passenger passenger;
	@OneToOne  //flight is foreign key and has one to one relation
	//@Column(name = "FLIGHT_ID")
	private Flight flight;
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
