package paf.practice.day.repository;

public class Query {
    public static final String SQL_INSERT_USER = "insert into user (username, password, email, dob, phone) value (?, sha1(?), ?, ?, ?)";
    public static final String SQL_INSERT_TASK = "insert into task (task_name, priority, assign_to, completion_date) value (?, ?, ?, ?)";
    public static final String SQL_AUTHENTICATE_USER = "select count(*) > 0 as auth_state from user where username = ? and password = sha1(?);";
}
