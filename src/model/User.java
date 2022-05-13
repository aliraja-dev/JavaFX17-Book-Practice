package model;

import services.DataService;

public class User {
    private String name;

    DataService dataService = new DataService();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public User() {
        this(null, null);
    }

    public User(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public boolean save() {
        this.dataService.writeToFile();
        System.out.println("Saving user: " + this.getName());
        return true;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }
}
