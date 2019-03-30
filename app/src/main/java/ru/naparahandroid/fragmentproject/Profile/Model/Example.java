package ru.naparahandroid.fragmentproject.Profile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
	
	@SerializedName("birthday")
	@Expose
	private Birthday birthday;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("first_name")
	@Expose
	private String firstName;
	@SerializedName("last_name")
	@Expose
	private String lastName;
	@SerializedName("notify_about_orders_by_email")
	@Expose
	private Boolean notifyAboutOrdersByEmail;
	@SerializedName("type")
	@Expose
	private String type;
	
	public Example( Birthday birthday , String email , String firstName , String lastName , Boolean notifyAboutOrdersByEmail , String type ) {
		this.birthday = birthday;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
		this.type = type;
	}
	
	public Birthday getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Boolean getNotifyAboutOrdersByEmail() {
		return notifyAboutOrdersByEmail;
	}
	
	public void setNotifyAboutOrdersByEmail(Boolean notifyAboutOrdersByEmail) {
		this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString( ) {
		return "Example{" +
				"birthday=" + birthday +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", notifyAboutOrdersByEmail=" + notifyAboutOrdersByEmail +
				", type='" + type + '\'' +
				'}';
	}
}
