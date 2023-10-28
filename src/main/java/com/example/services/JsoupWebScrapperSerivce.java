 package com.example.services;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.models.Article;


@Service
public class JsoupWebScrapperSerivce {
	
public List<Article>getResults() throws IOException{
	
	String url = "https://www.vox.com/";
	
	Document doc = Jsoup.connect(url).get();
	
	Elements articles = doc.select(".c-entry-box--compact__title");
	
	List<Article> Articles =  new ArrayList<>();
	
	for(Element article: articles) {
		
		Article response = new Article();
		
		response.setTitle(article.selectFirst("h2").text());
		
		response.setUrl(article.select("h2 > a").attr("href"));
		
		Articles.add(response);
		
		//String title = article.select("h2 > a").text();
		//String urls = article.select("h2 > a").attr("href");
		//response.add(new Article());
		//response.add(urls);
	}
	return Articles;
	
	
	
	
		
	}

}
