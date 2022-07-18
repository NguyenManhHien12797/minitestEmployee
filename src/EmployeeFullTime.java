public class EmployeeFullTime extends Employee{
    private double bonus;
    private double fine;
    private double fixedSalary;
    public EmployeeFullTime(int code, String name, int age, String phone, String email, double bonus, double fine, double fixedSalary) {
        super(code, name, age, phone, email);
        this.bonus = bonus;
        this.fine = fine;
        this.fixedSalary = fixedSalary;
    }



    public String toString(){
        return super.toString()+" "+bonus+" "+ fine+" "+ fixedSalary+"\n";
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus( double bonus) {

        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
    public double getNetSalary(){
        return fixedSalary + (bonus- fine);
    }
}
