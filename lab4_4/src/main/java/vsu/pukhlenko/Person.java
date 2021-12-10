package vsu.pukhlenko;

public class Person {
    private int id;
    private String name;
    private Sex sex;
    private int salary;
    private String bDay;
    private String division;

    public Person(int id, String name, Sex sex, int salary, String bDay, String division) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.bDay = bDay;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getdivision() {
        return division;
    }

    public void setdivision(String divisions) {
        this.division = divisions;
    }

    public String PersonToString() {
        return "id: " + id + ", name: " + name + ", sex: " + sex + ", salary: " + salary + ", bDay: " + bDay + ", division: " + division;
    }
}
