package com.empapp.service.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MyEndPointResponse {
	private int id;
	private String name;
	private String status;
}

