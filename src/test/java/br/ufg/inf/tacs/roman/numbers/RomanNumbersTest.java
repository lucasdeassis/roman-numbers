package br.ufg.inf.tacs.roman.numbers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Teste roman numbers
 * I=1, V=5 , X=10, L=50, C=100, D=500, M=1000
 */
public class RomanNumbersTest {

	private RomanNumbers romanNumbers;

	@Before
	public void setUp() {
		this.romanNumbers = new RomanNumbers();
	}
	
	@Test
	public void testRomanEmptyToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal(""));
	}
	
	@Test
	public void testAnyStringToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("sadasg2314df"));
	}
	
	@Test
	public void testRomanNotUppercaseToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("xiv"));
	}
	
	@Test
	public void testIncorrectRomanNumberIVToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("IIII"));
	}
	
	
	@Test
	public void testIncorrectRomanNumberIXToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("XVIIII"));
	}
	
	@Test
	public void testIncorrectRomanNumberXLToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("XXXX"));
	}
	
	@Test
	public void testIncorrectRomanNumberXCToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("LXXXX"));
	}
	
	
	@Test
	public void testRomanIIIToDecimal() {
		assertEquals(3, this.romanNumbers.romanToDecimal("III"));
	}
	
	@Test
	public void testRomanXXXToDecimal() {
		assertEquals(30, this.romanNumbers.romanToDecimal("XXX"));
	}
	
	@Test
	public void testRomanIVToDecimal() {
		assertEquals(4, this.romanNumbers.romanToDecimal("IV"));
	}
	
	@Test
	public void testRomanXXToDecimal() {
		assertEquals(20, this.romanNumbers.romanToDecimal("XX"));
	}
	
	@Test
	public void testRomanIXToDecimal() {
		assertEquals(9, this.romanNumbers.romanToDecimal("IX"));
	}

	@Test
	public void testRomanXVToDecimal() {
		assertEquals(15, this.romanNumbers.romanToDecimal("XV"));
	}
	
	@Test
	public void testRomanXIVToDecimal() {
		assertEquals(14, this.romanNumbers.romanToDecimal("XIV"));
	}
	
	@Test
	public void testRomanXLToDecimal() {
		assertEquals(40, this.romanNumbers.romanToDecimal("XL"));
	}

	@Test
	public void testRomanXCToDecimal() {
		assertEquals(90, this.romanNumbers.romanToDecimal("XC"));
	}
	
	@Test
	public void testIncorrectRomanToDecimal() {
		assertEquals(100, this.romanNumbers.romanToDecimal("C"));
	}
	
	@Test
	public void testRomanCCCToDecimal() {
		assertEquals(300, this.romanNumbers.romanToDecimal("CCC"));
	}	
	
	@Test
	public void testIncorrectRomanCDToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("CCCC"));
	}
	
	@Test
	public void testRomanCMToDecimal() {
		assertEquals(900, this.romanNumbers.romanToDecimal("CM"));
	}	
	
	@Test
	public void testRomanMMToDecimal() {
		assertEquals(2000, this.romanNumbers.romanToDecimal("MM"));
	}
	
	@Test
	public void testRomanMMMMMToDecimal() {
		assertEquals(-1, this.romanNumbers.romanToDecimal("MMMMM"));
	}
	
	@Test
	public void testRomanNumberRulesCombinationToDecimal() {
		assertEquals(4414, this.romanNumbers.romanToDecimal("MMMMCDXIV"));
	}
}
