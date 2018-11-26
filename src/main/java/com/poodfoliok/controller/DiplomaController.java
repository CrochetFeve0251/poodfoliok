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
import com.poodfoliok.model.Diploma;
import com.poodfoliok.service.DiplomaService;

@Controller
@RequestMapping("/diplomas")
public class DiplomaController {

	private static final String MSG_SUCESS_INSERT = "Diploma inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Diploma successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Diploma successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private DiplomaService diplomaService;

	@GetMapping
	public String index(Model model) {
		List<Diploma> all = diplomaService.findAll();
		model.addAttribute("listDiploma", all);
		return "diploma/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Diploma diploma = diplomaService.findOne(id);
			model.addAttribute("diploma", diploma);
		}
		return "diploma/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Diploma entity) {
		model.addAttribute("diploma", entity);
		return "diploma/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Diploma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Diploma diploma = null;
		try {
			diploma = diplomaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/diplomas/" + diploma.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Diploma entity = diplomaService.findOne(id);
				model.addAttribute("diploma", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "diploma/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Diploma entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Diploma diploma = null;
		try {
			diploma = diplomaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/diplomas/" + diploma.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Diploma entity = diplomaService.findOne(id);
				diplomaService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/diplomas/index";
	}

}
