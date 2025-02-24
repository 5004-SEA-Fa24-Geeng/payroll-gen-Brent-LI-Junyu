package student;

public class TimeCard implements ITimeCard{
    private final String id;
    private final double hoursWorked;

    public TimeCard(String id, double hoursWorked){
        this.id = id;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeID(){return id;};

    @Override
    public double getHoursWorked(){return hoursWorked;};
}
