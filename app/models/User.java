package models;

import java.util.Date;

import javax.persistence.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.sun.jmx.snmp.Timestamp;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model {

	@Id
	@SequenceGenerator(name = "user_id", sequenceName = "id_seq")
	@GeneratedValue(generator = "user_id")
	public Long id;
	
	@Required
	@Column(unique=true)
	private String username;

	private String password;
	
	@Column(name = "created_at")
	@CreatedTimestamp
	public Date createdAt;

	@Column(name = "updated_at")
	@UpdatedTimestamp
	public Date updatedAt;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

}
