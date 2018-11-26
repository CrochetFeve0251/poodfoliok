package com.poodfoliok.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.poodfoliok.model.Project;
import com.poodfoliok.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	private static final String MSG_SUCESS_INSERT = "Project inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Project successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Project successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public String index(Model model) {
		List<Project> all = projectService.findAll();
		model.addAttribute("listProject", all);
		return "project/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Project project = projectService.findOne(id);
			model.addAttribute("project", project);
		}
		return "project/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Project entity) {
		model.addAttribute("project", entity);
		return "project/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Project entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Project project = null;
		try {
			project = projectService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/projects/" + project.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Project entity = projectService.findOne(id);
				model.addAttribute("project", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "project/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Project entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Project project = null;
		try {
			project = projectService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/projects/" + project.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Project entity = projectService.findOne(id);
				projectService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/projects/index";
	}

}
