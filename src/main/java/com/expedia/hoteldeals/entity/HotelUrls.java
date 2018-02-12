package com.expedia.hoteldeals.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import lombok.Data;

/**
 * Hotel urls entity
 * @author Amer
 *
 */
@Data
public class HotelUrls {

	private String hotelInfositeUrl;
	
	private String hotelSearchResultUrl;
	
	public String getDecodedHotelInfositeUrl() {
		try {
			return URLDecoder.decode(hotelInfositeUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return hotelInfositeUrl;
		}
	}
	
	public String getDecodedHotelSearchResultUrl() {
		try {
			return URLDecoder.decode(hotelSearchResultUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return hotelInfositeUrl;
		}
	}
}
