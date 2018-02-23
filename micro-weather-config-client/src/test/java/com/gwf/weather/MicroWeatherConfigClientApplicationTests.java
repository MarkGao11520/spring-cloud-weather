package com.gwf.weather;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroWeatherConfigClientApplicationTests {

	@Value("${version}")
	private String version;

	@Test
	public void contextLoads() {
		Assert.assertEquals("1.0",version);
	}

}
