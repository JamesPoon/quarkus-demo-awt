package org.acme.captcha;

import java.lang.reflect.Field;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class ClazzUtil {

    @SuppressWarnings("unchecked")
    public static <T>T field(String name, Class<?> clazz) {
    	try {
    		log.info("Class: {}", clazz);
    		log.info("Generic: {}", clazz.getGenericSuperclass());
    		log.info("Super: {}", clazz.getSuperclass());
    		// If the underlying field is a static field, the {@code obj} argument is ignored; it may be null.
			Field field = clazz.getField(name);
			field.setAccessible(true);
			return (T)field.get(null);
    	} catch (Exception e) {
        	log.error(e.getMessage(), e);
    		return null;
    	}
    }
}
