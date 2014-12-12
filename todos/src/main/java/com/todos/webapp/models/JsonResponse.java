package com.todos.webapp.models;

public class JsonResponse {
	 private String status = null;
     private User result = null;
     public String getStatus() {
             return status;
     }
     public void setStatus(String status) {
             this.status = status;
     }
     public User getResult() {
             return result;
     }
     public void setResult(User result) {
             this.result = result;
     }
}
