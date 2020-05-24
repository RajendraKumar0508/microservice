package com.telstra.codechallenge.adapter;

import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.adapter.response.SearchApiResponse;

public interface SerachAdapter {
	SearchApiResponse searchRepository(String q, String sort, String order) throws SearchException;

	SearchApiResponse searchUser(String q, String sort, String order) throws SearchException;
}
