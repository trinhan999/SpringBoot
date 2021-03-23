package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

enum Progress {
  TODO,
  IN_PROGRESS,
  DONE
}

@Entity
public class Task {
  @Id
  @NotBlank(message = "Name is mandatory")
  @Column(name = "TASKNAME")
  private String taskName;

  @Column(name = "DESCRIPTION")
  private String description;

  @Min(1)
  @Max(5)
  @Column(name = "TASKPOINT")
  private Integer taskPoint;

  @ManyToOne
  @JoinColumn(name = "USER")
  private User assignee;

  @Column(name = "PROGRESS")
  @Enumerated(EnumType.STRING)
  private Progress progress;

  //region Generate
  public Task() {
  }

  public Task(@NotBlank(message = "Name is mandatory") String taskName, String description,
              @Min(1) @Max(5) Integer taskPoint, User assignee, Progress progress) {
    this.taskName = taskName;
    this.description = description;
    this.taskPoint = taskPoint;
    this.assignee = assignee;
    this.progress = progress;
  }

  public Task(@NotBlank(message = "Name is mandatory") String taskName, String description,
              @Min(1) @Max(5) Integer taskPoint, User assignee) {
    this.taskName = taskName;
    this.description = description;
    this.taskPoint = taskPoint;
    this.assignee = assignee;
    this.progress = Progress.TODO;
  }

  public Task(@NotBlank(message = "Name is mandatory") String taskName, String description,
              @Min(1) @Max(5) Integer taskPoint) {
    this.taskName = taskName;
    this.description = description;
    this.taskPoint = taskPoint;
    this.progress = Progress.TODO;
  }

  @Override
  public String toString() {
    return "Task{" +
        "taskName='" + taskName + '\'' +
        ", description='" + description + '\'' +
        ", taskPoint=" + taskPoint +
        ", assignee=" + assignee +
        ", progress=" + progress +
        '}';
  }

  public String getTaskName() {
    return taskName;
  }

  public String getDescription() {
    return description;
  }
}
