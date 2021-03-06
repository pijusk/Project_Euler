/*
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 */

package e012_highlyDivisibleTriangularNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighlyDivTriangularNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numOfFactors = 0;
		long n = 1;
		int add = 2;
		List<Integer> fac = new ArrayList<>();

		while (numOfFactors < 500) {
			fac = getDivisors(n);
			numOfFactors = fac.size();
			// only increment n and add if at this point numOfDivisors is still
			// < 500
			if (numOfFactors < 500) {
				n = n + add;
				add++;
			}
		}

		display(fac, n);

	}

	// computes all unique divisors of number integer n, returns numbers as a
	// sorted arrayList
	public static List<Integer> getDivisors(long n) {
		List<Integer> divisors = new ArrayList<>();

		// 1 and n are factors
		divisors.add(1);
		divisors.add((int) n);

		// start checking at 2
		int div = 2;

		// set sqr(n) as upper bound; divisors above sqrt(n) will be found by
		// dividing n by obtained divisors
		while (div < Math.sqrt(n)) {
			if (n % div == 0) {
				divisors.add(div);
				divisors.add((int) (n / div));
			}
			div++;
		}

		// check if sqrt(n) is a divisor of n
		if (Math.sqrt(n) == div)
			divisors.add(div);

		// sort arrayList of divisors
		Collections.sort(divisors);

		return divisors;
	}

	public static void display(List<Integer> fac, long n) {
		String out = "The triangular number smallest triangular number divisible by 500 divisors is:\n"
				+ n + "\nFactors are:\n" + fac;
		System.out.println(out);
	}
}
