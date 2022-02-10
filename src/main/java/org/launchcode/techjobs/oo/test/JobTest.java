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
    Job myJob1;
    Job myJob2;
    Job actualJob;
    Job actualJob1;
    @Before
     public void createJobObject() {
        myJob1 = new Job();
        myJob2 = new Job();
        actualJob = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        actualJob1 = new Job("product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(myJob1.getId(), 1);
        assertEquals(myJob2.getId(), 2);
        assertEquals(myJob2.getId() - myJob1.getId(), 1, .01);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertNotNull(actualJob);
        assertEquals(actualJob.getName(), "product tester");
        assertEquals(actualJob.getEmployer().getValue(), "ACME");
        assertEquals(actualJob.getLocation().getValue(), "Desert");
        assertEquals(actualJob.getPositionType().getValue(), "Quality control");
        assertEquals(actualJob.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(actualJob, actualJob1);
    }
}
