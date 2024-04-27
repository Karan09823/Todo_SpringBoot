
package com.example.TODOSPRINGBOOT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TODOSPRINGBOOT.model.ToDo;
import com.example.TODOSPRINGBOOT.repo.TodoRepoInterface;
import com.example.TODOSPRINGBOOT.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private TodoRepoInterface tdr;

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/addTodoItem")
	public String AddTodoItem() {
		return "AddToDoItem";
	}

	@PostMapping("/saveTodo")
	public String SaveToDo( @ModelAttribute ToDo td) {
	
		tdr.save(td);
		return "redirect:/addTodoItem";
	}
	
	@GetMapping("/viewTodoList")
	public ModelAndView ViewTodoItem(Model model) {
		List<ToDo> list=tdr.findAll();
		return new ModelAndView("ViewToDoItem","TodoList",list);
	}
	
	@GetMapping("/editTodo/{id}")
	public String EditToDo(@PathVariable("id")Long todoId,Model model) {
		ToDo TempTd=tdr.findById(todoId).get();
		model.addAttribute("EditTodoId", TempTd.getId());
		model.addAttribute("EditTdDesc", TempTd.getDescription());
		model.addAttribute("createdDate", TempTd.getCreatedDate());
		model.addAttribute("completionDateEdit", TempTd.getCompletionDate());
		model.addAttribute("EditStatus", TempTd.isCompleted());
		return "EditToDoItem";
		
	}
	
	@PostMapping("/saveEditTodo")
	public String SaveEditToDO(@ModelAttribute ToDo editedTodo) {
		
		tdr.save(editedTodo);
		
		return"redirect:/viewTodoList";
	}
	
	@GetMapping("/deleteTodo/{id}")
	public String DeleteToDoItem(@PathVariable("id") Long delId) {
		tdr.deleteById(delId);
		return "redirect:/viewTodoList";
	}
	
}
