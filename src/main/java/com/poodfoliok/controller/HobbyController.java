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
import com.poodfoliok.model.Hobby;
import com.poodfoliok.service.HobbyService;

@Controller
@RequestMapping("/hobbys")
public class HobbyController {

	private static final String MSG_SUCESS_INSERT = "Hobby inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Hobby successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Hobby successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private HobbyService hobbyService;

	@GetMapping
	public String index(Model model) {
		List<Hobby> all = hobbyService.findAll();
		model.addAttribute("listHobby", all);
		return "hobby/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Hobby hobby = hobbyService.findOne(id);
			model.addAttribute("hobby", hobby);
		}
		return "hobby/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Hobby entity) {
		model.addAttribute("hobby", entity);
		return "hobby/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Hobby entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Hobby hobby = null;
		try {
			hobby = hobbyService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/hobbys/" + hobby.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Hobby entity = hobbyService.findOne(id);
				model.addAttribute("hobby", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "hobby/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Hobby entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Hobby hobby = null;
		try {
			hobby = hobbyService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/hobbys/" + hobby.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Hobby entity = hobbyService.findOne(id);
				hobbyService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/hobbys/index";
	}

}
