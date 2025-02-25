package student;

public class PayStub implements IPayStub {
    /**
     * Employee name.
     */
    private String name;

    /**
     * Net pay for the current pay period.
     */
    private double netPay;

    /**
     * Taxes paid for the current pay period.
     */
    private double taxes;

    /**
     * Year-to-date earnings.
     */
    private double ytdEarnings;

    /**
     * Year-to-date taxes paid.
     */
    private double ytdTaxesPaid;

    /**
     * Constructs a PayStub with the specified values.
     *
     * @param name          Employee name
     * @param netPay        Net pay for the current pay period
     * @param taxes         Taxes paid for the current pay period
     * @param ytdEarnings   Year-to-date earnings
     * @param ytdTaxesPaid  Year-to-date taxes paid
     */
    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Gets the pay for the current pay period.
     *
     * @return the pay for the current pay period
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid for the current pay period
     */
    @Override
    public double getTaxesPaid() {
        return taxes;
    }

    /**
     * Gets the employee name.
     *
     * @return the employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the year-to-date earnings.
     *
     * @return the year-to-date earnings
     */
    public double getYtdEarnings() {
        return ytdEarnings;
    }

    /**
     * Gets the year-to-date taxes paid.
     *
     * @return the year-to-date taxes paid
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Converts the PayStub object to a CSV string.
     *
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     *
     * @return the CSV string
     */
    @Override
    public String toCSV() {
        return name + ","
                + trimTrailingZero(netPay) + ","
                + trimTrailingZero(taxes) + ","
                + trimTrailingZero(ytdEarnings) + ","
                + trimTrailingZero(ytdTaxesPaid);
    }

    /**
     * Formats a double to have two decimal places and removes the trailing zero if needed.
     *
     * @param number the number to format
     * @return the formatted string
     */
    private String trimTrailingZero(double number) {
        String formatted = String.format("%.2f", number);
        if (formatted.charAt(formatted.length() - 1) == '0') {
            return formatted.substring(0, formatted.length() - 1);
        }
        return formatted;
    }
}

