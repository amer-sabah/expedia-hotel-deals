package com.expedia.hoteldeals.entity;

import lombok.Data;

@Data
public class OfferInfo {

	private long siteID;

	private String language;

	private String currency;

	private String userSelectedCurrency;

}
