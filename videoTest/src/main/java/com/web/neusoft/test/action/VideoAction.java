package com.web.neusoft.test.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.neusoft.test.model.Video;
import com.web.neusoft.test.service.IVideoMapperService;

@Controller
@Scope(value="prototype")
public class VideoAction {

	@Resource
	private IVideoMapperService videoMaperService;
	
	@RequestMapping("/videoLs")
	public String videoList(Model model){

		int id = 1;
		Video video = videoMaperService.selectByPrimaryKey(id);
		model.addAttribute("video", video);
		return "index";
	}
}
