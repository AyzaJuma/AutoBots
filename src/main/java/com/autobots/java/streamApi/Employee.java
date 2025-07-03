package com.autobots.java.streamApi;

public class Employee {

    private int id;
    private String name;
    private int age;
    private int salary;
    private String department;

    // создаем конструктор через быстрые клавиши:

    public Employee(int id, String name, int age, int salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // создаем геттер и сеттер:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // создадим тустринг:

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}' + "\n";
    }


    // создадим список сотрудников в классе StreamApiLesson
}
