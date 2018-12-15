package com.company.convert;

import org.apache.log4j.Logger;

public class NumberToWordConverter extends AbstractConverter {

	private static Logger logger = Logger.getLogger(NumberToWordConverter.class);

	@Override
	String getName() {
		return "Number to Word Converter";
	}


	@Override
	public String run(Long number) {
		try {
			super.run(number);

			logger.info("Conversion completed successfully");
			return convert(number);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		finally {
		}
	}

	private static String convert(Long number) throws Exception {
		if (String.valueOf(number).length() > 12)
			throw new Exception("Bigger than 12 digit values are not supported");

		if (number == 0) {
			return specialNumbers[0];
		}

		String result = "";

		if (number < 0) {
			String numberStr = String.valueOf(number);
			numberStr = numberStr.substring(1);
			return "minus " + convert(Long.valueOf(numberStr));
		}
		if ((number / billionVal) > 0) {
			result += convert(number / billionVal) + " " + billionText +" ";
			number %= billionVal;
		}
		if ((number / millionVal) > 0) {
			result += convert(number / millionVal) + " " + millionText +" ";
			number %= millionVal;
		}
		if ((number / thousandVal) > 0) {
			result += convert(number / thousandVal) + " " + thousandText +" ";
			number %= thousandVal;
		}
		if ((number / hundredVal) > 0) {
			result += convert(number / hundredVal) + " " + hundredText +" ";
			number %= hundredVal;
		}

		if (number > 0) {
			if (number < 20) {
				result += specialNumbers[number.intValue()];
			}
			else {
				result += multipleOfTens[number.intValue() / tenVal];
				if ((number % tenVal) > 0) {
					result += "-" + specialNumbers[number.intValue() % tenVal];
				}
			}
		}

		return result;
	}
}
