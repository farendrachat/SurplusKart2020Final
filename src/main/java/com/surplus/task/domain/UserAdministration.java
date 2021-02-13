
package com.surplus.task.domain;

import javax.persistence.Id;

@javax.persistence.Entity
public class UserAdministration {

	@Id
	@javax.persistence.Column(nullable = false)
	protected int userAdministrationId;

	@javax.persistence.Column(nullable = false)
	protected int infoId;

	@javax.persistence.Column(nullable = false)
	protected String introducedBy;

	@javax.persistence.Column(nullable = false)
	protected String reference;

	@javax.persistence.Column(nullable = false)
	protected String approvedBy;

	@javax.persistence.Column(nullable = false)
	protected String entered_By;

	@javax.persistence.Column(nullable = false)
	protected String payTerms;

	@javax.persistence.Column(nullable = false)
	protected String turnOverLimit;

	// @javax.persistence.OneToOne(mappedBy = "adminUser")
	/*@OneToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_Id") // use this if any problem
	// This maps the UserAdministration id value with that of User id value.This
	// way, the id column serves as both Primary Key and FK.
	@MapsId
	protected User user;*/

		
	//foreign key
	protected int userId;

/*	public void basicSetUser(User myUser) {
		if (this.user != myUser) {
			if (myUser != null) {
				if (this.user != myUser) {
					User olduser = this.user;
					this.user = myUser;
					if (olduser != null)
						olduser.unsetAdminUser();
				}
			}
		}
	}*/

	

}
