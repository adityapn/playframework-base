package controllers;

import play.mvc.Controller;

import org.codehaus.jackson.JsonNode;

import play.libs.Json;
import play.mvc.*;

public class Aditya extends Controller {

	public static Result index(String user) {
		Message msg = new Message();
		msg.setUser(user);
		msg.setMessage(user + " is my hero");
		return ok(Json.toJson(msg));
	}

	public static Result postData() {
		JsonNode json = request().body().asJson();
		Message msg = Json.fromJson(json, Message.class);
		return ok("user " + msg.getUser() + " msg " + msg.getMessage());
	}
}
