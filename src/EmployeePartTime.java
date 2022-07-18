public class EmployeePartTime extends Employee{
    private double workingHours;

    public EmployeePartTime(int code, String name, int age, String phone, String email, double workingHours) {
        super(code, name, age, phone, email);
        this.workingHours = workingHours;
    }
    public String toString(){
        return super.toString()+" "+ workingHours+"\n";
    }

    @Override
    public double getNetSalary() {
        return workingHours *100000;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}
