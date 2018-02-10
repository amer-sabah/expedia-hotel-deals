package com.expedia.hoteldeals.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OfferDateRange {

	private LocalDate travelStartDate;

	private LocalDate travelEndDate;

	private int lengthOfStay;
}
