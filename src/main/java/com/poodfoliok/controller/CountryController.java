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
import com.poodfoliok.model.Country;
import com.poodfoliok.service.CountryService;

@Controller
@RequestMapping("/countrys")
public class CountryController {

	private static final String MSG_SUCESS_INSERT = "Country inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Country successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Country successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CountryService countryService;

	@GetMapping
	public String index(Model model) {
		List<Country> all = countryService.findAll();
		model.addAttribute("listCountry", all);
		return "country/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Country country = countryService.findOne(id);
			model.addAttribute("country", country);
		}
		return "country/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Country entity) {
		model.addAttribute("country", entity);
		return "country/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Country entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Country country = null;
		try {
			country = countryService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/countrys/" + country.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Country entity = countryService.findOne(id);
				model.addAttribute("country", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "country/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Country entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Country country = null;
		try {
			country = countryService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/countrys/" + country.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Country entity = countryService.findOne(id);
				countryService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/countrys/index";
	}

}
