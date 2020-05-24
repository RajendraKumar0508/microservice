package com.telstra.codechallenge.adapter;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.adapter.response.SearchApiResponse;

@Component
public class SearchAdapterImpl implements SerachAdapter {

	@Value("${seachrepoistry.base.url}")
	private String seachRepoistryBaseUrl;

	@Value("${seachuser.base.url}")
	private String seachUserBaseUrl;

	@Override
	public SearchApiResponse searchRepository(String q, String sort, String order) throws SearchException {

		SearchApiResponse searchApiResponse = new SearchApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(seachRepoistryBaseUrl).queryParam("q", q)
				.queryParam("sort", sort).queryParam("order", order);
		RestTemplate restTemplate = new RestTemplate();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<SearchApiResponse> result = restTemplate.exchange(builder.buildAndExpand().toUri(),
				HttpMethod.GET, entity, SearchApiResponse.class);
		if (result.getStatusCode().equals(HttpStatus.OK)) {
			searchApiResponse = result.getBody();
		}

		return searchApiResponse;
	}

	@Override
	public SearchApiResponse searchUser(String q, String sort, String order) throws SearchException {

		SearchApiResponse searchResponse = new SearchApiResponse();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(seachUserBaseUrl).queryParam("q", q)
				.queryParam("sort", sort).queryParam("order", order);
		RestTemplate restTemplate = new RestTemplate();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<SearchApiResponse> result = restTemplate.exchange(builder.buildAndExpand().toUri(),
				HttpMethod.GET, entity, SearchApiResponse.class);
		if (result.getStatusCode().equals(HttpStatus.OK)) {
			searchResponse = result.getBody();
		}

		return searchResponse;
	}

}
