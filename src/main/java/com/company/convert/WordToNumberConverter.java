package com.company.convert;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class WordToNumberConverter extends AbstractConverter {

	private static Logger logger = Logger.getLogger(WordToNumberConverter.class);

	@Override
	String getName() {
		return "Word to Number Converter";
	}

	@Override
	public Long run(String word) {
		try {
			super.run(word);

			logger.info("Conversion completed successfully");
			return convert(word);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0L;
		}
		finally {
		}
	}

	private Long convert(String word) {
		Long result = 0L;

		if (StringUtils.isBlank(word)) {
			return result;
		}

		if (word.startsWith("minus")) {
			String wordStr = word.substring(6);
			return -+convert(wordStr);
		}

		if (word.contains(billionText)) {
			String temp = word.substring(0, word.indexOf(billionText));
			result += convert(temp) * billionVal;
			word = word.substring(word.indexOf(billionText) + 7);
		}

		if (word.contains(millionText)) {
			String temp = word.substring(0, word.indexOf(millionText));
			result += convert(temp) * millionVal;
			word = word.substring(word.indexOf(millionText) + 7);
		}

		if (word.contains(thousandText)) {
			String temp = word.substring(0, word.indexOf(thousandText));
			result += convert(temp) * thousandVal;
			word = word.substring(word.indexOf(thousandText) + 8);
		}

		if (word.contains(hundredText)) {
			String temp = word.substring(0, word.indexOf(hundredText));
			result += convert(temp) * hundredVal;
			word = word.substring(word.indexOf(hundredText) + 7);
		}

		word = word.trim();
		if (word.length() > 0) {

			if (word.contains("-")) {
				String first = word.substring(0, word.indexOf("-"));
				String second = word.substring(word.indexOf("-") + 1);

				if (Arrays.asList(multipleOfTens).contains(first)) {
					result += Arrays.asList(multipleOfTens).indexOf(first) * tenVal;
				}

				if (Arrays.asList(specialNumbers).contains(second)) {
					result += Arrays.asList(specialNumbers).indexOf(second) * 1;
				}
			}
			else {
				if (Arrays.asList(multipleOfTens).contains(word)) {
					result += Arrays.asList(multipleOfTens).indexOf(word) * tenVal;
				} else if (Arrays.asList(specialNumbers).contains(word)) {
					result += Arrays.asList(specialNumbers).indexOf(word) * 1;
				}
			}
		}

		return result;
	}
}
