package com.expedia.hoteldeals.entity;

import lombok.Data;

/**
 * Offer info entity
 * @author Amer
 *
 */
@Data
public class OfferInfo {

	private long siteID;

	private String language;

	private String currency;

	private String userSelectedCurrency;

}
