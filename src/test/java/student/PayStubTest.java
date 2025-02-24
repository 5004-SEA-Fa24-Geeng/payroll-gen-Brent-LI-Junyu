package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {

    private PayStub payStub;

    @BeforeEach
    void setUp() {
        payStub = new PayStub("Junyu Li", 2000.45, 500.32, 15000.67, 3000.89);
    }

    @Test
    void getPay() {
        assertEquals(2000.45, payStub.getPay(), 0.01);

        // Test with zero pay
        PayStub zeroPayStub = new PayStub("Junyu Li", 0.0, 0.0, 15000.67, 3000.89);
        assertEquals(0.0, zeroPayStub.getPay(), 0.01);
    }

    @Test
    void getTaxesPaid() {
        assertEquals(500.32, payStub.getTaxesPaid(), 0.01);

        // Test with zero taxes
        PayStub zeroTaxStub = new PayStub("Junyu Li", 2000.45, 0.0, 15000.67, 3000.89);
        assertEquals(0.0, zeroTaxStub.getTaxesPaid(), 0.01);
    }

    @Test
    void toCSV() {
        // Test normal case
        assertEquals("Junyu Li,2000.45,500.32,15000.67,3000.89", payStub.toCSV());

        // Test with different decimal numbers
        PayStub specialStub = new PayStub("Junyu Li", 2000.51, 500.13, 15000.91, 3000.47);
        assertEquals("Junyu Li,2000.51,500.13,15000.91,3000.47", specialStub.toCSV());

        // Test with zeros
        PayStub zeroStub = new PayStub("Junyu Li", 0.0, 0.0, 0.0, 0.0);
        assertEquals("Junyu Li,0.0,0.0,0.0,0.0", zeroStub.toCSV());
    }
}