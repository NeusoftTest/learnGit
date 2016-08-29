package com.web.neusoft.video.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.neusoft.test.model.Video;
import com.web.neusoft.test.service.IVideoMapperService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class VideoMapperServiceTest {

	@Resource
	private IVideoMapperService videoMaperService;
	
	@Test
	public void test(){
		int id = 1;
		Video video = videoMaperService.selectByPrimaryKey(id);
		System.out.println(video.getIntroduce());
	}
}
