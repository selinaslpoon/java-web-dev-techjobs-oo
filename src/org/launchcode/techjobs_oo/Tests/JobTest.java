package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Main.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Employer employer;
    Location location;
    PositionType positionType;
    CoreCompetency coreCompetency;

    @Before
    public void setUpJobTests() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        int expected = 1;
        int actual = job2.getId() - job1.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.getId() == job4.getId());
    }

    @Test
    public void testJobsToStringForBlankLines() {
        assertTrue(job1.toString().contains("\n"));
    }

    @Test
    public void testJobsToStringForLabelAndDataOnEachLine() {
        String expected = "Name: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence";
        String actual = job3.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testJobsToStringForEmptyFields() {
        String expected = "Name: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available";
        String actual = job1.toString();
        assertTrue(actual.contains(expected));
    }

}


