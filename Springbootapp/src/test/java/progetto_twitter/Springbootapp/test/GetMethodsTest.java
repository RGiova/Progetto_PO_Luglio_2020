package progetto_twitter.Springbootapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.util.GetMethods;
import progetto_twitter.Springbootapp.util.ListsCreate;

class GetMethodsTest {
	@BeforeEach
	void SetUp() throws Exception{
		ListsCreate.ListsInitiate();
		GETJson.GETJ();

	}
	@AfterEach
	void tearDown() throws Exception{
		
	}

	@Test
	void test() {
		assertThrows(NoSuchMethodException.class, ()->  GetMethods.SearchMethod("Metodo",ListsCreate.Lists.getMList().get(12)));
		assertEquals(ListsCreate.Lists.getMList().get(12).getImg().get(0).getW(),GetMethods.SearchMethod("w",ListsCreate.Lists.getMList().get(12)));
		assertEquals(ListsCreate.Lists.getMList().get(15).getImg().get(0).getW(),GetMethods.SearchMethod("w",ListsCreate.Lists.getMList().get(15)));		
	}

}
