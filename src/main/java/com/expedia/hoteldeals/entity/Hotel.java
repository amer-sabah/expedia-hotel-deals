package com.expedia.hoteldeals.entity;

import lombok.Data;

@Data
public class Hotel {

	private OfferDateRange offerDateRange;

	private Destination destination;

	private HotelInfo hotelInfo;

	private HotelPricingInfo hotelPricingInfo;

	private HotelUrls hotelUrls;

}
