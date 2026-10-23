package com.app.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todo.models.Task;
import com.app.todo.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	public void createTask(String title) {
		// TODO Auto-generated method stub
		Task task=new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskRepository.save(task);
		
		
	}

	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
		
	}

	public void toggleTask(Long id) {
		// TODO Auto-generated method stub
		//this method will find the task by id get the task by id from database
		//it will update completion state so it will reverse the completion status
		Task task = taskRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
		
		
	}

}
