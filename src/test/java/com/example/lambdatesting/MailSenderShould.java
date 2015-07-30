package com.example.lambdatesting;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MailSenderShould {

	private EventLogger eventLogger;
	private MailSender mailSender;

	@Before
	public void setUp () {
		eventLogger = mock(EventLogger.class);
		mailSender = new MailSender(eventLogger);
	}

	@Test
	public void log_when_sending_greeting_letters() {

		mailSender.sendGreetingLetter(mock(GreetingLetter.class));

		verify(eventLogger).sentGreetingLetter();
	}

	@Test
	public void log_when_sending_love_letters() {

		mailSender.sendLoveLetter(mock(LoveLetter.class));

		verify(eventLogger).sentLoveLetter();
	}
}
