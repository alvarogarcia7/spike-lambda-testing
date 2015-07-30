package com.example.lambdatesting;

import java.util.function.Consumer;

class CheckBuilder {
	private Consumer<MailSender> act;

	public static CheckBuilder aLoggingLine () {
		return new CheckBuilder();
	}

	public CheckBuilder forA (Consumer<MailSender> act) {
		this.act = act;
		return this;
	}

	public Check wasLoggedWhen (Consumer<EventLogger> verify){

		return new Check(this.act, verify);
	}

}
