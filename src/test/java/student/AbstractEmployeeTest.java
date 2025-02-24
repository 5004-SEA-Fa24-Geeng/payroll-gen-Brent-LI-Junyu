package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractEmployeeTest {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    void setUp() {
        // Initialize test employees with realistic values
        hourlyEmployee = new HourlyEmployee("Chunyu Li", "H123", 20.00, 10000.00, 2000.00, 100.00);
        salaryEmployee = new SalaryEmployee("Junyu Li", "S456", 52000.00, 15000.00, 3000.00, 200.00);
    }

    @Test
    void getName() {
        assertEquals("Chunyu Li", hourlyEmployee.getName());
        assertEquals("Junyu Li", salaryEmployee.getName());
    }

    @Test
    void getID() {
        assertEquals("H123", hourlyEmployee.getID());
        assertEquals("S456", salaryEmployee.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(20.00, hourlyEmployee.getPayRate());
        assertEquals(52000.00, salaryEmployee.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(10000.00, hourlyEmployee.getYTDEarnings());
        assertEquals(15000.00, salaryEmployee.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(2000.00, hourlyEmployee.getYTDTaxesPaid());
        assertEquals(3000.00, salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(100.00, hourlyEmployee.getPretaxDeductions());
        assertEquals(200.00, salaryEmployee.getPretaxDeductions());
    }

    @Test
    void runPayroll_HourlyEmployee() {
        // Test regular hours (40 hours)
        PayStub regularHoursStub = hourlyEmployee.runPayroll(40);
        assertNotNull(regularHoursStub);

        // Test overtime hours (45 hours)
        PayStub overtimeStub = hourlyEmployee.runPayroll(45);
        assertNotNull(overtimeStub);

        // Test zero hours
        PayStub zeroHoursStub = hourlyEmployee.runPayroll(0);
        assertNotNull(zeroHoursStub);

        // Test negative hours
        assertNull(hourlyEmployee.runPayroll(-10));
    }

    @Test
    void runPayroll_SalaryEmployee() {
        // Test regular pay period
        PayStub regularStub = salaryEmployee.runPayroll(40);
        assertNotNull(regularStub);

        // Test zero hours
        PayStub zeroHoursStub = salaryEmployee.runPayroll(0);
        assertNotNull(zeroHoursStub);

        // Test negative hours
        assertNull(salaryEmployee.runPayroll(-5));
    }

    @Test
    void toCSV() {
        String expectedHourlyCSV = "HOURLY,Chunyu Li,H123,20.0,100.0,10000.0,2000.0";
        String expectedSalaryCSV = "SALARY,Junyu Li,S456,52000.0,200.0,15000.0,3000.0";

        assertEquals(expectedHourlyCSV, hourlyEmployee.toCSV());
        assertEquals(expectedSalaryCSV, salaryEmployee.toCSV());
    }
}