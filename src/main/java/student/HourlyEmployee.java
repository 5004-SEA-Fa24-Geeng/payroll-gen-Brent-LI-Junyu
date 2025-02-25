package student;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends AbstractEmployee {
    /**
     * Stores the calculated gross pay amount.
     */
    private double grossPay;

    /**
     * Constructs an hourly employee with the specified attributes.
     *
     * @param name             Employee name
     * @param id               Employee ID
     * @param payRate          Pay rate (hourly wage)
     * @param ytdEarnings      Year-to-date earnings
     * @param ytdTaxesPaid     Year-to-date taxes paid
     * @param pretaxDeductions Pretax deductions
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked <= REGULAR_HOURS) {
            grossPay = hoursWorked * super.getPayRate();
        } else {
            grossPay = REGULAR_HOURS * super.getPayRate()
                    + (hoursWorked - REGULAR_HOURS) * super.getPayRate() * OVERTIME_RATE;
        }

        BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        grossPay = bd.doubleValue();

        return grossPay;
    }

    /**
     * Gets the gross pay amount.
     *
     * @return The gross pay amount
     */
    public double getGrossPay() {
        return grossPay;
    }
}