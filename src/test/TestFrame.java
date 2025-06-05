package test;
import tankwar.TankFrame;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import tankwar.TankFrame;

public class TestFrame  {
	
	@Test
	void TestFrame() throws IOException {
		TankFrame tf = new TankFrame();
		assertNotNull(tf);
	}

}
