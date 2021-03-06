package com.suthan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suthan.dto.Contact;
//import com.suthan.entity.ContactEntity;
import com.suthan.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value={"/","/addContact"} )
	public String loadForm(Model model) {
		
			Contact c = new Contact();
			model.addAttribute("contact",c);
			return "contactinfo";
	}
	
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute Contact contact,Model model) {
		Integer id = contactService.saveContact(contact);
		// String orinalpwd=user.getPwd();
		model.addAttribute("message", "Contact" + id + "saved");
		return "contactinfo";
		
	}
	
	@GetMapping("/viewContacts")
	public String handleViewConactList(Model model) {
		List<Contact> contactList=contactService.getAllContacts();
		
		model.addAttribute("contacts",contactList);
		
		return "viewContacts";
		
	}
	
	@RequestMapping("/editContract")
	public String editContactform(@RequestParam("cid")Integer contactId,Model model) {
		Contact c =contactService.getContactById(contactId);
		model.addAttribute("contact",c);
		return "contactinfo";
		
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContactDetails(@RequestParam("cid")Integer contactId) {
		
		boolean isDeleted =contactService.deleteContact(contactId);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return null;
		
		
	}
	
	

}
