package com.example.lambdatesting;

public class MailSender {
	private final EventLogger eventLogger;

	public MailSender (final EventLogger eventLogger) {

		this.eventLogger = eventLogger;
	}

	public void sendGreetingLetter (final GreetingLetter letter) {
		eventLogger.sentGreetingLetter();
	}

	public void sendLoveLetter (final LoveLetter letter) {
		eventLogger.sentLoveLetter();
	}
}
