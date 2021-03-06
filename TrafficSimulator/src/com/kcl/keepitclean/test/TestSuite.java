package com.kcl.keepitclean.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.kcl.keepitclean.test.policy.TestPolicy;
import com.kcl.keepitclean.test.roadnetwork.TestJunction;
import com.kcl.keepitclean.test.roadnetwork.TestLaneSection;
import com.kcl.keepitclean.test.roadnetwork.TestRoad;
import com.kcl.keepitclean.test.roadnetwork.TestSingleLaneFourEntryFourExitOverlappingJunction;
import com.kcl.keepitclean.test.roadnetwork.TestSingleLaneThreeEntryThreeExitOverLappingJunction;
import com.kcl.keepitclean.test.session.SessionManagerSPRTest;
import com.kcl.keepitclean.test.session.SessionManagerTest;
import com.kcl.keepitclean.test.vehicle.TestVehicle;


@RunWith(Suite.class)
@Suite.SuiteClasses({TestRoad.class, TestLaneSection.class,
					 TestPolicy.class, SessionManagerSPRTest.class,
					 SessionManagerTest.class, TestVehicle.class,
					 TestJunction.class, TestSingleLaneFourEntryFourExitOverlappingJunction.class,
					 TestSingleLaneThreeEntryThreeExitOverLappingJunction.class})
public class TestSuite {
}
