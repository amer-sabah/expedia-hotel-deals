package com.expedia.hoteldeals.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.expedia.hoteldeals.R;
import com.expedia.hoteldeals.entity.Deals;
import com.expedia.hoteldeals.service.HotelDealsService;

@Controller
public class HotelDealsController {

	@Autowired
	private HotelDealsService hotelDealsService;

	@RequestMapping(value = "/hotel-deals", method = { RequestMethod.POST, RequestMethod.GET })
	public String greeting(String destinationName, @RequestParam(value = "startDate", required = false) LocalDate startDate, @RequestParam(value = "endDate", required = false) LocalDate endDate,
			Integer days, Integer rating, Model model) {

		Deals hotelOffers = hotelDealsService.getHotelOffers(destinationName, startDate, endDate, days, rating);
		model.addAttribute(R.Attr.HOTEL_OFFERS, hotelOffers.getOffers().getHotel());

		return R.View.HOTEL_DEALS;
	}
}
