package com.example.lambdatesting;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static com.example.lambdatesting.CheckBuilder.*;
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
		checkThat(aLoggingLine().forA(greetingLetter()).wasLoggedWhen(aGreetingLetterWasSent()));
	}

	@Test
	public void log_love_letter() {
		checkThat(aLoggingLine().forA(loveLetter()).wasLoggedWhen(aLoveLetterWasSent()));
	}

	private void checkThat (final Check check) {
		check.checkFor(mailSender, eventLogger);
	}

	private Consumer<EventLogger> aGreetingLetterWasSent () {
		return EventLogger::sentGreetingLetter;
	}

	private Consumer<MailSender> greetingLetter () {
		return (MailSender sut) -> sut.sendGreetingLetter(mock(GreetingLetter.class));
	}

	private Consumer<MailSender> loveLetter () {
		return (MailSender sut) -> sut.sendLoveLetter(mock(LoveLetter.class));
	}

	private Consumer<EventLogger> aLoveLetterWasSent () {
		return EventLogger::sentLoveLetter;
	}
}
