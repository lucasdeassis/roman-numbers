package br.ufg.inf.tacs.roman.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class RomanNumbers {

	private Pattern patternRomanNumber;

	public RomanNumbers() {
	}

	/**
	 * roman numbers to integer from 1 to 4999
	 * 
	 * @param roman
	 *            the roman number string
	 * @return the roman number in decimal or -1 if the input is not a roman
	 *         number
	 * @throws NumberFormatException
	 *             if the roman number conversion failed
	 */
	public int romanToDecimal(String roman) throws NumberFormatException {

		this.patternRomanNumber = Pattern.compile("^(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

		Matcher matcher = this.patternRomanNumber.matcher(roman);

		if (matcher.find() && !roman.isEmpty()) {
			int M = extractThousands(matcher.group(1));
			int CD = extractHundreds(matcher.group(2));
			int XL = extractHalfHundred(matcher.group(3));
			int XVI = extractDecimals(matcher.group(4));

			return M + CD + XL + XVI;
		}

		return -1;
	}

	/**
	 * IX|IV|V?I{0,3}
	 * 
	 * @param roman
	 *            number string
	 * @return decimal value
	 */
	private int extractDecimals(String roman) {
		if (roman.equals("IX")) {
			return 9;
		}
		if (roman.equals("IV")) {
			return 4;
		} else {
			return units(roman) + fiveIfExists(roman);
		}
	}

	private int fiveIfExists(String roman) {
		return StringUtils.contains(roman, "V") ?  5 : 0;
	}

	private int units(String roman) {
		return StringUtils.countMatches(roman, "I");
	}

	/**
	 * XC|XL|L?X{0,3}
	 * 
	 * @param roman
	 *            number string
	 * @return half hundred value
	 */
	private int extractHalfHundred(String roman) {

		if (roman.equals("XC")) {
			return 90;
		}
		if (roman.equals("XL")) {
			return 40;
		} else {
			return decimals(roman) + fiftyIfExists(roman);
		}

	}

	private int fiftyIfExists(String roman) {
		return StringUtils.contains(roman, "L") ?  50 : 0;
	}

	private int decimals(String roman) {
		return StringUtils.countMatches(roman, "X") * 10;
	}

	/**
	 * CM|CD|D?C{0,3}
	 * 
	 * @param roman
	 *            number string
	 * @return hundred value
	 */
	private int extractHundreds(String roman) {
		if (roman.equals("CM")) {
			return 900;
		}
		if (roman.equals("CD")) {
			return 400;
		} else {
			return hundreds(roman) + fiveHundredIfExists(roman);
		}
	}

	private int fiveHundredIfExists(String roman) {
		return StringUtils.contains(roman, "V") ?  500 : 0;
	}

	private int hundreds(String roman) {
		return StringUtils.countMatches(roman, "C") * 100;
	}

	/**
	 * M{0,4}
	 * 
	 * @param roman
	 *            number string
	 * @return thousand value
	 */
	private int extractThousands(String roman) {
		return StringUtils.countMatches(roman, "M") * 1000;
	}
}
