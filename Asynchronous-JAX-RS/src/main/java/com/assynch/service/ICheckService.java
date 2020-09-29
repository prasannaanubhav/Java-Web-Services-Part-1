package com.assynch.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.assynch.model.CheckList;

@Path(value="/checkservice")
public interface ICheckService {
	
	@Path(value = "/processcheck")
	@POST
	public void processCheck(@Suspended AsyncResponse response,CheckList checkList);

}
