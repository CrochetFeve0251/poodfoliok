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
import com.poodfoliok.model.Skill;
import com.poodfoliok.service.SkillService;

@Controller
@RequestMapping("/skills")
public class SkillController {

	private static final String MSG_SUCESS_INSERT = "Skill inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Skill successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Skill successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private SkillService skillService;

	@GetMapping
	public String index(Model model) {
		List<Skill> all = skillService.findAll();
		model.addAttribute("listSkill", all);
		return "skill/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Skill skill = skillService.findOne(id);
			model.addAttribute("skill", skill);
		}
		return "skill/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Skill entity) {
		model.addAttribute("skill", entity);
		return "skill/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Skill entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Skill skill = null;
		try {
			skill = skillService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/skills/" + skill.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Skill entity = skillService.findOne(id);
				model.addAttribute("skill", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "skill/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Skill entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Skill skill = null;
		try {
			skill = skillService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/skills/" + skill.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Skill entity = skillService.findOne(id);
				skillService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/skills/index";
	}

}
