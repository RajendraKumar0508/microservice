package com.telstra.codechallenge.adapter.response;

import java.util.List;

import com.telstra.codechallenge.adapter.domain.Item;

public class SearchApiResponse {

	private List<Item> items;

	public SearchApiResponse() {
		super();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
