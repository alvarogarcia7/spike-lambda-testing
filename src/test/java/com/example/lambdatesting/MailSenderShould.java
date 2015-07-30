package com.example.lambdatesting;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static org.mockito.Mockito.mock;

public class MailSenderShould {

	private EventLogger eventLogger;
	private MailSender mailSender;
	private Consumer<MailSender> arrange;
	private Consumer<EventLogger> verify;

	@Before
	public void setUp () {
		eventLogger = mock(EventLogger.class);
		mailSender = new MailSender(eventLogger);
	}


	@Test
	public void log_greetings_letter() {
		arrange = (MailSender sut) -> sut.sendGreetingLetter(mock(GreetingLetter.class));

		verify = EventLogger::sentGreetingLetter;

		assertAndVerify();
	}

	@Test
	public void log_love_letter() {
		arrange = (MailSender sut) -> sut.sendLoveLetter(mock(LoveLetter.class));

		verify = EventLogger::sentLoveLetter;

		assertAndVerify();
	}

	private void assertAndVerify() {
		arrange.accept(mailSender);
		verify.accept(eventLogger);
	}
}
