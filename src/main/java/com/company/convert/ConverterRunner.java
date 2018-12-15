package com.company.convert;

import org.apache.log4j.Logger;

public class ConverterRunner {

	private static Logger logger = Logger.getLogger(ConverterRunner.class);

	public static void main(String[] args) throws InterruptedException {

		ConverterImpl numberRunner = new NumberToWordConverter();

		Long sample = Long.valueOf("-10286141277");
		final String resultStr = numberRunner.run(sample);
		logger.info(resultStr);

		ConverterImpl wordRunner = new WordToNumberConverter();
		final Long resultLong = wordRunner.run(resultStr);
		logger.info(resultLong);

	}

}
