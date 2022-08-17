package com.callor.food.utils;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HttpRequestInterceptorV1 implements ClientHttpRequestInterceptor{

	// 1번째 방법
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		ClientHttpResponse response = execution.execute(request, body);
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		
		return response;
	}

	
	
}
