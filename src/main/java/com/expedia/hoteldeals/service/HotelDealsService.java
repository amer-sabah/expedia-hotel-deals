package com.expedia.hoteldeals.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.hoteldeals.entity.Deals;
import com.expedia.hoteldeals.repository.HotelDealsRepository;

@Service
public class HotelDealsService {
	
	@Autowired
	private HotelDealsRepository hotelDealsRepository;
	
	public Deals getHotelOffers(String destinationName, LocalDate startDate, LocalDate endDate, Integer days, Integer rating) {
		return hotelDealsRepository.getHotelOffers(destinationName, startDate, endDate, days, rating);
	}

}
