package com.assynch.service;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.assynch.model.CheckList;
import com.assynch.service.ICheckService;

@Service
public class CheckServiceImpl implements ICheckService {

	@Override
	public void processCheck(AsyncResponse response, CheckList checkList) {
		new Thread() {
			public void run() {
				response.resume(true);
			}
		}.start();

	}

}
