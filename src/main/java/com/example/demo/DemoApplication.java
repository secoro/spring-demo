package com.example.demo;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    List<Employee> employees = new ArrayList<>();
    List<Company> companies = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        createCompanyList();
        createEmployeeList();
        return args -> {
            for (Company company: companies) {
                companyRepository.save(company);
            }

            for (Employee employee: employees) {
                employeeRepository.save(employee);
            }
        };
    }

    public void createEmployeeList() {
        employees.add(new Employee("Homer", "Simpson", "simspon.homer@springfieldnuclear.com", companies.get(0)));
        employees.add(new Employee("Lenny", "Leonard", "leonard.lenny@springfieldnuclear.com", companies.get(0)));
        employees.add(new Employee("Waylon", "Smithers", "smithers.waylon@springfieldnuclear.com", companies.get(0)));
        employees.add(new Employee("Carl", "Carlson", "carlson.carl@springfielnuclear.com", companies.get(0)));
        employees.add(new Employee("Apu", "Nahasapeemapetilon", "nahasapeemapetilon.apu@kwikemart.com", companies.get(1)));
        employees.add(new Employee("Sanjay", "Nahasapeemapetilon", "nahasapeemapetilon.sanjay@kwikemart.com", companies.get(1)));
        employees.add(new Employee("Jeremy", "Freedman", "freedman.jeremy@krustyburger.com", companies.get(2)));
        employees.add(new Employee("Abe", "Simpson", "simpson.abe@krustyburger.com", companies.get(2)));
        employees.add(new Employee("Krusty", "the Clown", "clown.krusty@krustyburger.com", companies.get(2)));
    }

    public void createCompanyList() {
        companies.add(new Company("Springfield Nuclear Power Plant"));
        companies.add(new Company("Kwik-E Mart"));
        companies.add(new Company("Krusty Burger"));
    }
}
