/* Alert.java
   Factory for AlertTypeTest
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Assert;
import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.AlertType;

import java.util.UUID;

import static org.junit.jupiter.api.Assert.*;

public class AlertTypeFactoryTest {
    private AlertType alertType;
    private String id = UUID.randomUUID().toString();

    @Before
    public void setUp() throws Exception {
        alertType = new AlertType.AlertTypeBuilder().setAlertTypeNumber(id)
                                                    .setDescription("SOS")
                                                    .setSeverity("Medium")
                                                    .build();
    }

    @Test
    public void testCreateAlertType() {
        Assert.assertNotNull(alertType);
    }
}