package com.surplus.task.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@javax.persistence.Entity
@Data
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int userDtlId;

	protected String userName;

	protected String fullName;

	protected String designation;

	protected String mobile;

	protected String primaryEmail;

	protected String company;

	protected String faxNo;

	protected String address;

	protected String city;

	protected String state;

	protected int pinCode;
	
//	@OneToOne(mappedBy="user")
//	protected User user;

	// @MapsId, which defines thatSecundus identifier will be determined by
	// Primus identifier,
	// and @JoinColumn, specifying which column in SECUNDUS table will be used
	// for joining.COMMENTING FOR THE TIME BEING
	/*@javax.persistence.OneToOne
	@MapsId
	@JoinColumn(name = "user_Id")
	protected User user;*/
	//foreign key
	

/*	public void basicSetUser(User myUser) {
		if (this.user != myUser) {
			if (myUser != null) {
				if (this.user != myUser) {
					User olduser = this.user;
					this.user = myUser;
					if (olduser != null)
						olduser.unsetUserDtls();
				}
			}
		}
	}*/



/*	public void unsetUser() {
		if (this.user == null)
			return;
		User olduser = this.user;
		this.user = null;
		olduser.unsetUserDtls();
	}*/

}
