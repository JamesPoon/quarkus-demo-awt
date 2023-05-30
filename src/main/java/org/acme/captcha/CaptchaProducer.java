package org.acme.captcha;
//package com.google.code.kaptcha;

import java.awt.image.BufferedImage;

/**
 * Responsible for creating captcha image with a text drawn on it.
 */
public interface CaptchaProducer
{
	/**
	 * Create an image which will have written a distorted text.
	 * 
	 * @param text
	 *            the distorted characters
	 * @return image with the text
	 */
	public BufferedImage createImage(String text);

	/**
	 * @return the text to be drawn
	 */
	public abstract String createText();
}