package com.telstra.codechallenge.adapter.domain;

public class Item {

	private String html_url;
	private Integer watchers_count;
	private String language;
	private String description;
	private String name;
	private String created;
	private String login;
	private Integer id;

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public Integer getWatchers_count() {
		return watchers_count;
	}

	public void setWatchers_count(Integer watchers_count) {
		this.watchers_count = watchers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
