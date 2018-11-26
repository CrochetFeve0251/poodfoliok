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
import com.poodfoliok.model.Company;
import com.poodfoliok.service.CompanyService;

@Controller
@RequestMapping("/companys")
public class CompanyController {

	private static final String MSG_SUCESS_INSERT = "Company inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Company successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Company successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public String index(Model model) {
		List<Company> all = companyService.findAll();
		model.addAttribute("listCompany", all);
		return "company/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Company company = companyService.findOne(id);
			model.addAttribute("company", company);
		}
		return "company/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Company entity) {
		model.addAttribute("company", entity);
		return "company/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Company entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Company company = null;
		try {
			company = companyService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/companys/" + company.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Company entity = companyService.findOne(id);
				model.addAttribute("company", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "company/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Company entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Company company = null;
		try {
			company = companyService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/companys/" + company.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Company entity = companyService.findOne(id);
				companyService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/companys/index";
	}

}
