package ticTacToe.v2.models;

public enum Error {
	NOT_EMPTY("That position is already completed"),
	REPEATED_COORDINATE("Can't put where it came from"),
	NOT_PROPERTY("That position isn't completed by any of your tokens");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
