package rewards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

class RewardNetworkTests {
	
	private RewardNetwork rewordNetwork;

	@BeforeEach
	void setUp() throws Exception {
		ApplicationContext context = SpringApplication.run(TestInfrastructureConfig.class);
		rewordNetwork =context.getBean(RewardNetwork.class);
	}

	@Test
	void test() {
		fail("まだ実装されていません");
	}

}
