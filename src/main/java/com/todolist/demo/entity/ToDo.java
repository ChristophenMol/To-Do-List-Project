package com.todolist.demo.entity;

import java.time.LocalDate;
import javax.persistence.*;


import java.util.Objects;
import lombok.Data;

@Entity
@Data
public class ToDo {
        @Id                            
        @GeneratedValue(strategy = GenerationType.AUTO)   
        private Long id;
        private String task;
        private LocalDate targetDate;
    
        @ManyToOne
        private User author;

        public ToDo() {}
    
    
        public ToDo(String task, User author, LocalDate targetDate) {
            this.task = task;
            this.author = author;
            this.targetDate = targetDate;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getTask() {
            return task;
        }
    
        public void setTask(String task) {
            this.task = task;
        }
    
        public User getAuthor() {
            return author;
        }
    
        public void setAuthor(User author) {
            this.author = author;
        }
    
        public LocalDate getTargetDate() {
            return targetDate;
        }

        public void setTargetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
        }
        @Override
        public boolean equals(Object o) {                               // implementing a custom equals method to make sure
        if (this == o) return true;                                     // that two objects of class "User" are compared based on their ids
            if (o == null || getClass() != o.getClass()) return false;  // so that Hibernate and Set will consider two objects with same id as equal
            ToDo toDo = (ToDo) o;
            return id == toDo.id;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    
        @Override
        public String toString() {
            return "ToDo{" +
                    "id=" + id +
                    ", task='" + task + '\'' +
                    ", author=" + author +
                    '}';
        }
    }

