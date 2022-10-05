import java.util.*;
import java.util.stream.Collectors;

public class StreamsDemo {


    private static List<Employee> employeeList = new ArrayList<>();


    public static void main(String[] args) {
        createEmployeeList();
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
        method8();
        method9();
        method10();
        method11();
        method12();
        method13();
        method14();
        method15();

    }


    private static void createEmployeeList() {
        Employee employee1 = Employee.builder()
                .age(34).gender("Male").id(111).name("Sreenidhi").salary(1000).yoj(2016).dept("IAS").build();
        Employee employee2 = Employee.builder()
                .age(26).gender("Male").id(113).name("Srihari").salary(12000).yoj(2018).dept("SOFTWARE").build();
        Employee employee3 = Employee.builder()
                .age(32).gender("FEMALE").id(112).name("Srividya").salary(40000).yoj(2019).dept("DOCTOR").build();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

    }


    public static void method1() {
        Map<String, Long> employeeCountByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(employeeCountByGender);
    }

    public static void method2() {
        employeeList.stream().map(Employee::getDept).distinct().forEach(System.out::println);
    }

    public static void method3() {
      Map<String, Double>  avgAgeByGender  = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeByGender);
    }

    public static void method4() {
       Optional<Employee> highestEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
       System.out.println(highestEmployee.get().getName());
    }

    public static void method5() {
        employeeList.stream().filter(e -> e.getYoj() >=2018).map(Employee::getName).forEach(System.out::println);
    }


    public static void method6() {
        Map<String, Long> employeeCountByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet = employeeCountByDept.entrySet();

        for(Map.Entry<String, Long> entry: entrySet) {
            System.out.println(entry.getKey() + " :" + entry.getValue());

        }

    }

    public static void method7() {
        Map<String, Double> avgSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);
    }

    public static void method8() {
        Optional<Employee> minAGE = employeeList.stream().filter(e -> e.getGender().equals("Male") && e.getDept().equals("SOFTWARE")).min(Comparator.comparingInt(Employee::getAge));
        System.out.println(minAGE.get().getName());
    }

    public static void method9() {
        Optional<Employee> firstEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYoj)).findFirst();
        System.out.println(firstEmployee.get().getName());

    }
    public static void method10() {
        Map<String, Long> GenderFreqDept = employeeList.stream().filter(e -> e.getDept().equals("SOFTWARE")).
                collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(GenderFreqDept);
    }

    public static void method11() {
        Map<String, Double> genderAvgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(genderAvgSalary);

    }


    public static void method12() {
        Map<String, List<Employee>> DeptWiseEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept));

        for (Map.Entry<String, List<Employee>> entry :DeptWiseEmployees.entrySet()) {

            System.out.println(entry.getKey() + ":");

            for (Employee employee : entry.getValue()) {
               System.out.println(employee.getName());

            }
        }

    }

    public static void method13() {

        DoubleSummaryStatistics employeeSalary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(employeeSalary.getAverage());
        System.out.println(employeeSalary.getSum());

    }

    public static void method14() {
        Map<Boolean, List<Employee>> separateGroupByAge
                = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 27));

        for (Map.Entry<Boolean, List<Employee>> entry : separateGroupByAge.entrySet()) {

            if (entry.getKey()) {
                System.out.println("Employee age greater than 27");
            }
            else {
                System.out.println("Employee age lesser than 27");
            }

            for (Employee emp: entry.getValue()) {

               System.out.println(emp.getName());

            }



        }

    }

    public static void method15() {
        Optional<Employee> maxAGE = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

        System.out.println(maxAGE.get().getName());


    }

}
