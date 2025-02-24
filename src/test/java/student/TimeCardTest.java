package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard timeCard;

    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("x123", 40.0);
    }

    @Test
    void getEmployeeID() {
        assertEquals("x123", timeCard.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(40.0, timeCard.getHoursWorked());
    }
}