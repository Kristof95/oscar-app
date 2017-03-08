package driver.oscar.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import driver.oscar.model.Task;
import driver.oscar.service.TaskService;


@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	private TaskService taskService;

//	@GetMapping("/hello")
//	public String hello(){
//		return "Hello World!!!";
//	}
//
//	@GetMapping("/all-tasks")
//	private String allTasks(){
//		return taskService.findAll().toString();
//	}
//
//	@GetMapping("/save-task")
//   public String saveTask(@RequestParam String name, @RequestParam String description,
//		   @RequestParam String date, @RequestParam String from, @RequestParam String to) throws ParseException
//	{
//		Task newTask = new Task(name, description, stringConvertSqlTimestamp(date), from, to);
//		System.out.println(newTask.toString());
//		taskService.save(newTask);
//	    return "Task saved!";
//   }

}
