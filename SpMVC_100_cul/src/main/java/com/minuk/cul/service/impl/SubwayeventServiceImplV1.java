//package com.minuk.cul.service.impl;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.LaxRedirectStrategy;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.minuk.cul.config.ApiConfig;
//import com.minuk.cul.config.QualifierConfig;
//import com.minuk.cul.model.SubwayEventVO;
//import com.minuk.cul.service.SubwayeventService;
//import com.minuk.cul.utils.HttpRequestInterceptorV1;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service(QualifierConfig.SERVICE.SUBWAYEVENT_V1)
//public class SubwayeventServiceImplV1 implements SubwayeventService{
//
//	@Override
//	public String SubwayeventQueryStr(String search) {
//		
//		String subwayeventQueryStr = ApiConfig.API_SUBWAYEVENT_URL;
//		String encodeParams = null;
//		
//		try {
//			encodeParams = "?" + URLEncoder.encode("rbsIdx","UTF-8");
//			encodeParams += "=318"; // 프로그램ID 고정값
//			
//			encodeParams += "&" + URLEncoder.encode("doctype","UTF-8");
//			encodeParams += "=json"; // 문서형식
//			
//			encodeParams += "&" + URLEncoder.encode("listcount","UTF-8");
//			encodeParams += "=50"; // 목록개수 최근 50개 목록 요청 가능
//			
//			encodeParams += "&" + URLEncoder.encode("month","UTF-8");
//			encodeParams += "=201511"; // 행사월 ex)년월
//
//			encodeParams += "&" + URLEncoder.encode("eventtype","UTF-8");
//			encodeParams += "=99"; // 행사종류: 99 = 전시, 100 = 공연
//			
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		subwayeventQueryStr += encodeParams;
//		log.debug("쿼리 문자열 {}", subwayeventQueryStr);
//		
//		return subwayeventQueryStr;
//	}
//
//	@Override
//	public List<SubwayEventVO> getSubwayeventItems(String queryString) {
//		
//		URI SubwayEventRestURI = null;
//		
//		try {
//			SubwayEventRestURI = new URI(queryString);
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// API 에 JSON type 으로 데이터를 요청하기 위한 헤더 생성
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity<String> headerEntity = new HttpEntity<String>("parameter",headers);
//		
//		// 데이터를 수신하여 VO 로 변환하기 위한 객체 선언
//		RestTemplate restTemp = new RestTemplate();
//		
//		// String type 으로 데이터를 수신하여 어떤형태로
//		// 데이터가 수신되는지 확인하는 절차
//		ResponseEntity<String> resString = null;
//		
//		restTemp.getInterceptors().add(new HttpRequestInterceptorV1());
//		
//		// RestTemplate 로 데이터를 불러올때 302 인 경우 해당페이지로 리다이렉트 되지 않는다.
//		// 해당페이지를 리다이렉트 시키기 위해 Apache HttpClient 와 아래 코드가 필요하다.
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//		CloseableHttpClient httpClient = HttpClientBuilder.create()
//		        .setRedirectStrategy(new LaxRedirectStrategy())
//		        .build();
//		factory.setHttpClient(httpClient);
//		restTemp.setRequestFactory(factory);
//		// ---------------------------------------------------------------------------------
//		resString = restTemp.exchange(SubwayEventRestURI, HttpMethod.GET, null, String.class);
//		
//		log.debug("=".repeat(100));
//		log.debug("asdfasdf {}",resString);
//		log.debug("=".repeat(100));
//		
//		// 수신된 데이터를 VO 로 변환하기
//		ResponseEntity<SubwayEventVO> resSubwayEventObject = null;
//		
//		// RestTemplate 이 수신한 데이터를 중간에 가로채서 조작하기
////		resSubwayEventObject = restTemp.exchange(SubwayEventRestURI, HttpMethod.GET, headerEntity);
//		
////		log.debug("수신된 데이터 {}", resSubwayEventObject.getBody());
//		
//		return null;
//	}
//
//}
