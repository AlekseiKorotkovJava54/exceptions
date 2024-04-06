package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = 101;

	@Test
	void test() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
	}

	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		int minFloor = 1;
		int maxFloor = N_FLOORS;
		boolean isFloorNotFound = true;
		int middle = 0;
		while(isFloorNotFound && minFloor<=maxFloor) {
			middle = (minFloor+maxFloor)/2;
			try {
				bbf.checkFloor(middle);
				minFloor = middle+1;
			} catch (Exception e) {
				maxFloor = middle-1;
			}
		}
		return minFloor;
	}

}
