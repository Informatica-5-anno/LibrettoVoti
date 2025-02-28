package it.edu.falcone_righi.LibrettoVoti.model;

public enum Errors {
	NOERROR(0, "No Error"),
	DUPLICATE(1, "Duplicate vote"), 
	CONFLICT(2, "Conflicting vote"),
	UNEXISTENT(3,"Unexistent vote");
	private final int code;
	private final String msg;
	private Errors(int code,String msg ) {
		this.code=code;
		this.msg = msg;
		
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
