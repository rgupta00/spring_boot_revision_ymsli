package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.service.AccountService;

@Controller
@RequestMapping(path = "mgr")
public class TransactionController {

	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping(path = "transfer")
	public String transferGet(Model model) {
		model.addAttribute("transferDto", new TransferDto());
		return "transfer";
	}
	
	@PostMapping(path = "transfer")
	public String transferPost
	(@ModelAttribute(name = "transferDto")TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccountId(), transferDto.getToAccountId(),
				transferDto.getAmount());
		
		return "redirect:viewall";
	}
	
	
	
	@GetMapping(path = "deposit")
	public String depositGet(Model model) {
		model.addAttribute("depositDto", new DepositDto());
		return "deposit";
	}
	
	@PostMapping(path = "deposit")
	public String depositPost
	(@ModelAttribute(name = "depositDto")DepositDto transferDto) {
		accountService.deposit(transferDto.getAccountId(), transferDto.getAmount());
		
		return "redirect:viewall";
	}
	
	
	
	@GetMapping(path = "viewall")
	public String viewall() {
		return "viewall";
	}
	
}
