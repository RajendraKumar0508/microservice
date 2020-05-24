package com.telstra.codechallenge.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.adapter.SerachAdapter;
import com.telstra.codechallenge.adapter.response.SearchApiResponse;
import com.telstra.codechallenge.adapter.responseprocessor.SearchResponseProcessor;
import com.telstra.codechallenge.response.RepositoryResponse;
import com.telstra.codechallenge.response.UserResponse;




@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SerachAdapter serachAdapter;
	
	@Autowired
	SearchResponseProcessor searchResponseProcessor;

	@Override
	public List<RepositoryResponse> searchRepository(String q,String sort, String order) throws SearchException {
		
		SearchApiResponse searchApiResponse=this.serachAdapter.searchRepository(q, sort, order);
		
		List<RepositoryResponse>  repositoryResponseList=this.searchResponseProcessor.processSearchRepositoryResponse(searchApiResponse);
		
		return repositoryResponseList;
	}

	@Override
	public List<UserResponse> searchUser(String q,String sort, String order) throws SearchException {

		SearchApiResponse searchApiResponse=this.serachAdapter.searchUser(q, sort, order);		
		List<UserResponse>  userResponseList=this.searchResponseProcessor.processSearchUserResponse(searchApiResponse);
		
		return userResponseList;
	}
}
