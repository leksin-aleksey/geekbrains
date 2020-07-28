public class Main {

    public static void main(String[] args){

        //4
        Employee[] employees = initEmployees();
        //5
        printEmployeesOverAge(employees, 40);

    }

    private static Employee[] initEmployees(){
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivan Drago",
                "boxer",
                "drago@wba.com",
                "+79261234569",
                10000000,
                23);

        employees[1] = new Employee("Xenia Onatopp",
                "femme fatale",
                "Onatopp@jamesbond.com",
                "+79260070070",
                1000000,
                30);

        employees[2] = new Employee("Lev Andropov",
                "Colonel",
                "Andropov@roscosmos.ru",
                "+792619610412",
                0,
                39);

        employees[3] = new Employee("Boris The Blade",
                "arms dealer",
                "Boris@KGB.su",
                "+7XXXXXXXXXX",
                0,
                66);

        employees[4] = new Employee("Foma Kiniaev",
                "spy",
                "jason.bourne@cia.gov",
                "+1XXXXXXXXXX",
                0,
                49);

        return employees;
    }

    private static void printEmployeesOverAge(Employee[] employees, int age){
        for(Employee employee : employees){
            if(employee.getAge() > age) {
                System.out.println(employee.toString());
            }
        }
    }
}
