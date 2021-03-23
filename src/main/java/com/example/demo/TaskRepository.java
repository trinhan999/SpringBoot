package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TaskRepository extends CrudRepository<Task, Long> {
  @Transactional
  @Modifying
  @Query(value = "UPDATE Task set user = :user where taskName = :taskName", nativeQuery = true)
  void assignToUSer(@Param("user") User user,@Param("taskName") String taskName);

  @Transactional
  @Modifying
  @Query(value = "UPDATE Task set progress = :progress where taskName = :taskName", nativeQuery = true)
  void updateProgress(@Param("progress") String progress,@Param("taskName") String taskName);
}
