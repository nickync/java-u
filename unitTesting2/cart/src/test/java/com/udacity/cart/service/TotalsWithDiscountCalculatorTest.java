package com.udacity.cart.service;

import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import com.udacity.cart.model.User;
import com.udacity.cart.model.UserType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalsWithDiscountCalculatorTest {

	static User globalUser;
	TotalsWithDiscountCalculator totalsWithDiscountCalculator;

	@BeforeAll
	static void setGlobalUser(){
		System.out.println("Setting up a global user");
		globalUser = new User("Global user", UserType.REGULAR, 100.00);
	}

	@BeforeEach
	void setupCalcutor(){
		System.out.println("Setting up a new calculator");
		totalsWithDiscountCalculator = new TotalsWithDiscountCalculator(globalUser);
	}

	@RepeatedTest(3)
	void getTotalWithDiscounts_userWithCredit_chargedMultipleTimes(RepetitionInfo repetitionInfo){
		totalsWithDiscountCalculator.getTotals(List.of(new CartItem("Twenty dollar item", 20, 0)));
		assertEquals(100-20* repetitionInfo.getCurrentRepetition(), globalUser.getCredit());
	}

	@ParameterizedTest
	@MethodSource("differentUserTypesAndExpectedTotals")
	void getTotalWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal(User user, CartTotals expectedCartTotals) {
		TotalsWithDiscountCalculator calculator = new TotalsWithDiscountCalculator(user);

		CartTotals totals = calculator.getTotals(List.of(new CartItem("Ten dollar item", 10.0, 1.0)));

		assertEquals(expectedCartTotals, totals);
	}

	private static Stream<Arguments> differentUserTypesAndExpectedTotals(){
		return Stream.of(
				Arguments.of(
						new User("Regular User", UserType.REGULAR, 0.0),
						new CartTotals(10,1)
				),
				Arguments.of(
						new User("Platinum User", UserType.PLATINUM, 0.0),
						new CartTotals(9,1)
				)
		);
	}

}

// Replace this with a Repeated test. Use a BeforeAll method to create a user whose credit
	// will be reduced with each repetition, and use a BeforeEach method to create a new TotalsWithDiscountCalculator
	// for each repetition.
/*	@Test
	public void totalsWithDiscount_getTotals_reducesUserCredit() {
		User user = new User("UserPerson", UserType.REGULAR, 100.00);

		TotalsWithDiscountCalculator totalsWithDiscountCalculator = new TotalsWithDiscountCalculator(user);
		double expected;

		for(int i = 1; i < 4; i++) {
			totalsWithDiscountCalculator.getTotals(List.of(new CartItem("Twenty dollar item", 20.0, 0)));
			expected = 100.0 - (i * 20);
			assertEquals(expected, user.getCredit());
		}
	}*/

	// Replace this with a parameterized test that uses a MethodSource to provide
	// a stream of arguments allowing you to test both regular and platinum users with the
	// same test.
/*	@Test
	public void totalsWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal() {
		User regularUser = new User("Regular User", UserType.REGULAR, 0.0);
		CartTotals expectedRegularTotal = new CartTotals(10.0, 1.0);
		TotalsWithDiscountCalculator regularCalculator = new TotalsWithDiscountCalculator(regularUser);

		User platinumUser = new User("Platinum User", UserType.PLATINUM, 0.0);
		CartTotals expectedPlatinumTotal = new CartTotals(9.0, 1.0);
		TotalsWithDiscountCalculator platinumCalculator = new TotalsWithDiscountCalculator(platinumUser);

		CartItem item = new CartItem("Ten Dollar Item", 10.0, 1.0);

		assertEquals(expectedRegularTotal, regularCalculator.getTotals(List.of(item)));
		assertEquals(expectedPlatinumTotal, platinumCalculator.getTotals(List.of(item)));


	}*/