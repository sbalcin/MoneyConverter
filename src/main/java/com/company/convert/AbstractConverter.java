package com.company.convert;

import org.apache.log4j.Logger;

public abstract class AbstractConverter implements ConverterImpl {

	private static Logger logger = Logger.getLogger(AbstractConverter.class);

	public static final int billionVal = 1000000000;

	public static final String billionText = "billion";

	public static final int millionVal = 1000000;

	public static final String millionText = "million";

	public static final int thousandVal = 1000;

	public static final String thousandText = "thousand";

	public static final int hundredVal = 100;

	public static final String hundredText = "hundred";

	public static final int tenVal = 10;

	public static final String tenText = "ten";

	public static final String specialNumbers[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public static final String multipleOfTens[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	abstract String getName();

	@Override
	public String run(Long number) {
		logger.info(getName() + " is running with: " + number);
		return null;
	}

	@Override
	public Long run(String word) {
		logger.info(getName() + " is running with: " + word);
		return null;
	}

}
