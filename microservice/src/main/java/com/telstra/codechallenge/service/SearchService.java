package com.telstra.codechallenge.service;

import java.util.List;

import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.response.RepositoryResponse;
import com.telstra.codechallenge.response.UserResponse;

public interface SearchService {

	public List<RepositoryResponse> searchRepository(String q, String sort, String order) throws SearchException;

	public List<UserResponse> searchUser(String q, String sort, String order) throws SearchException;
}
