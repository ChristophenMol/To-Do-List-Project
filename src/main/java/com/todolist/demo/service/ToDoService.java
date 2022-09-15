package com.todolist.demo.service;

import org.springframework.stereotype.Service;
import com.todolist.demo.repository.ToDoRepository;
import com.todolist.demo.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepo;          // Adding a "dependency" on the TodoRepository

    public ToDoService(ToDoRepository toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> getToDos() {
        List<ToDo> allToDos = new ArrayList<>();

        toDoRepo.findAll().forEach(allToDos::add);

        return allToDos;
    }

    public ToDo getToDo(Long id){
        Optional<ToDo> res = toDoRepo.findById(id);
        return res.orElse(null);
    }

    public void addToDo(ToDo toDo){
        toDoRepo.save(toDo);
    }

    public void updateToDo(Long id, ToDo toDo){
        toDo.setId(id);
        toDoRepo.save(toDo);
    }

    public void deleteToDo(Long id){
        toDoRepo.delete(getToDo(id));
    }

    public List<ToDo> getToDosByUser(Long user_id){
        return toDoRepo.findByAuthorId(user_id);
    }
}
