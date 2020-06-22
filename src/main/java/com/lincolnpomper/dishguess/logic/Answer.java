package com.lincolnpomper.dishguess.logic;

public class Answer {

	private boolean yes;
	private boolean no;

	public Answer(boolean yes, boolean no) {

		this.yes = yes;
		this.no = no;
	}

	boolean isYes() {
		return yes;
	}

	boolean isNo() {
		return no;
	}

	@Override public String toString() {
		return "Answer{" + "yes=" + yes + ", no=" + no + '}';
	}
}
