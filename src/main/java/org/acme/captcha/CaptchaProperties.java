package org.acme.captcha;

import java.util.Properties;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

//import com.google.code.kaptcha.Constants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class CaptchaProperties {
	/**
	 *  图片尺寸
	 */
	public Image image = new Image();
	/**
	 * 内容
	 */
//	  @NestedConfigurationProperty
	public Content content = new Content();
	/**
	 * 背景色
	 */
//	  @NestedConfigurationProperty
	public Background background = new Background();
	/**
	 * 字体
	 */
//	  @NestedConfigurationProperty
	public Font font = new Font();
	/**
	 * 边框
	 */
//	  @NestedConfigurationProperty
	public Border border = new Border();

	public Noise noise = new Noise();
	
	@Getter
	@Setter
	@NoArgsConstructor
	public static class Image {

		/**
		 * 宽度
		 */
		public Integer width = 200;
		/**
		 * 高度
		 */
		public Integer height = 50;
		
	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Background {

		/**
		 * 开始渐变色
		 */
		public String from = "lightGray";
		/**
		 * 结束渐变色
		 */
		public String to = "white";

	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Content {

		/**
		 * 内容源
		 */
		public String source = "0123456789";
		/**
		 * 内容长度
		 */
		public Integer length = 4;
		/**
		 * 内容间隔
		 */
		public Integer space = 2;

	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Border {

		/**
		 * 是否开启
		 */
		public Boolean enabled = true;
		/**
		 * 颜色
		 */
		public String color = "black";
		/**
		 * 厚度
		 */
		public Integer thickness = 1;

	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Noise {

		/**
		 * 名称
		 */
		public String name = "Arial";
		/**
		 * 颜色
		 */
		public String color = "black";
		/**
		 * 大小
		 */
		public Integer size = 40;

	}
	@Getter
	@Setter
	@NoArgsConstructor
	public static class Font {

		/**
		 * 名称
		 */
		public String name = "Arial";
		/**
		 * 颜色
		 */
		public String color = "black";
		/**
		 * 大小
		 */
		public Integer size = 40;

	}

//	public Properties build() {
//		Properties prop = new Properties();
//
//		prop.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, String.valueOf(image.width));
//		prop.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, String.valueOf(image.height));
//
////		    Content content = properties.getContent();
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, content.getSource());
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, String.valueOf(content.getLength()));
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, String.valueOf(content.getSpace()));
//
////		    BackgroundColor backgroundColor = properties.getBackgroundColor();
//		prop.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, background.getFrom());
//		prop.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_TO, background.getTo());
//
////		    Border border = properties.getBorder();
//		prop.setProperty(Constants.KAPTCHA_BORDER, border.getEnabled() ? "yes" : "no");
//		prop.setProperty(Constants.KAPTCHA_BORDER_COLOR, border.getColor());
//		prop.setProperty(Constants.KAPTCHA_BORDER_THICKNESS, String.valueOf(border.getThickness()));
//
////		    Font font = properties.getFont();
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, font.getName());
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, String.valueOf(font.getSize()));
//		prop.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, font.getColor());
//
//		return prop;
//	}
}
