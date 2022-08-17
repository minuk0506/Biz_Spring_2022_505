package com.minuk.cul.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.minuk.cul.config.ApiConfig;
import com.minuk.cul.config.QualifierConfig;
import com.minuk.cul.model.TourRoot;
import com.minuk.cul.model.TourVO;
import com.minuk.cul.service.TourService;
import com.minuk.cul.utils.HttpRequestInterceptorV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.TOUR_V1)
public class TourServiceImplV1 implements TourService{

	@Override
	public String queryString(String search) {
		
		String queryString = ApiConfig.API_FULL_URL;
		String encodeParams = null;
		
		try {
			encodeParams = "?" + URLEncoder.encode("serviceKey","UTF-8");
			encodeParams += "=" + ApiConfig.SERVICE_KEY;
			
			encodeParams += "&" + URLEncoder.encode("pageNo","UTF-8");
			encodeParams += "=1";
			
			encodeParams += "&" + URLEncoder.encode("numOfRows","UTF-8");
			encodeParams += "=10";
			
			encodeParams += "&" + URLEncoder.encode("resultType","UTF-8");
			encodeParams += "=json";
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		queryString += encodeParams;
		log.debug("쿼리 문자열 {}", queryString);
		
		return queryString;
	}

	@Override
	public List<TourVO> getTourItems(String queryString) {
		
		URI foodRestURI = null;
		
		try {
			foodRestURI = new URI(queryString);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// API 에 JSON type 으로 데이터를 요청하기 위한 헤더 생성
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> headerEntity = new HttpEntity<String>("parameter",headers);
		
		// 데이터를 수신하여 VO 로 변환하기 위한 객체 선언
		RestTemplate restTemp = new RestTemplate();
		
		// String type 으로 데이터를 수신하여 어떤형태로
		// 데이터가 수신되는지 확인하는 절차
		ResponseEntity<String> resString = null;
		resString = restTemp.exchange(foodRestURI, HttpMethod.GET, headerEntity, String.class);
		
		log.debug("=".repeat(100));
		log.debug("{}",resString.getBody());
		log.debug("=".repeat(100));
		
		// 수신된 데이터를 VO 로 변환하기
		ResponseEntity<TourRoot> resFoodObject = null;
		
		// 2번째 방법
		// 인터페이스를 사용하여 객체 생성하기
		// 한번만 사용하고 버릴 클래스 인스턴스 만들기
		ClientHttpRequestInterceptor httpIntercept = new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		// 3번째 방법
		// 익명(무명) 클래스를 사용하여 객체 주입하기
		restTemp.getInterceptors().add(new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				ClientHttpResponse response = execution.execute(request, body);
				response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
				return response;
			}
		});
		
		// 4번째 방법
		// java 1.8 이상에서 사용하는 Lambda 코드
		// 인터페이스를 사용하여 Lambda 코드로 주입하기
		// 익명(무명)클래스, 익명(무명)메서드 방식 
		restTemp.getInterceptors().add((request,body,execution)->{
			
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			
			return response;
		});
		
		// RestTemplate 이 수신한 데이터를 중간에 가로채서 조작하기
		restTemp.getInterceptors().add(new HttpRequestInterceptorV1());
		resFoodObject = restTemp.exchange(foodRestURI, HttpMethod.GET, headerEntity, TourRoot.class);
		
		log.debug("수신된 데이터 {}", resFoodObject.getBody().getTourKr.item);
		
		return resFoodObject.getBody().getTourKr.item;
	}

}
