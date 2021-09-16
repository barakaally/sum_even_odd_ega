package com.sum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Sum {

	public static void main(String[] args) throws IOException {

		try {

			/*
			 * read the provided file
			 */

			URL filePath = Sum.class.getResource("file");
			FileReader reader = new FileReader(filePath.getFile());
			/*
			 * Initialize the instance of StringBuilder to build the string from file
			 */
			StringBuilder builder = new StringBuilder();

			/*
			 * read Character by character from provided file until 0 Character ,stop when
			 * nothing to read (-1)
			 */

			int c;
			while ((c = reader.read()) != -1) {

				builder.append((char) c);

			}

			reader.close();

			/*
			 * Now builder has string data Corresponding to data found inside file ,The data
			 * inside file are separated by new line(\n),use this trick to create
			 * corresponding arrays
			 */

			String[] arrayOfNumStrings = builder.toString().split("\n");

			/*
			 * Now you have all Loop data inside string arrays and extract the sum of even
			 * and odd numbers ,keep them separates use modulus(%) operator to Distinguish
			 * them
			 */

			long sumOfEven = 0;
			long sumOfOdd = 0;
			for (String numString : arrayOfNumStrings) {

				/*
				 * remember you have string and not numbers, string to number Conversion needed
				 * here count digit number in provided file in order to know which conversion
				 * type will work if you see up to 10 digits, Integer.parseInt() will work fine
				 * if you see up to 19 digits, Long.parseLong() will work fine if you see 20 or
				 * above 20 digit parseInt and parseLong will not work for you for digit>=20
				 * ,convert them to BigInterger because they are BigInt,
				 * 
				 * 
				 * if digits>0 and digits<=10, int num=Integer.parseInt(numString.trim());
				 * 
				 * if digits>=11 and digits<=19, long num=Long.parseLong(numString.trim());
				 * 
				 * if digits>=20, BigInteger num=new BigInteger(numString.trim())
				 */

				long num = Long.parseLong(numString.trim());
				if (num % 2 == 1)
					sumOfOdd += num;
				else
					sumOfEven += num;

			}

			/*
			 * print the output outside the loop
			 */

			System.out.println(String.format("The sum of all even numbers is %2d and sum of all Odd numbers is %2d",
					sumOfEven, sumOfOdd));

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		}

	}

}
