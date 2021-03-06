package com.expedia.hoteldeals.entity;

import lombok.Data;

/**
 * Hotel price info entity
 * @author Amer
 *
 */
@Data
public class HotelPricingInfo {

	private float averagePriceValue;

	private float totalPriceValue;

	private float crossOutPriceValue;

	private float originalPricePerNight;

	private String currency;

	private float percentSavings;

	private boolean drr;
}
