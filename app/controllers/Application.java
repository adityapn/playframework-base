package controllers;

import models.Question;
import models.User;
import play.*;
import play.libs.Json;
import play.mvc.*;


public class Application extends Controller {
  
  public static Result index() {	  
	  User user = new User();	  
	  user.setUsername("pnaditya");
	  user.setPassword("password");	  
	  user.save();
	  return ok(Json.toJson(user.find.all()));
  }
  
  public static Result all(){
	  return ok(Json.toJson(User.find.all()));
  }
  
  public static Result question(){
	  Question question = new Question();
	  question.setQuestion("Who is Bill Burr?");	  
	  question.setUser(User.find.byId((long)1));
	  question.save();
	  return ok(Json.toJson(question));	  
  }
  
}