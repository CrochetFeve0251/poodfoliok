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
import com.poodfoliok.model.School;
import com.poodfoliok.service.SchoolService;

@Controller
@RequestMapping("/schools")
public class SchoolController {

	private static final String MSG_SUCESS_INSERT = "School inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "School successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted School successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SchoolService schoolService;

	@GetMapping
	public String index(Model model) {
		List<School> all = schoolService.findAll();
		model.addAttribute("listSchool", all);
		return "school/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			School school = schoolService.findOne(id);
			model.addAttribute("school", school);
		}
		return "school/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute School entity) {
		model.addAttribute("school", entity);
		return "school/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute School entity, BindingResult result, RedirectAttributes redirectAttributes) {
		School school = null;
		try {
			school = schoolService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/schools/" + school.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				School entity = schoolService.findOne(id);
				model.addAttribute("school", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "school/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute School entity, BindingResult result, RedirectAttributes redirectAttributes) {
		School school = null;
		try {
			school = schoolService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/schools/" + school.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				School entity = schoolService.findOne(id);
				schoolService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/schools/index";
	}

}
