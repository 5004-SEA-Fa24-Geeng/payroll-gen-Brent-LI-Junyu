package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new HourlyEmployee("Junyu Li", "x123", 25.0, 15000.0, 3000.0, 1500.0);
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", hourlyEmployee.getEmployeeType());
    }

    @Test
    void calculateGrossPay() {
        // Test regular hours (40 hours)
        assertEquals(1000.0, hourlyEmployee.calculateGrossPay(40), 0.01);

        // Test overtime (45 hours - 40 regular + 5 overtime)
        // Regular pay: 40 * 25 = 1000
        // Overtime pay: 5 * 25 * 1.5 = 187.5
        // Total: 1000 + 187.5 = 1187.5
        assertEquals(1187.50, hourlyEmployee.calculateGrossPay(45), 0.01);

        // Test zero hours
        assertEquals(0.0, hourlyEmployee.calculateGrossPay(0), 0.01);
    }
}