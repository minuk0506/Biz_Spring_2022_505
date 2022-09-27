package com.minuk.a.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.minuk.a.config.config;
import com.minuk.a.model.AVO;
import com.minuk.a.service.AService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AServiceImpl implements AService{

	@Override
	public String AQueryStr(String queryStr) {
		String AQueryString = config.API_MSMARTGLR_URL;
		String encodeParams = null;
		
		try {
			encodeParams = "?" + URLEncoder.encode("serviceKey","UTF-8");
			encodeParams += "=" + config.SERVICE_KEY;
			encodeParams += "&" + URLEncoder.encode("type","UTF-8");
			encodeParams += "=json";
		} catch (UnsupportedEncodingException e) {
			log.debug("쿼리예외발생");
			e.printStackTrace();
		}
		AQueryString += encodeParams;
		log.debug(" 쿼리 문자열 {}",AQueryString);
		
		return AQueryString;
	}

	@Override
	public List<AVO> getAItems(String queryStr) {
		
		try {
			URI ARestURI = new URI(queryStr);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		log.debug("헤더 {}",headers.toString());
		HttpEntity<String> headerEntity = new HttpEntity<String>("parameter",headers);
		log.debug("헤더 엔티티 {}",headerEntity.toString());
		RestTemplate restTemp = new RestTemplate();
		
		return null;
	}

}
