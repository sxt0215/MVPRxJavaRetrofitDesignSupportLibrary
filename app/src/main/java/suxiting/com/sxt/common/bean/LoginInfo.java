package suxiting.com.sxt.common.bean;


public class LoginInfo extends BaseInfo{
	/**
	 * {"access_token":"e9277c9c32b04bf163248ac950655af4be033f2a11d611aec7b60f9fa7e419b5",
	 * "user":
	 * 		{"id":"ADA6919F-EEA0-4F2A-B269-40EC514FA5A0",
	 * 		"clientCode":"HTKG",
	 * 		"name":null,
	 * 		"loginName":"sxt001",
	 * 		"idNumber":null,
	 * 		"mobile":"15140105111",
	 * 		"email":"notavailable@creditcloud.com",
	 * 		"source":"WEB",
	 * 		"employeeId":null,
	 * 		"lastModifiedBy":null,
	 * 		"channel":null,
	 * 		"lastLoginDate":1472628362337,
	 * 		"registerDate":1472544028000,
	 * 		"enabled":true,"referralEntity":null,
	 * 		"enterprise":false,"registryRewarded":false,
	 * 		"referralRewarded":false,"groupId":null,"timeGroup":null,
	 * 		"status":"CREATED","priv":null,"normal":false,"englishName":null,
	 * 		"certificate":null,"type":null,"managerId":null,"boolInvest":false,
	 * 		"accountStatus":2},
	 * 	"client":
	 * 		{"name":"mobile","id":"client-id-for-mobile-dev"},
	 * 	"scope":[],"createdAt":1472628848016,"token_type":"Bearer"}
	 * */

	private String access_token;

	private User user;

	private Client client;

	private String[] scope;

	private String createdAt;

	private String token_type;

	private int accountStatus;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String[] getScope() {
		return scope;
	}

	public void setScope(String[] scope) {
		this.scope = scope;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

}
