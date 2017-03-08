package driver.oscar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import driver.oscar.model.Task;
import driver.oscar.dao.TaskRepository;

@Service
@Transactional
public class TaskService
{
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		tasks = (List<Task>) taskRepository.findAll();
		return tasks;
	}
	
	public void save(Task task){ 
		taskRepository.save(task);
	}
	
	public void delete(int id){
		taskRepository.delete(id);
	}

	public Task findTask(int id){
		return taskRepository.findOne(id);
	}
}
