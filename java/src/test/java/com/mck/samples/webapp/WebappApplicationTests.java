package com.mck.samples.webapp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class WebappApplicationTests {

	@Value("${settings.applicationName}")
	private String applicationName;

	@Test
	public void contextLoads() {

		WebappApplication sut = new WebappApplication();
		ReflectionTestUtils.setField(sut,"applicationName",applicationName);
		String result = sut.hi();

		Assert.assertThat(result,containsString("test"));
	}

}
