package paf.practice.day.model;

public class User {
    private String username;
    private String password;
    private String email;
    private String date;
    private String phone;
    private int status;

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", email=" + email + ", date=" + date
                + ", phone=" + phone + ", status=" + status + "]";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
