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
		mailSenderLogs(when(aGreetingLetterIsSent()));
	}

	@Test
	public void log_love_letter() {
		mailSenderLogs(when(aLoveLetterIsSent()));
	}

	private Check when (final Check check) {
		return check;
	}

	private Check aLoveLetterIsSent () {
		return new Check(
				new Check.Given(eventLogger, mailSender),
				(MailSender sut) -> sut.send(letter(LoveLetter.class)),
				EventLogger::sentLoveLetter
		);
	}

	private void mailSenderLogs (Check check) {
				check.checkFor();
	}

	private Check aGreetingLetterIsSent () {
		return new Check(
				new Check.Given(eventLogger, mailSender),
				(MailSender sut) -> sut.send(letter(GreetingLetter.class)),
				EventLogger::sentGreetingLetter
		);
	}

	private <T> T letter (final Class<T> typeOfLetter) {
		return mock(typeOfLetter);
	}
}
