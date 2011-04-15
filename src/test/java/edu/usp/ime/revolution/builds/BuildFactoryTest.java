package edu.usp.ime.revolution.builds;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import edu.usp.ime.revolution.builds.BuildFactory;
import edu.usp.ime.revolution.builds.ant.Ant;
import edu.usp.ime.revolution.config.Config;
import edu.usp.ime.revolution.config.Configs;

public class BuildFactoryTest {

	@Test
	public void shouldBuildAnt() {
		Config config = mock(Config.class);
		when(config.get(Configs.BUILD)).thenReturn("edu.usp.ime.revolution.builds.ant.AntFactory");
		
		assertTrue(new BuildFactory().basedOn(config).getClass() == Ant.class);
	}
	
	@Test(expected=BuildNotFoundException.class)
	public void shouldWarnIfInvalidBuild() {
		Config config = mock(Config.class);
		when(config.get(Configs.BUILD)).thenReturn("invalid-build");
		
		new BuildFactory().basedOn(config);		
	}
}