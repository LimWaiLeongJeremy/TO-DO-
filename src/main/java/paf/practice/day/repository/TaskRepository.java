package paf.practice.day.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.practice.day.model.Task;

import static paf.practice.day.repository.Query.*;

@Repository
public class TaskRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertTask(Task task) {
        return jdbcTemplate.update(
            SQL_INSERT_TASK, 
            task.getTask(), 
            task.getPriority(), 
            task.getAssignTo(),
            task.getCompleteBy());
    }


}
