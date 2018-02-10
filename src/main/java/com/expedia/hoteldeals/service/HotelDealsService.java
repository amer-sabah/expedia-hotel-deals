package com.expedia.hoteldeals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.hoteldeals.entity.HotelOffers;
import com.expedia.hoteldeals.repository.HotelDealsRepository;

@Service
public class HotelDealsService {
	
	@Autowired
	private HotelDealsRepository hotelDealsRepository;
	
	public HotelOffers getHotelOffers() {
		return hotelDealsRepository.getHotelOffers();
	}

}
