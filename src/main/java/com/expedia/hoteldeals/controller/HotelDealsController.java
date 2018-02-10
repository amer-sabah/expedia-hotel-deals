package com.expedia.hoteldeals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expedia.hoteldeals.R;
import com.expedia.hoteldeals.entity.HotelOffers;
import com.expedia.hoteldeals.service.HotelDealsService;

@Controller
public class HotelDealsController {

	@Autowired
	private HotelDealsService hotelDealsService;

	@RequestMapping("/hotel-deals")
	public String greeting(Model model) {

		HotelOffers hotelOffers = hotelDealsService.getHotelOffers();
		model.addAttribute(R.Attr.OFFER_INFO, hotelOffers.getOfferInfo());
		
		return R.View.HOTEL_DEALS;
	}
}
