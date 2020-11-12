package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

/**
 * Testing class for PositionOutOfBound.
 * 
 */
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
    @Test
    public void testRobotMovementBase() {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move the robot right until it touches the world limit
         */
        try {
			for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
			    // check if position if coherent
			    r1.moveRight();
			}
			// reached the right limit of the world
			r1.moveRight();
			
			fail("Qui non dovevi arrivare!");
		} catch (PositionOutOfBoundException e) {
			e.getMessage();
			Assert.assertNotNull(e);
		} 
        // checking positions x=50; y=0
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move to the top until it reaches the upper right conrner of the world
         */
        try {
			for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
			    // check if position if coherent
			    r1.moveUp();
			}
			// reached the upper limit of the world
			r1.moveUp();
			
			fail("Qui non dovevi arrivare!");
		} catch (PositionOutOfBoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			Assert.assertNotNull(e);
		}
        // checking positions x=50; y=80
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", RobotEnvironment.WORLD_Y_UPPER_LIMIT, r1.getEnvironment().getCurrPosY());
    }

    /**
     * Simple test for testing robot battery.
     * 
     */
    @Test
    public void testRobotBatteryBase() {
        final Robot r2 = new Robot("SimpleRobot2", 20);
        /*
         * Repeatedly move the robot up and down until the battery is completely
         * exhausted.
         */
        while (r2.getBatteryLevel() > 0) {
            r2.moveUp();
            r2.moveDown();
        }
       
        try {
			r2.moveUp();
			
			fail("Neanche qui non dovevi arrivare!");
		} catch (NotEnoughBatteryExceptions e) {
			e.getMessage();
			Assert.assertNotNull(e);
		}
       
    }
}
