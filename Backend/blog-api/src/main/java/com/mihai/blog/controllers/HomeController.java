package com.mihai.blog.controllers;

import com.mihai.blog.models.Task;
import com.mihai.blog.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class HomeController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAll() {
        taskRepository.deleteOlderThanToday();
        return taskRepository.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        task.setDay(LocalDate.now());
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}/toggle")
    public Task completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }

}
