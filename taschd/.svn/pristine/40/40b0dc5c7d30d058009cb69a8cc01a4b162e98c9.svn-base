package edu.udel.cis.taschd.time;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.time.DayOfWeek;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.udel.cis.taschd.time.TimeInterval;


/**
 * Tests of the {@link TimeInterval} class. 
 * 
 * @author siegel
 * @author nikhil
 */

public class TimeIntervalTest {
	private static PrintStream out = System.out;
			
	/**
	 * Tuesday 11:00 AM - 12:15 PM.
	 */
	public static TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 0,
			75);

	/**
	 * Tuesday 12:20 PM - 1:25 PM.
	 */
	public static TimeInterval ti2 = new TimeInterval(DayOfWeek.TUESDAY, 12,
			20, 65);
	
	// new
	/**
	 * "TR 3:30PM - 4:45PM"
	 */
	public static TimeInterval ti3 = new TimeInterval(DayOfWeek.THURSDAY, 15, 
			30, 75);
	
	/**
	 * "TR 11:00AM - 12:15PM"
	 */
	public static TimeInterval ti4 = new TimeInterval(DayOfWeek.THURSDAY, 11, 
			0, 75);
	
    /**
     * "W 4:40PM - 5:55PM"
     */
	public static TimeInterval ti5 = new TimeInterval(DayOfWeek.WEDNESDAY, 16, 
			40, 75);
	
	/**
	 * "TR 2:00PM - 3:15PM"
	 */
	public static TimeInterval ti6 = new TimeInterval(DayOfWeek.THURSDAY, 14, 
			0, 75);
	/**
	 * "TR 12:30PM - 1:45PM"
	 */
	public static TimeInterval ti7 = new TimeInterval(DayOfWeek.THURSDAY, 12, 
			30, 75);
	
	/**
	 * "Mon 11:15AM - 12:05PM"
	 */
	public static TimeInterval ti8 = new TimeInterval(DayOfWeek.MONDAY, 11, 
			15, 50);
	
	/**
	 * "Wed 11:15AM - 12:05PM"
	 */
	public static TimeInterval ti9 = new TimeInterval(DayOfWeek.WEDNESDAY, 11, 
			15, 50);
	
	/**
	 * "Fri 11:15AM - 12:05PM"
	 */
	public static TimeInterval ti10 = new TimeInterval(DayOfWeek.FRIDAY, 11, 
			15, 50);
	
	/**
	 * "Wed 3:35PM - 4:50PM"
	 */
	public static TimeInterval ti11 = new TimeInterval(DayOfWeek.WEDNESDAY, 15, 
			35, 75);
	
	/**
	 * "Fri 3:35PM - 4:50PM"
	 */
	public static TimeInterval ti12 = new TimeInterval(DayOfWeek.FRIDAY, 15, 
			35, 75);
	
	/**
	 * "Wed 11:15AM - 12:05PM"
	 */
	public static TimeInterval ti13 = new TimeInterval(DayOfWeek.WEDNESDAY, 11, 
			15, 50);
	
	/**
	 * Fake {@link TimeInterval} for testing a exception.
	 * "Wed 11:15PM - 12:05PAM (Thur)"
	 */
	public static TimeInterval ti14 = new TimeInterval(DayOfWeek.WEDNESDAY, 23, 
			15, 50);
	
	public static TimeInterval ti15 = new TimeInterval("Fri 13:15–15:15");
	public static TimeInterval ti16 = new TimeInterval("Wed 23:15–0:05 (Thu)");
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStart1() {
		assertEquals(24 * 60 + 11 * 60, ti1.getStartTime());
	}

	@Test
	public void testEnd1() {
		assertEquals(24 * 60 + 11 * 60 + 75, ti1.getEndTime());
	}

	@Test
	public void testDuration1() {
		assertEquals(75, ti1.getDuration());
	}

	@Test
	public void testMinutesAfter1() {
		assertEquals(5, ti2.minutesAfter(ti1));
	}

	@Test
	public void testMinutesAfter2() {
		assertEquals(9915,ti7.minutesAfter(ti6));
	}
	
	@Test
	public void toString1() {
		out.println(ti1);
		assertEquals("Tue 11:00–12:15", ti1.toString());
	}

	@Test
	public void toString2() {
		out.println(ti2);
	}
	
	@Test
	public void toString3() {
		assertEquals("Wed 23:15–0:05 (Thu)", ti14.toString());
	}

	@Test
	public void toString4() {
		out.println(ti15);
		assertEquals("Fri 13:15–15:15", ti15.toString());
	}
	
	@Test
	public void toString5() {
		out.println(ti16);
		assertEquals("Wed 23:15–0:05 (Thu)", ti16.toString());
	}
	
	@Test
	public void endDayOfWeek1() {
		assertEquals(DayOfWeek.TUESDAY, ti1.getEndDayOfWeek());
	}

	@Test
	public void testGetStartDayOfWeek() {
		assertEquals(DayOfWeek.MONDAY, ti8.getEndDayOfWeek());
	}
	
	@Test
	public void testGetStartHourOfDay() {
		assertEquals(11, ti8.getStartHourOfDay());
	}
	
	@Test
	public void testgetStartMinuteOfHour() {
		assertEquals(45, ti7.getEndMinuteOfHour());
	}
	
	@Test
	public void testGetEndHourOfDay() {
		assertEquals(12, ti10.getEndHourOfDay());
	}
	
	@Test
	public void testGetEndMinuteOfHour() {
		assertEquals(5, ti10.getEndMinuteOfHour());
	}
	
	@Test
	public void testCompareStart1() {
		assertEquals(-1, ti8.compareStart(ti10));
	}
	
	@Test
	public void testCompareStart2() {
		assertEquals(1, ti2.compareStart(ti8));
	}
	
	@Test
	public void testCompareStart3() {
		assertEquals(0, ti9.compareStart(ti13));
	}
	
	@Test
	public void testCompareEnd() {
		assertEquals(1, ti10.compareEnd(ti8));
	}
	
	@Test
	public void testCompareEnd2() {
		assertEquals(0, ti9.compareEnd(ti13));
	}
	
	@Test
	public void testCompareEnd3() {
		assertEquals(-1, ti4.compareEnd(ti10));
	}
	
	@Test
	public void testTimeString() {
		assertEquals("12:30–13:45", ti7.timeString());
	}
	
	@Test
	public void testEquals1() {
		assertEquals(false, ti6.equals(ti9));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(true, ti9.equals(ti9));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals3() {
		assertEquals(false, ti9.equals(1));
	}
	
	@Test
	public void testHashCode() {
		assertEquals(675000050, ti8.hashCode());
	}
	
}
