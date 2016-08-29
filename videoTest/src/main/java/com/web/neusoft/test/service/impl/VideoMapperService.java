package com.web.neusoft.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.neusoft.test.dao.VideoMapper;
import com.web.neusoft.test.model.Video;
import com.web.neusoft.test.service.IVideoMapperService;

@Service("videoMaperService")
public class VideoMapperService implements IVideoMapperService {

	@Resource
	private VideoMapper videoMapper;
	
	@Override
	public Video selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
//		Object[] a = new Object[5];
//		Arrays.sort(a);;
		return videoMapper.selectByPrimaryKey(id);
	}

}
