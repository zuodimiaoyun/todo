package club.wayto.todo.model;

import java.util.List;

public class User {

    private Long id;

    private String email;

    private String password;

    private String name;

    private List<Task> runningTasks;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getRunningTasks() {
        return runningTasks;
    }

    public void setRunningTasks(List<Task> runningTasks) {
        this.runningTasks = runningTasks;
    }
}
