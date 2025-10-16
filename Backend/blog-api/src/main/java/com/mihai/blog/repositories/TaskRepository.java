package com.mihai.blog.repositories;

import com.mihai.blog.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Task t WHERE t.day < CURRENT_DATE")
    void deleteOlderThanToday();
}
