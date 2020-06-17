package springbootkafka.springbootkafka.model;

public class User {

    private String name;
    private String job;
    private String salary;

    public User(String name, String job, String salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }
}
