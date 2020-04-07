package com.client;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.entity.Items;;
public class RestClientUtil {
    public void getArticleByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/article/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Items> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Items.class, 1);
        Items oItems = responseEntity.getBody();
        System.out.println("name:"+oItems.getItems_name()+", Email:"+oItems.getEmail()
                 +", Id:"+oItems.getItems_id());      
    }
    
    public void getAllArticlesDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/articles";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Items[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Items[].class);
        Items[] articles = responseEntity.getBody();
        for(Items article : articles) {
              System.out.println("Id:"+article.getItems_id()+", name:"+article.getItems_name()
                      +", Email: "+article.getEmail());
        }
    }
   
    
    public void addArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/article";
	Items objArticle = new Items();
	objArticle.setEmail("Spring REST Security using Hibernate");
	objArticle.setItems_name(objArticle.getItems_name());
        HttpEntity<Items> requestEntity = new HttpEntity<Items>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    public void updateArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/article";
	Items objArticle = new Items();
	objArticle.setEmail(objArticle.getEmail());
	objArticle.setItems_id(objArticle.getItems_id());
	objArticle.setItems_name(objArticle.getItems_name());
        HttpEntity<Items> requestEntity = new HttpEntity<Items>(objArticle, headers);
        restTemplate.put(url, requestEntity);
    }
    
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/article/{id}";
        HttpEntity<Items> requestEntity = new HttpEntity<Items>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
    	util.getAllArticlesDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }    
} 