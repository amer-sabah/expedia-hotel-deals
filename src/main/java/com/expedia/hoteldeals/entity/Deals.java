package com.expedia.hoteldeals.entity;

import lombok.Data;

@Data
public class Deals {

	private OfferInfo offerInfo;

	private UserInfo userInfo;
	
	private Offers offers;
}
