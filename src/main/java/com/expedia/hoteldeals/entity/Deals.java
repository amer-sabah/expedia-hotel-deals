package com.expedia.hoteldeals.entity;

import lombok.Data;

/**
 * Deals entity
 * @author Amer
 *
 */
@Data
public class Deals {

	private OfferInfo offerInfo;

	private UserInfo userInfo;
	
	private Offers offers;
}
