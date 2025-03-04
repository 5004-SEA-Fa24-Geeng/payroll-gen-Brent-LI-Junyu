package student;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractEmployee implements IEmployee {


    /**
     * Tax rate for the net pay (after pretax deductions).
     */
    protected static final double TAX_RATE = 0.2265;

    /**
     * Overtime pay rate for the overtime worked hours.
     */
    protected static final double OVERTIME_RATE = 1.5;

    /**
     * Standard working hours.
     */
    protected static final int REGULAR_HOURS = 40;

    /**
     * Number of pay periods in a salaried employee's yearly salary.
     */
    protected static final int SALARY_PAY_PERIODS = 24;

    /**
     * Employee name.
     */
    private String name;

    /**
     * Employee id.
     */
    private String id;

    /**
     * Pay rate.
     */
    private double payRate;

    /**
     * Year-to-date earnings.
     */
    private double ytdEarnings;

    /**
     * Year-to-date taxes paid.
     */
    private double ytdTaxesPaid;

    /**
     * Pretax deductions.
     */
    private double pretaxDeductions;

    /**
     * Employee constructor.
     *
     * @param name             Employee name
     * @param id               Employee ID
     * @param payRate          Pay rate
     * @param ytdEarnings      Year-to-date earnings
     * @param ytdTaxesPaid     Year-to-date taxes paid
     * @param pretaxDeductions Pretax deductions
     */
    public AbstractEmployee(String name, String id, double payRate,
                            double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }



    @Override
    public PayStub runPayroll(double hoursWorked) {
        double taxes;
        double netPay;
        if (hoursWorked < 0) {
            return null;
        }

        double grossPay = calculateGrossPay(hoursWorked);
        taxes = 0;
        netPay = 0;


        if (grossPay > 0) {
            double shouldTaxPay = grossPay - pretaxDeductions;
            taxes = shouldTaxPay * TAX_RATE;
            BigDecimal bd1 = new BigDecimal(taxes).setScale(2, RoundingMode.HALF_UP);
            taxes = bd1.doubleValue();

            netPay = shouldTaxPay - taxes;
            BigDecimal bd2 = new BigDecimal(netPay).setScale(2, RoundingMode.HALF_UP);
            netPay = bd2.doubleValue();

            ytdEarnings += netPay;

            taxes = shouldTaxPay * TAX_RATE;
            netPay = shouldTaxPay - taxes;
            ytdTaxesPaid += taxes;

        }

        return new PayStub(name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * Calculates the gross pay for the employee based on hours worked.
     *
     * @param hoursWorked The number of hours worked in the pay period
     * @return The gross pay amount
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     * Converts employee information to CSV format.
     *
     * @return A string containing employee data in CSV format
     */
    public String toCSV() {
        return getEmployeeType() + ","
                + name + ","
                + id + ","
                + payRate + ","
                + pretaxDeductions + ","
                + ytdEarnings + ","
                + ytdTaxesPaid;
    }
}

