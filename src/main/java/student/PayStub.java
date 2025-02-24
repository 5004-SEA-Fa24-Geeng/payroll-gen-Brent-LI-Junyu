package student;

public class PayStub implements IPayStub{
    String name;
    double netPay;
    double taxes;
    double ytdEarnings;
    double ytdTaxesPaid;
    
    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid){
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
    public double getPay(){return netPay;};

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid for the current pay period
     */
    @Override
    public double getTaxesPaid(){return taxes;};

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

    private String trimTrailingZero(double number) {
        String formatted = String.format("%.2f", number);
        if (formatted.charAt(formatted.length() - 1) == '0') {
            return formatted.substring(0, formatted.length() - 1);
        }
        return formatted;
    }

}
