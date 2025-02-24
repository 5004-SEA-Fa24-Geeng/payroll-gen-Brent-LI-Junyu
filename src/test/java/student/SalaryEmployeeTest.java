package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {

    private SalaryEmployee salaryEmployee;

    @BeforeEach
    void setUp() {
        salaryEmployee = new SalaryEmployee("Junyu Li", "x123", 52123.45, 15000.67, 3000.89, 1500.45);
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", salaryEmployee.getEmployeeType());
    }

    @Test
    void calculateGrossPay() {
        // Test normal case
        // 52123.45 / 24 = 2171.81 (rounded to 2 decimal places)
        assertEquals(2171.81, salaryEmployee.calculateGrossPay(40), 0.01);

        // Test zero hours
        assertEquals(0.0, salaryEmployee.calculateGrossPay(0), 0.01);

        // Test with a different salary amount
        SalaryEmployee differentSalaryEmployee = new SalaryEmployee(
                "Junyu Li", "x123", 48567.89, 15000.67, 3000.89, 1500.45);
        // 48567.89 / 24 = 2023.66 (rounded to 2 decimal places)
        assertEquals(2023.66, differentSalaryEmployee.calculateGrossPay(40), 0.01);
    }
}