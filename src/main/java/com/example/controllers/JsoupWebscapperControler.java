package com.example.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Article;
import com.example.services.JsoupWebScrapperSerivce;

@RestController
@RequestMapping("/api/news")
public class JsoupWebscapperControler {
	
	@Autowired
	private JsoupWebScrapperSerivce webScrapper;
	
	@GetMapping("/all")
	public List<Article> getArticles() throws IOException{
		
		return webScrapper.getResults();
		
	}

}
