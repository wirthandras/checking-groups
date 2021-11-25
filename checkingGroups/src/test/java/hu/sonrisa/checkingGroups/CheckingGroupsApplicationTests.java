package hu.sonrisa.checkingGroups;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CheckingGroupsApplicationTests {
	GroupChecker checker = new GroupChecker();

	@Test
	void incorrectNumberOfElements() {
		boolean result = checker.groupCheck("(})");
		assertThat(result).isEqualTo(false);
	}

	@Test
	void incorrectGroups() {
		boolean incorrect1 = checker.groupCheck("{(})");
		boolean incorrect2 = checker.groupCheck("([]");
		boolean incorrect3 = checker.groupCheck("[])");

		assertThat(incorrect1).isEqualTo(false);
		assertThat(incorrect2).isEqualTo(false);
		assertThat(incorrect3).isEqualTo(false);
	}

	@Test
	void correctGroups() {
		boolean correct1 = checker.groupCheck("({})");
		boolean correct2 = checker.groupCheck("[[]()]");
		boolean correct3 = checker.groupCheck("[{()}]");

		assertThat(correct1).isEqualTo(true);
		assertThat(correct2).isEqualTo(true);
		assertThat(correct3).isEqualTo(true);
	}



}
