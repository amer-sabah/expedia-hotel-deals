package com.expedia.hoteldeals.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.expedia.hoteldeals.entity.Deals;

@Repository
public class HotelDealsRepository {

	public static class Param {

		public static final String DESTINATION_NAME = "destinationName";
		public static final String MIN_TRIP_START_DATE = "minTripStartDate";
		public static final String MAX_TRIP_START_DATE = "maxTripStartDate";
		public static final String LENGTH_OF_STAY = "lengthOfStay";
		public static final String MIN_STAR_RATING = "minStarRating";
		public static final String MAX_STAR_RATING = "maxStarRating";
		public static final String MIN_TOTAL_RATE = "minTotalRate";
		public static final String MAX_TOTAL_RATE = "maxTotalRate";
		public static final String MIN_GUEST_RATING = "minGuestRating";
		public static final String MAX_GUEST_RATING = "minGuestRating";
	}

	@Autowired
	private RestTemplate restTemplate;

	public Deals getHotelOffers(String destinationName, LocalDate startDate, LocalDate endDate, Integer days, Integer rating) {

		Map<String, Object> parameters = new HashMap<>();

		parameters.put(Param.DESTINATION_NAME, destinationName);

		Deals hotelOffers = restTemplate.getForObject(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel"
				, Deals.class);

		return hotelOffers;
	}
}
