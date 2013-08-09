package ec.edu.uce.erpmunicipal.util.web;

public class ObjectNode {

	private String name;
	private Boolean isCheck;

	
	public ObjectNode(String name, Boolean isCheck) {
		super();
		this.isCheck = isCheck;
		this.name = name;
	}

	/**
	 * @return the isCheck
	 */
	public Boolean getIsCheck() {
		return isCheck;
	}

	/**
	 * @param isCheck
	 *            the isCheck to set
	 */
	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
