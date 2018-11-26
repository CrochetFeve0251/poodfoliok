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
import com.poodfoliok.model.SocialMedia;
import com.poodfoliok.service.SocialMediaService;

@Controller
@RequestMapping("/socialmedias")
public class SocialMediaController {

	private static final String MSG_SUCESS_INSERT = "SocialMedia inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "SocialMedia successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted SocialMedia successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SocialMediaService socialmediaService;

	@GetMapping
	public String index(Model model) {
		List<SocialMedia> all = socialmediaService.findAll();
		model.addAttribute("listSocialMedia", all);
		return "socialmedia/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			SocialMedia socialmedia = socialmediaService.findOne(id);
			model.addAttribute("socialmedia", socialmedia);
		}
		return "socialmedia/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute SocialMedia entity) {
		model.addAttribute("socialmedia", entity);
		return "socialmedia/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute SocialMedia entity, BindingResult result, RedirectAttributes redirectAttributes) {
		SocialMedia socialmedia = null;
		try {
			socialmedia = socialmediaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/socialmedias/" + socialmedia.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				SocialMedia entity = socialmediaService.findOne(id);
				model.addAttribute("socialmedia", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "socialmedia/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute SocialMedia entity, BindingResult result, RedirectAttributes redirectAttributes) {
		SocialMedia socialmedia = null;
		try {
			socialmedia = socialmediaService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/socialmedias/" + socialmedia.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				SocialMedia entity = socialmediaService.findOne(id);
				socialmediaService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/socialmedias/index";
	}

}
