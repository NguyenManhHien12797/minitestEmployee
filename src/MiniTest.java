import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MiniTest {
    public static ArrayList<Employee> employee= new ArrayList<>();

    public static void main(String[] args) {
        EmployeeFullTime emp1= new EmployeeFullTime(1,"Dung", 18,"0123456789","nguyendung@gmail.com",1500000,5000000,9000000);
        EmployeeFullTime emp2= new EmployeeFullTime(2,"Hien",19,"0234123142","nguyenhien@gmail.com",1000000,500000,3000000);
        EmployeeFullTime emp3= new EmployeeFullTime(3,"Hieu",19,"023412312","nguyenhieu@gmail.com",2000000,1500000,4000000);
        EmployeePartTime emp4= new EmployeePartTime(4,"Nam",19,"023412979","nguyennam@gmail.com",20);
        EmployeePartTime emp5= new EmployeePartTime(5,"Hoàng",19,"023412384","nguyenhoang@gmail.com",25);
        employee.add(emp1);
        employee.add(emp2);
        employee.add(emp3);
        employee.add(emp4);
        employee.add(emp5);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter the choice: ");
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Lương trung bình của nhân viên là: "+getAvgSalary(employee));
                    System.out.println("Danh sách nhân viên có lương nhỏ hơn lương trung bình:\n"+getListEmployeeFullTime(employee,getAvgSalary(employee)));
                    System.out.println("----------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Lương phải trả cho nhân viên partTime là: "+totalSalaryPartTime(employee));
                    System.out.println("------------------------------------------------------");
                    break;
                case 3:
                    System.out.println(sortEmployFullTime(employee));
                    System.out.println("------------------------------------------------------");
                    break;
                case 4:
                    System.out.println(addEmployeeFullTime(employee));
                    System.out.println("------------------------------------------------------");
                    break;
                case 5:
                    System.out.println(addEmployeePartTime(employee));
                    System.out.println("------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Hết :v");
                    System.out.println("------------------------------------------------------");
                    break;
                default:
                    System.out.println("Nhập sai rồi:)))");
            }

        } while (choice !=6);
    }

    public static void displayMenu(){
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n","Menu",
                "1.Liệt kê nhân viên có lương nhỏ hơn lương trung bình: ",
                "2. Tính lương cho nhân viên partTime: ",
                "3. Sắp xếp nhân viên fullTime có lương tăng dần:",
                "4. Thêm nhân viên fullTime",
                "5. Thêm nhân viên partTime",
                "6. Thoát");
        System.out.println("-----------------------------------------------------------");
    }
    public static double getAvgSalary(ArrayList<Employee> arr){
        double sum=0;
        for(Employee e: arr){
            sum+= e.getNetSalary();
        }
        return (sum/arr.size());
    }
        // Liệt kê sô nhân viên có lương nhỏ hơn lương trung bình
    public static ArrayList<Employee> getListEmployeeFullTime(ArrayList<Employee> arr, double avg){
        ArrayList<Employee> emp= new ArrayList<>();
        for(Employee e: arr){
            if(e instanceof EmployeeFullTime){
                if(e.getNetSalary()<avg){
                    emp.add(e);
                }
            }
        }
        return emp;
    }
    // Tính lương trả cho nv PartTime
    public static double totalSalaryPartTime(ArrayList<Employee> arr){
        double total=0;
        for(Employee e: arr){
            if(e instanceof EmployeePartTime){
                total+= e.getNetSalary();
            }
        }
        return total;
    }
    //Sắp xếp nhân viên FullTime có lương tăng dần
    public static ArrayList<Employee> sortEmployFullTime(ArrayList<Employee>arr1){
        ArrayList<Employee> newarr= new ArrayList<>();
        for(Employee arr: arr1){
            if( arr instanceof EmployeeFullTime){
              newarr.add(arr);
                newarr.sort((((o1, o2) ->
                        Double.compare(o1.getNetSalary(), o2.getNetSalary()))));
            }
        }

        return newarr;
    }
    //Thêm nhân viên
    public static ArrayList<Employee> addEmployeeFullTime(ArrayList<Employee> arr){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number Employee: ");
        int number = scanner.nextInt();

        for(int i=0; i<number; i++){
            System.out.println("Mời nhập info nhân viên thứ "+(i+1));
            int code= employee.size()+1;
            System.out.print("Enter name: ");
            Scanner inputName= new Scanner(System.in);
            String name =inputName.nextLine();
            System.out.print("Enter age: ");
            int age=scanner.nextInt();
            System.out.print("Enter phone: ");
            Scanner inputPhone= new Scanner(System.in);
            String phone= inputPhone.nextLine();
            System.out.print("Enter email: ");
            Scanner inputEmail= new Scanner(System.in);
            String email = inputEmail.nextLine();
            System.out.print("Enter bonus: ");
            double bonus = scanner.nextDouble();
            System.out.print("Enter fine: ");
            double fine = scanner.nextDouble();
            System.out.print("Enter fixedSalary: ");
            double fixedSalary= scanner.nextDouble();
            EmployeeFullTime x= new EmployeeFullTime(code,
                    name,age,phone,email, bonus, fine,fixedSalary);
            arr.add(x);
        }

        return arr;
    }
    public static ArrayList<Employee> addEmployeePartTime(ArrayList<Employee> arr){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number Employee: ");
        int number = scanner.nextInt();

        for(int i=0; i<number; i++){
            System.out.println("Mời nhập info nhân viên thứ "+(i+1));
            int code= employee.size()+1;
            System.out.print("Enter name: ");
            Scanner inputName= new Scanner(System.in);
            String name =inputName.nextLine();
            System.out.print("Enter age: ");
            int age=scanner.nextInt();
            System.out.print("Enter phone: ");
            Scanner inputPhone= new Scanner(System.in);
            String phone= inputPhone.nextLine();
            System.out.print("Enter email: ");
            Scanner inputEmail= new Scanner(System.in);
            String email = inputEmail.nextLine();
            System.out.print("Enter workingHours: ");
            double workingHours= scanner.nextDouble();
            EmployeePartTime x= new EmployeePartTime(code,
                    name,age,phone,email,workingHours);
            arr.add(x);
        }

        return arr;
    }
}
