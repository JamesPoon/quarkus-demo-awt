package org.acme;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.acme.captcha.ClazzUtil;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@QuarkusTest
public class AwtTests {
	@Test
	void fonts() {
        String[] names = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        log.info("fonts: {}", Arrays.asList(names));
	}
	@Test
	void colors() {
		String to ="white";
		Color color = ClazzUtil.field(to, Color.class);
        log.info("color[white]: {}", color);
		to ="lightGray";
		color = ClazzUtil.field(to, Color.class);
        log.info("color[lightGray]: {}", color);
		to ="black";
		color = ClazzUtil.field(to, Color.class);
        log.info("color[black]: {}", color);
	}
	@Test
	void fields() {
		Field[] fields = Color.class.getFields();
        log.info("fields: {}", Arrays.asList(fields));
        fields = Color.class.getDeclaredFields();
        log.info("fields: {}", Arrays.asList(fields));
	}
}
