package progetto_twitter.Springbootapp.test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 * Test che verifica se la calsse DateVerify lanci le giuste eccezioni
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.util.ModifyDate;

class DateVerifyExceptionTest {
	@BeforeEach
	void SetUp() throws Exception{
	}
	@AfterEach
	void tearDown() throws Exception{
	}

	@Test
	void test() {
		assertThrows(WrongDateFormatException.class, ()->  ModifyDate.DateVerify("dodici/04/2020"));
		assertThrows(WrongDateFormatException.class, ()->  ModifyDate.DateVerify("32/04/2020"));
		assertThrows(WrongDateFormatException.class, ()->  ModifyDate.DateVerify("32/13/2020"));
		assertThrows(WrongDateFormatException.class, ()->  ModifyDate.DateVerify("25/trenta/2020"));
	}

}
