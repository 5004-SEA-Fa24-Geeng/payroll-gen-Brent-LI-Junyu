package student;

/**
 * TimeCard class for tracking employee work hours.
 */
public class TimeCard implements ITimeCard {

    /** Employee ID. */
    private final String id;

    /** Hours worked by the employee. */
    private final double hoursWorked;

    /**
     * TimeCard constructor.
     *
     * @param id Employee ID
     * @param hoursWorked Hours worked
     */
    public TimeCard(String id, double hoursWorked) {
        this.id = id;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeID() {
        return id;
    }

    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}

