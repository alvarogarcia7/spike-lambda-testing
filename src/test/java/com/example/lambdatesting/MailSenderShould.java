package com.example.lambdatesting;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MailSenderShould {

	private EventLogger eventLogger;
	private MailSender mailSender;

	@Before
	public void setUp () {
		eventLogger = mock(EventLogger.class);
		mailSender = new MailSender(eventLogger);
	}

	@Test
	public void log_greetings_letter() {
		mailSenderLogs(whenSendingAGreetingLetter());
	}

	@Test
	public void log_love_letter() {
		mailSenderLogs(whenSendingALoveLetter());
	}

	private Check whenSendingALoveLetter () {
		return new Check(
				(MailSender sut) -> sut.send(letter(LoveLetter.class)),
				EventLogger::sentLoveLetter
		);
	}

	private void mailSenderLogs (Check check) {
		check.checkFor(mailSender, eventLogger);
	}

	private Check whenSendingAGreetingLetter () {
		return new Check(
				(MailSender sut) -> sut.send(letter(GreetingLetter.class)),
				EventLogger::sentGreetingLetter
		);
	}

	private <T> T letter (final Class<T> typeOfLetter) {
		return mock(typeOfLetter);
	}
}
