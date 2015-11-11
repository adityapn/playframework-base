package controllers;

import java.util.List;

import com.avaje.ebean.Query;

import models.Question;
import models.User;
import play.*;
import play.libs.Json;
import play.mvc.*;

public class Application extends Controller {

	public static Result index() {
		List<User> users = User.find.fetch("username", "pnaditya").findList();
		if (users.size() == 0) {
			User user = new User();
			user.setUsername("pnaditya");
			user.setPassword("password");
			user.save();
			return ok(Json.toJson(user.find.all()));
		}
		return ok(Json.toJson(users));
	}

	public static Result all() {
		return ok(Json.toJson(User.find.all()));
	}

	public static Result question() {
		Question question = new Question();
		question.setQuestion("Who is Bill Burr?");
		question.setUser(User.find.byId((long) 1));
		question.save();
		return ok(Json.toJson(question));
	}

}