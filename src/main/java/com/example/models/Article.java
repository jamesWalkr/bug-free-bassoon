package com.example.models;

public class Article {
	
	private String title;
	
	private String url;

	public Article() {
		super();
	}

	public Article(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", url=" + url + "]";
	}
	
	

}
