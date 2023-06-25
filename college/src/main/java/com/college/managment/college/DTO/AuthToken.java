package com.college.managment.college.DTO;

public class AuthToken {
	   private String token;
	   
	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }
	    public AuthToken(){

	    }
	    public AuthToken(String token){
	        this.token = token;
	    }
}
