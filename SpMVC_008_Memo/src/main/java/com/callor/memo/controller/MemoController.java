package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	
	@RequestMapping(value="/insert",method = RequestMethod.GET)
	public String insert(Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		MemoVO memoVO = MemoVO.builder()
						.m_date(dayFormat.format(date))
						.m_time(timeFormat.format(date))
						.build();
		
		model.addAttribute("memo",memoVO);
		return "memo/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(MemoVO memoVO, MultipartFile file, Model model){
		memoService.insertFile(memoVO, file);
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail/{m_seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("m_seq") String seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		log.debug("시퀀스값",seq);
		model.addAttribute("memo", memoVO);
		return "memo/detail";
	}
	
	@RequestMapping(value="/{m_seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("m_seq") String seq, Model model) {
		memoService.findById(seq);
		return "memo/update";
	}
	
	@RequestMapping(value="/{m_seq}/update", method=RequestMethod.POST)
	public String update(MemoVO memoVO) {
		int ret = memoService.update(memoVO);
		String retStr = String.format("redirect:/memo/detail/%s", memoVO.getM_seq());
		return retStr;
	}
	
	@RequestMapping(value="/{m_seq}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("m_seq") String seq) {
		memoService.delete(seq);
		return "redirect:/";
	}
	
}
