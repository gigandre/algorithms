import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanDecimal {
	private String roman = new String("");

	private static Map<Integer, String> decimalToRoman =  new LinkedHashMap<Integer, String>();
	private static Map<String, Integer> romanToDecimal = new HashMap<String, Integer>();

	{
		romanToDecimal.put("I", 1);
		romanToDecimal.put("IV", 4);
		romanToDecimal.put("V", 5);
		romanToDecimal.put("IX", 9);
		romanToDecimal.put("X", 10);
		romanToDecimal.put("XL", 40);
		romanToDecimal.put("L", 50);
		romanToDecimal.put("XC", 90);
		romanToDecimal.put("C", 100);
		romanToDecimal.put("CD", 400);
		romanToDecimal.put("D", 500);
		romanToDecimal.put("CM", 900);
		romanToDecimal.put("M", 1000);
	}


	{
		decimalToRoman.put(1000, "M");
		decimalToRoman.put(900, "CM");
		decimalToRoman.put(500, "D");
		decimalToRoman.put(400, "CD");
		decimalToRoman.put(100, "C");
		decimalToRoman.put(90, "XC");
		decimalToRoman.put(50, "L");
		decimalToRoman.put(40, "XL");
		decimalToRoman.put(10, "X");
		decimalToRoman.put(9, "IX");
		decimalToRoman.put(5, "V");
		decimalToRoman.put(4, "IV");
		decimalToRoman.put(1, "I");
	}

	public static void main(String[] args) {
		System.out.println(new RomanDecimal().convertRomanToDecimal("MMXIX"));
		System.out.println(new RomanDecimal().convertDecimalToRoman(2019));

	}

	private int convertRomanToDecimal(String roman) {
		int decimal = 0;
		int lastValue = 0;
		int currentValue = 0;

		for(char c : roman.toCharArray()) {
			currentValue =  romanToDecimal.get(String.valueOf(c));

			if(lastValue != 0 && lastValue < currentValue) {
				decimal += (currentValue - (lastValue * 2));
			}else {
				decimal += currentValue;
			}

			lastValue = currentValue;
		}

		return decimal;
	}


	private String convertDecimalToRoman(int decimal) {
		for (int i : decimalToRoman.keySet()) {
			if(decimal >= i) {
				roman = roman.concat(decimalToRoman.get(i));

				decimal -= i;
				if(decimal > 0) {
					convertDecimalToRoman(decimal);
					break;
				}else if(decimal == 0) {
					break;
				}
			}
		}

		return roman;
	}

}
