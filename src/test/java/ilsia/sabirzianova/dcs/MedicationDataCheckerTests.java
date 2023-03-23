package ilsia.sabirzianova.dcs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class MedicationDataCheckerTests {
	@Test
	void check() {
		Assert.isTrue(MedicationDataChecker.checkName("nurofen"), "Wrong result");
		Assert.isTrue(MedicationDataChecker.checkName("CODE_1"), "Wrong result");
	}

}
