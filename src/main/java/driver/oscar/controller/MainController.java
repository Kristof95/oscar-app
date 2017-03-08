package driver.oscar.controller;

import driver.oscar.model.Task;
import driver.oscar.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController
{
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}

	@GetMapping("/all-journeys")
	public String allJourney(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_JOURNEYS");
		return "index";
	}

	@GetMapping("/new-journey")
	public String newJourney(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}

	@PostMapping("/save-journey")
	public String saveJourney(@ModelAttribute @Valid Task task, BindingResult bindingResult,HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_JOURNEYS");
		return "index";
	}

	@GetMapping("/update-journey")
	public String updateJourney(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}

	@GetMapping("/delete-journey")
	public String deleteJourney(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode","MODE_JOURNEYS");
		return "index";
	}
}
