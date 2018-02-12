package com.expedia.hoteldeals.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Offers entity
 * @author Amer
 *
 */
@Data
public class Offers {

	@JsonProperty(value = "Hotel")
	private List<Hotel> hotel;
}
