package com.telstra.codechallenge.adapter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.telstra.codechallenge.Exception.SearchException;
import com.telstra.codechallenge.adapter.domain.Item;
import com.telstra.codechallenge.adapter.response.SearchApiResponse;
import com.telstra.codechallenge.adapter.responseprocessor.SearchResponseProcessor;
import com.telstra.codechallenge.response.RepositoryResponse;
import com.telstra.codechallenge.response.UserResponse;

public class SearchAdapterTest {

	@InjectMocks
	SearchAdapterImpl searchAdapterImpl;

	@Mock
	SearchResponseProcessor searchResponseProcessor;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(searchAdapterImpl, "seachRepoistryBaseUrl",
				"https://api.github.com/search/repositories?");
		ReflectionTestUtils.setField(searchAdapterImpl, "seachUserBaseUrl", "https://api.github.com/search/users?");
	}

	@Test
	public void testSearchReposity() throws SearchException {
		String q = "tetris+language:java";
		String sort = "tetris+language:java";
		String order = "tetris+language:java";

		RepositoryResponse repositoryResponse = new RepositoryResponse();
		repositoryResponse.setLanguage("java");
		List<RepositoryResponse> reporespList = new ArrayList<RepositoryResponse>();
		reporespList.add(repositoryResponse);

		SearchApiResponse searchApiResponse = new SearchApiResponse();
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setLanguage("java");
		items.add(item);
		searchApiResponse.setItems(items);
		Mockito.when(this.searchResponseProcessor.processSearchRepositoryResponse(searchApiResponse))
				.thenReturn(reporespList);
		SearchApiResponse apiResponse = this.searchAdapterImpl.searchRepository(q, sort, order);
		Assert.assertNotNull(apiResponse);

	}

	@Test
	public void testSearchUser() throws SearchException {
		String q = "tetris+language:java";
		String sort = "tetris+language:java";
		String order = "tetris+language:java";

		UserResponse userResponse = new UserResponse();
		userResponse.setLogin("java");
		List<UserResponse> userrespList = new ArrayList<UserResponse>();
		userrespList.add(userResponse);

		SearchApiResponse searchApiResponse = new SearchApiResponse();
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setLanguage("java");
		items.add(item);
		searchApiResponse.setItems(items);
		Mockito.when(this.searchResponseProcessor.processSearchUserResponse(searchApiResponse))
				.thenReturn(userrespList);
		SearchApiResponse apiResponse = this.searchAdapterImpl.searchUser(q, sort, order);
		Assert.assertNotNull(apiResponse);

	}

}
