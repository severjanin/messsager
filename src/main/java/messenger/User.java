package messenger;

import java.time.Clock;

public class User {
    private String email;
    private String name;
    private int age;
    private String password;
    private Clock lastLoginTime;

    public User(String email, String name, int age, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
