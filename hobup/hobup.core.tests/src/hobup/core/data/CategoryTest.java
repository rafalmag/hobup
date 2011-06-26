package hobup.core.data;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class CategoryTest {

	@Test
	public void getName() {
		String name = new Category().getName();
		assertNull(name);
	}

	@Test
	public void getPriority() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void setName() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void setPriority() {
		throw new RuntimeException("Test not implemented");
	}
}
