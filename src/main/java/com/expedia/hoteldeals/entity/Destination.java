package com.expedia.hoteldeals.entity;

import lombok.Data;

@Data
public class Destination {

	private long regionID;

	private long associatedMultiCityRegionId;

	private String longName;

	private String shortName;

	private String country;

	private String province;

	private String city;

	private String tla;

	private String nonLocalizedCity;

}
