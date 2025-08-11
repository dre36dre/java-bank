package com.br.dre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.br.dre.model.Client;
import com.br.dre.repository.ClientRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	

	@GetMapping	
	public String toList(Model model  ) {
		model.addAttribute("clients", clientRepository.findAll());
		return "index";
	}
	
	@GetMapping("/new")
	public String newForm(Model model) {
		model.addAttribute("client", new Client());
		return "form";
	}
	
	@PostMapping("/save")
	public String toSave(@ModelAttribute Client client) {
		clientRepository.save(client);
		return "redirect:/clients";
	}
	
	@GetMapping("/edit/{id}")
	public String editarForm(@PathVariable Long id, Model model) {
		Client client = (Client) clientRepository.findById(id).orElseThrow();
		model.addAttribute("client",client);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return "redirect:/clients";
	}
	
}
