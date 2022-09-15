package com.todolist.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.todolist.demo.service.ToDoService;
import com.todolist.demo.entity.ToDo;

import java.util.List;

@RestController
public class ToDoController {
    private final ToDoService toDoService;                           

    public ToDoController(ToDoService toDoService) { 
        this.toDoService = toDoService;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/toDos/{id}")                                 
    public ToDo getToDo(@PathVariable Long id) {              
        return toDoService.getToDo(id);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/toDos")                                      
    public List<ToDo> getToDos() {             
        return toDoService.getToDos();
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "/toDos")
    public void addTodo(@RequestBody ToDo toDo) {
        toDoService.addToDo(toDo);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/toDos/{id}")
    public void updateToDo(@PathVariable Long id, @RequestBody ToDo toDo){
        toDoService.updateToDo(id, toDo);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = "/toDos/{id}")
    public void deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/toDos/user/{user_id}")
    public List<ToDo> getToDosByUser(@PathVariable Long user_id){
        return toDoService.getToDosByUser(user_id);
    }

}
