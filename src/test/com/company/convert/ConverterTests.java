package com.company.convert;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class ConverterTests {

	ConverterImpl numberRunner, wordRunner;

	@Before
	public void before(){
		numberRunner= new NumberToWordConverter();
		wordRunner = new WordToNumberConverter();
	}

	@Test
	public void check_number_to_word_converter_behaviour() throws Exception {


		final Long sample = Long.valueOf("-10286141277");
		final String result = numberRunner.run(sample);

		Assert.assertTrue(result.length() > 0);
	}

	@Test
	public void check_word_to_number_converter_behaviour() throws Exception {


		final String sample = "five billion six hundred seventy-four million five hundred thirty-four thousand five hundred";
		final Long result = wordRunner.run(sample);

		Assert.assertTrue(result > 0);
	}

	@Test
	public void compare_converters_result() throws Exception {

		final long random = new Random().nextLong()/100000000;

		final String result = numberRunner.run(random);
		final Long converted = wordRunner.run(result);


		Assert.assertEquals(converted.longValue(), random);

	}
}