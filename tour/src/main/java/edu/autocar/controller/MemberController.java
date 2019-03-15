package edu.autocar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;
import edu.autocar.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("admin/member")
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/list")
	public void list(Model model, 
			@RequestParam(value="page", defaultValue="1")int page) throws Exception{
		PageInfo<Member> pi = service.getList(page);
		log.info(pi.toString());
		model.addAttribute("pi", pi);
	}
	
	@GetMapping("/create")
	public void getCreate(Member member) throws Exception{
	}
	
	@PostMapping("/create")
	public String postCreate(Member member) throws Exception{
		service.create(member);
		return "redirect:list";
	}
}
