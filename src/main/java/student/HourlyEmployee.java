package student;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends AbstractEmployee{
    double grossPay;
    public HourlyEmployee(String name, String id, double payRate, double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions){
        super(name, id, payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
    };

    @Override
    public String getEmployeeType(){return "HOURLY";};

    @Override
    protected double calculateGrossPay(double hoursWorked){
        if (hoursWorked <= REGULAR_HOURS){
            grossPay = hoursWorked * super.getPayRate();
        } else {
            grossPay = REGULAR_HOURS * super.getPayRate()
                    + (hoursWorked - REGULAR_HOURS) * super.getPayRate() * OVERTIME_RATE;
        }

        BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        grossPay = bd.doubleValue();

        return grossPay;
    };


}
