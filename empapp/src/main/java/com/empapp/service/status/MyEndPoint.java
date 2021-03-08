package com.empapp.service.status;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "mytraining", enableByDefault = true)
public class MyEndPoint {
	@ReadOperation
	public MyEndPointResponse features() {
		return new MyEndPointResponse(4, "Java training", "Active ");
	}
}