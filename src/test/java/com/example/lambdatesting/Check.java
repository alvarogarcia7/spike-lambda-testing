package com.example.lambdatesting;

import java.util.function.Consumer;

public class Check {

	private final Given given;
	private final Consumer<MailSender> act;
	private final Consumer<EventLogger> verify;

	public Check (Given given, final Consumer<MailSender> act, final Consumer<EventLogger> verify) {
		this.given = given;
		this.act = act;
		this.verify = verify;
	}

	public void checkFor() {
		act.accept(given.mailSender);
		verify.accept(given.eventLogger);
	}

	public static class Given {
		public MailSender mailSender;
		public EventLogger eventLogger;

		public Given (final EventLogger eventLogger, final MailSender mailSender) {

			this.eventLogger = eventLogger;
			this.mailSender = mailSender;
		}
	}
}
