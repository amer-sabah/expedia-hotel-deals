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

	@RequestMapping(value = { "/", "/hotel-deals" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String greeting(String destinationName, @RequestParam(value = R.Attr.START_DATE, required = false) LocalDate startDate, @RequestParam(value = R.Attr.END_DATE, required = false) LocalDate endDate,
			Integer days, Integer rating, Model model) {

		Deals hotelOffers = hotelDealsService.getHotelOffers(destinationName, startDate, endDate, days, rating);
		model.addAttribute(R.Attr.HOTEL_OFFERS, hotelOffers.getOffers().getHotel());

		model.addAttribute(R.Attr.DESTINATION_NAME, destinationName);
		model.addAttribute(R.Attr.START_DATE, startDate);
		model.addAttribute(R.Attr.END_DATE, endDate);
		model.addAttribute(R.Attr.DAYS, days);
		model.addAttribute(R.Attr.RATING, rating);

		return R.View.HOTEL_DEALS;
	}
}
