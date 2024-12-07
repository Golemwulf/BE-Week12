package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	private TestDemo testDemo;
	

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectlyst(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}

	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		    return Stream.of(
		    		arguments(2, 4, 6, false),
		    		arguments(100, 50, 150, false),
		    		arguments(0, 100, 100, true),
		    		arguments(-20, 10, -10, true)
		    );
		    // @formatter:on

	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(1, 5)).isEqualTo(6);
		assertThat(testDemo.addPositive(100, 50)).isEqualTo(150);
		
	}
	
	
	@Test
	
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	@Test
	void assertThatTheRandomeNumberIsDoubledCorrectly() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fivedoubled = mockDemo.doubleRandomNumber();
		assertThat(fivedoubled).isEqualTo(10);
	}
}

