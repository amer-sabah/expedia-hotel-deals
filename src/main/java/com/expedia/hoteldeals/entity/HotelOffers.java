package com.expedia.hoteldeals.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelOffers {

	private OfferInfo offerInfo;
}
