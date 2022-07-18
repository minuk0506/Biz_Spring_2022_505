package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.service.impl.AddressServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	// Controller 와 Service 연결하기
	private AddressServiceImplV1 addrSerV1;
	public HomeController(AddressServiceImplV1 addrSerV1) {
		this.addrSerV1 = addrSerV1;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<AddressVO> vo = addrSerV1.selectAll();
		model.addAttribute("DATAS", vo);
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO vo) {
		addrSerV1.insert(vo);
		return "redirect:/";
	}
	// 요청 http://localhost:8080/address/detail?seq=3
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String detail(@RequestParam("seq") String strSeq) {
//		log.debug("요청받은 seq 값 {}",strSeq);
//		Long a_seq = Long.valueOf(strSeq);
//		log.debug("SEQ {}", a_seq);
//		addrSerV1.findById(a_seq);
//		return "detail";
//	}
	
	// 숫자형 매개변수를 사용하면서 
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		log.debug("SEQ {}", a_seq);
		AddressVO vo = addrSerV1.findById(a_seq);
		log.debug("findById seq {}", vo.toString());
		model.addAttribute("DATA", vo);
		return "detail";
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.GET)
	public String update(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		AddressVO vo = addrSerV1.findById(a_seq);
		model.addAttribute("ADDR",vo);
		return "home";	
	}
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String update(AddressVO vo) {
		addrSerV1.update(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq) {
		AddressVO vo = addrSerV1.findById(a_seq);
		addrSerV1.delete(a_seq);
		return "redirect:/";
	}
}