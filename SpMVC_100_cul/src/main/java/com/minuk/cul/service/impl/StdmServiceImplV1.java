package com.minuk.cul.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.minuk.cul.config.ApiConfig;
import com.minuk.cul.config.QualifierConfig;
import com.minuk.cul.model.StdmVO;
import com.minuk.cul.model.root.GetStdm;
import com.minuk.cul.service.StdmService;
import com.minuk.cul.utils.HttpRequestInterceptorV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.STDM_V1)
public class StdmServiceImplV1 implements StdmService{

	@Override
	public String StdmQueryStr(String search) {
		
		String stdmQueryStr = ApiConfig.API_STDM_URL;
		String encodeParams = null;
		
		try {
			encodeParams += "?" + URLEncoder.encode("apiSrvCd","UTF-8");
			encodeParams += "=0034";
			
			encodeParams += "&" + URLEncoder.encode("pageNo","UTF-8");
			encodeParams += "=1";
			
			encodeParams += "&" + URLEncoder.encode("numOfRow","UTF-8");
			encodeParams += "=10";
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stdmQueryStr += encodeParams;
		log.debug("쿼리 문자열 {}", stdmQueryStr);
		
		return stdmQueryStr;
	}

	@Override
	public List<StdmVO> getStdmItems(String queryString) {
		
		URI stdmRestURI = null;
		
		try {
			stdmRestURI = new URI(queryString);
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
		resString = restTemp.exchange(stdmRestURI, HttpMethod.GET, headerEntity, String.class);
		
		log.debug("=".repeat(100));
		log.debug("{}",resString.getBody());
		log.debug("=".repeat(100));
		
		// 수신된 데이터를 VO 로 변환하기
		ResponseEntity<GetStdm> resStdmObject = null;
		
		// RestTemplate 이 수신한 데이터를 중간에 가로채서 조작하기
		restTemp.getInterceptors().add(new HttpRequestInterceptorV1());
		resStdmObject = restTemp.exchange(stdmRestURI, HttpMethod.GET, headerEntity, );
		
		log.debug("수신된 데이터 {}", resStdmObject.getBody().);
		
		return resStdmObject.getBody().;
	}

}
