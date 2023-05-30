package org.acme.captcha;
//package com.google.code.kaptcha.text.impl;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

//import com.google.code.kaptcha.text.TextProducer;
//import com.google.code.kaptcha.util.Configurable;

/**
 * {@link TextProducerImpl} creates random text from an array of characters
 * with specified length.
 */
@ApplicationScoped
public class TextProducerImpl 
//extends Configurable 
implements TextProducer
{
	@Inject
	CaptchaProperties properties;
	/**
	 * @return the random text
	 */
	public String getText()
	{
		int length = properties.content.length;
		char[] chars = properties.content.source.toCharArray();
		Random rand = new Random();
		StringBuffer text = new StringBuffer();
		for (int i = 0; i < length; i++)
		{
			text.append(chars[rand.nextInt(chars.length)]);
		}

		return text.toString();
	}
}
