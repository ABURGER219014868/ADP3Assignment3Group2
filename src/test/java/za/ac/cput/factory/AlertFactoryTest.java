/* Alert.java
   Factory for AlertTest
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */


package za.ac.cput.Factory;

import org.junit.jupiter.api.Assert;
import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Alert;

import java.util.UUID;

import static org.junit.jupiter.api.Assert.*;

public class AlertFactoryTest {
    private Alert alert;
    private String id = UUID.randomUUID().toString();

    @Before
    public void setUp() throws Exception {
        alert = new Alert.AlertBuilder().setAlertNumber(id).setAlertType("Emergency").build();
    }

    @Test
    public void testCreateAlert() {
        Assert.assertNotNull(alert);
    }
}