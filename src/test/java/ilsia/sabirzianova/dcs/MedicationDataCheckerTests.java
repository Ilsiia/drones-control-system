package ilsia.sabirzianova.dcs;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

@RunWith(MockitoJUnitRunner.class)
class MedicationDataCheckerTests {
	@Test
	void check() {
		Assert.isTrue(MedicationDataChecker.checkName("nurofen"), "Wrong result");
		Assert.isTrue(MedicationDataChecker.checkCode("CODE_1"), "Wrong result");
		Assert.isTrue(!MedicationDataChecker.checkName("nur*fen"), "Wrong result");
		Assert.isTrue(!MedicationDataChecker.checkCode("code_1"), "Wrong result");
	}
}
