package student;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends AbstractEmployee{
    double grossPay;
    public SalaryEmployee(String name, String id, double payRate, double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions){
        super(name, id, payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
    };

    @Override
    public String getEmployeeType(){return "SALARY";};


    @Override
    protected double calculateGrossPay(double hoursWorked){
        if (hoursWorked == 0){
            grossPay = 0;
        } else {
            grossPay = this.getPayRate() / SALARY_PAY_PERIODS;
            BigDecimal bd = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
            grossPay = bd.doubleValue();
        }

        return grossPay;
    }

};