package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job myJob1 = new Job();
        Job myJob2 = new Job();
        assertNotEquals(myJob2.getId(), myJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job actualJob = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotNull(actualJob);
        assertEquals(actualJob.getName(), "product tester");
        assertEquals(actualJob.getEmployer().getValue(), "ACME");
        assertEquals(actualJob.getLocation().getValue(), "Desert");
        assertEquals(actualJob.getPositionType().getValue(), "Quality control");
        assertEquals(actualJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(actualJob.getName() instanceof String);
        assertTrue(actualJob.getEmployer() instanceof Employer);
        assertTrue(actualJob.getLocation() instanceof Location);
        assertTrue(actualJob.getPositionType() instanceof PositionType);
        assertTrue(actualJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job actualJob = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job actualJob1 = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(actualJob, actualJob1);
        assertFalse(actualJob.equals(actualJob1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job actualJob = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String objString = actualJob.toString();
        char first = objString.charAt(0);
        char last =  objString.charAt(objString.length() - 1)  ;
        char expectedValue = '\n';

        assertEquals(expectedValue, first);
        assertEquals(expectedValue, last);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job actualJob = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String objString = actualJob.toString();
        String expectedString = "\n" +
                "ID: " +  actualJob.getId() + "\n"+
                "Name: " + "product tester" + "\n"+
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control"+ "\n" +
                "Core Competency: " + "Persistence" + "\n";

        assertEquals(expectedString, objString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJobWithEmptyFields = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobStr = newJobWithEmptyFields.toString();
        String expectedString = "\n" +
                "ID: " +  newJobWithEmptyFields.getId() + "\n"+
                "Name: " + "Data not available" + "\n"+
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Quality control"+ "\n" +
                "Core Competency: " + "Persistence" + "\n";

        assertEquals(expectedString, newJobStr);
    }
}
