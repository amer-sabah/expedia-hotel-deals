package com.expedia.hoteldeals.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.expedia.hoteldeals.entity.HotelOffers;

@Repository
public class HotelDealsRepository {
	
	@Autowired
	private RestTemplate restTemplate;

	public HotelOffers getHotelOffers() {
		
		HotelOffers hotelOffers = restTemplate.getForObject(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel", HotelOffers.class);
		
		return hotelOffers;
	}
}
