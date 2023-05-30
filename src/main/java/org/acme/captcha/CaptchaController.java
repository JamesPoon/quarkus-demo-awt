package org.acme.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
//import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("demo/captcha")
//@ApplicationScoped
public class CaptchaController {
	@Inject
	CaptchaProducer captchaProducer;
    @GET
    @Path("image")
    public void captcha(@Context HttpServerRequest request) {
    	HttpServerResponse res = request.response();
    	String text = captchaProducer.createText();
    	byte[] bytes = image(text);
    	res.putHeader("Cache-Control", "no-store");
    	res.putHeader("Pragma", "no-cache");
    	res.putHeader("Expires", "0");
    	res.putHeader("Content-Type", "image/jpeg");
    	res.setStatusCode(200);
    	res.send(Buffer.buffer(bytes));
    }
	byte[] image(String token) {
        BufferedImage bi = captchaProducer.createImage(token);
        ByteArrayOutputStream bao	=	new ByteArrayOutputStream();
        try {
			ImageIO.write(bi, "JPEG", bao);
			return bao.toByteArray();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new IllegalArgumentException();
		}
	}
}
