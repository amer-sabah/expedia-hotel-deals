package com.expedia.hoteldeals.repository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.expedia.hoteldeals.entity.Deals;

/**
 * Hotel deals data repository for managing hotel deals data
 * @author Amer
 *
 */
@Repository
public class HotelDealsRepository {

	public static class URI {
		public static final String OFFERS = "https://offersvc.expedia.com/offers/v2/getOffers";
	}

	public static class Param {

		public static final String SCENARIO = "scenario";
		public static final String PAGE = "page";
		public static final String UID = "uid";
		public static final String PRODUCT_TYPE = "productType";

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

	/**
	 * Gets the hotel offers based on the selected filtration using Expedia API
	 * @param destinationName hotel location
	 * @param startDate
	 *            Trip start date
	 * @param endDate
	 *            Trip end date
	 * @param days
	 *            Length of stay
	 * @param rating
	 *            Hotel rating
	 * @return
	 */
	public Deals getHotelOffers(String destinationName, LocalDate startDate, LocalDate endDate, Integer days, Integer rating) {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(URI.OFFERS);

		MultiValueMap<String, String> parameters = getHotelOffersRequestParameters(destinationName, startDate, endDate, days, rating);

		uriBuilder.queryParams(parameters);

		Deals hotelOffers = restTemplate.getForObject(uriBuilder.toUriString(), Deals.class);

		return hotelOffers;
	}

	/**
	 * Gets the hotel offers request parameters based on the selected filtration
	 * @param destinationName hotel location
	 * @param startDate
	 *            Trip start date
	 * @param endDate
	 *            Trip end date
	 * @param days
	 *            Length of stay
	 * @param rating
	 *            Hotel rating
	 * @return
	 */
	private MultiValueMap<String, String> getHotelOffersRequestParameters(String destinationName, LocalDate startDate, LocalDate endDate, Integer days, Integer rating) {

		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

		parameters.add(Param.SCENARIO, "deal-finder");
		parameters.add(Param.PAGE, "foo");
		parameters.add(Param.UID, "foo");
		parameters.add(Param.PRODUCT_TYPE, "Hotel");

		if (!StringUtils.isEmpty(destinationName)) {
			parameters.add(Param.DESTINATION_NAME, destinationName);
		}

		if (startDate != null) {
			parameters.add(Param.MIN_TRIP_START_DATE, startDate.toString());
		}

		if (endDate != null && days != null) {
			parameters.add(Param.MAX_TRIP_START_DATE, endDate.minusDays(days).toString());
		}

		if (days != null) {
			parameters.add(Param.LENGTH_OF_STAY, days.toString());
		}

		if (rating != null) {
			parameters.add(Param.MIN_STAR_RATING, rating.toString());
			parameters.add(Param.MAX_STAR_RATING, rating.toString());
		}

		return parameters;
	}
}
