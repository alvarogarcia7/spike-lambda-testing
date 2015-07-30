package com.example.lambdatesting;

import java.util.function.Consumer;

public class Check {

	private final Consumer<MailSender> act;
	private final Consumer<EventLogger> verify;

	public Check (final Consumer<MailSender> act, final Consumer<EventLogger> verify) {
		this.act = act;
		this.verify = verify;
	}

	public void checkFor(MailSender mailSender, EventLogger eventLogger) {
		act.accept(mailSender);
		verify.accept(eventLogger);
	}
}
