public class Company {
    private Employee[] employees;
    private int size;

    public Company(int capacity){
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee){
        if(size < employees.length){
            employees[size++] = employee;
            System.out.println("Employee added successfully");
            return;
        }
        System.out.println("Storage Full, Can't add Employees");
    }

    public void traverseEmployee(){
        for(int i=0;i<size;i++){
            System.out.println(employees[i]);
        }
    }

    public void searchEmployee(int id){
        for(int i=0;i<size;i++){
            if(employees[i].getId()==id){
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("No employee found");
    }

    public void deleteEmployee(int id){
        for(int i=0;i<size;i++){
            if(employees[i].getId()==id){
                for(int j=i;j<size-1;j++){
                    employees[j] = employees[j+1];
                }

                employees[--size] = null;
                return;
            }
        }

        System.out.println("No employee found");
    }
}
