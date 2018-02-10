package com.expedia.hoteldeals.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.hoteldeals.R;
import com.expedia.hoteldeals.entity.Deals;
import com.expedia.hoteldeals.service.HotelDealsService;

@Controller
public class HotelDealsController {

	@Autowired
	private HotelDealsService hotelDealsService;

	@RequestMapping(value = "/hotel-deals", method = {RequestMethod.POST, RequestMethod.GET})
	public String greeting(String destinationName, LocalDate startDate, LocalDate endDate, int days, int rating, Model model) {

		Deals hotelOffers = hotelDealsService.getHotelOffers();
		model.addAttribute(R.Attr.OFFER_INFO, hotelOffers.getOfferInfo());
		
		return R.View.HOTEL_DEALS;
	}
}
