package reproducer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

class MockitoReproducerTests {

	@Test
	@Timeout(value = 5, threadMode = SEPARATE_THREAD)
	void stallsOnConfigClassInitialization() {
		new AnnotationConfigApplicationContext(ProxiedConfigurationClass.class);
	}

	@Configuration
	static class ProxiedConfigurationClass {

		static Object object = Mockito.mock(Object.class);

	}

	@Test
	@Timeout(value = 5, threadMode = SEPARATE_THREAD)
	void worksFineIfStartedIndependently() {
		new AnnotationConfigApplicationContext(NotProxiedConfigurationClass.class);
	}

	@Configuration(proxyBeanMethods = false)
	static class NotProxiedConfigurationClass {

		static Object object = Mockito.mock(Object.class);

	}

}
