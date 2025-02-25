package student;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a salaried employee who earns a fixed amount per pay period.
 */
public class SalaryEmployee extends AbstractEmployee {
    /**
     * Stores the calculated gross pay amount.
     */
    private double grossPay;

    /**
     * Constructs a salaried employee with the specified attributes.
     *
     * @param name             Employee name
     * @param id               Employee ID
     * @param payRate          Pay rate (annual salary)
     * @param ytdEarnings      Year-to-date earnings
     * @param ytdTaxesPaid     Year-to-date taxes paid
     * @param pretaxDeductions Pretax deductions
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Returns the type of this employee.
     *
     * @return The string "SALARY" indicating the employee type
     */
    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked == 0) {
            grossPay = 0;
        } else {
            grossPay = this.getPayRate() / SALARY_PAY_PERIODS;
            BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
            grossPay = bd.doubleValue();
        }

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

