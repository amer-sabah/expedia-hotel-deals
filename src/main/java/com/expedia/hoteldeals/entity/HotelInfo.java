package com.expedia.hoteldeals.entity;

import lombok.Data;

@Data
public class HotelInfo {

	private long hotelId;

	private String hotelName;
	
	private String localizedHotelName;
	
	private String hotelDestination;

	private long hotelDestinationRegionID;

	private String hotelLongDestination;
	
	private String hotelStreetAddress;
	
	private String hotelCity;
	
	private String hotelProvince;
	
	private String hotelCountryCode;

	private double hotelLatitude;

	private double hotelLongitude;

	private float hotelStarRating;

	private float hotelGuestReviewRating;

	private float hotelReviewTotal;

	private String hotelImageUrl;

	private boolean vipAccess;

	private boolean isOfficialRating;
}
