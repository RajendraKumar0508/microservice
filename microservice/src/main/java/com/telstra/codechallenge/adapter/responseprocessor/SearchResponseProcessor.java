package com.telstra.codechallenge.adapter.responseprocessor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.telstra.codechallenge.adapter.response.SearchApiResponse;
import com.telstra.codechallenge.response.RepositoryResponse;
import com.telstra.codechallenge.response.UserResponse;

@Component
public class SearchResponseProcessor {

	public List<RepositoryResponse> processSearchRepositoryResponse(SearchApiResponse searchResponse) {

		List<RepositoryResponse> repositoryResonseList = null;
		if (searchResponse != null && !CollectionUtils.isEmpty(searchResponse.getItems())) {

			repositoryResonseList = searchResponse.getItems().stream().map(x -> {
				RepositoryResponse resonse = new RepositoryResponse();
				resonse.setHtml_url(x.getHtml_url());
				resonse.setWatchers_count(x.getWatchers_count());
				resonse.setLanguage(x.getLanguage());
				resonse.setDescription(x.getDescription());
				resonse.setName(x.getName());
				return resonse;
			}).collect(Collectors.toList());

		}

		return repositoryResonseList;
	}

	public List<UserResponse> processSearchUserResponse(SearchApiResponse searchResponse) {

		List<UserResponse> userResponseList = null;
		userResponseList = searchResponse.getItems().stream().map(x -> {
			UserResponse resonse = new UserResponse();
			resonse.setHtml_url(x.getHtml_url());
			resonse.setId(x.getId());
			resonse.setLogin(x.getLogin());
			return resonse;
		}).collect(Collectors.toList());

		return userResponseList;

	}

}
