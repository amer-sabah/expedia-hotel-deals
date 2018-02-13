package com.expedia.hoteldeals.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Testing the LocalDateConverter class
 * 
 * @author Amer
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalDateConverterTest {
	
	/**
	 * Test invalid date format
	 */
	@Test(expected = DateTimeParseException.class)
	public void testConvertInvalidFormattedDateAsStringToLocalDate() {

		LocalDateConverter localDateConverter = new LocalDateConverter("yyyy-MM-dd");

		localDateConverter.convert("22-03-2015");

	}

	/**
	 * Test valid date format
	 */
	@Test
	public void testConvertFormattedDateAsStringToLocalDate() {

		LocalDateConverter localDateConverter = new LocalDateConverter("yyyy-MM-dd");

		LocalDate date = localDateConverter.convert("2015-03-22");

		assertEquals(2015, date.getYear());
		assertEquals(Month.MARCH, date.getMonth());
		assertEquals(22, date.getDayOfMonth());
	}
	
	/**
	 * Test empty string
	 */
	@Test
	public void testConvertEmptyStringToLocalDate() {

		LocalDateConverter localDateConverter = new LocalDateConverter("yyyy-MM-dd");

		LocalDate date = localDateConverter.convert("");

		assertNull(date);
	}
	
	/**
	 * Test null
	 */
	@Test
	public void testConvertNullToLocalDate() {

		LocalDateConverter localDateConverter = new LocalDateConverter("yyyy-MM-dd");

		LocalDate date = localDateConverter.convert(null);
		
		assertNull(date);

	}

}
