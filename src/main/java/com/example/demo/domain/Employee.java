package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;

    @ManyToOne
    private Company company;

    public Employee(String first, String last, String email, Company company) {
        this.first_name = first;
        this.last_name = last;
        this.email = email;
        this.company = company;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first_name;
    }

    public void setFirst(String first) {
        this.first_name = first;
    }

    public String getLast() {
        return last_name;
    }

    public void setLast(String last) {
        this.last_name = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
