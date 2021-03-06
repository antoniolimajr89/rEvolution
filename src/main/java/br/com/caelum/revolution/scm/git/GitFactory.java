package br.com.caelum.revolution.scm.git;

import br.com.caelum.revolution.config.Config;
import br.com.caelum.revolution.config.IsSCM;
import br.com.caelum.revolution.executor.SimpleCommandExecutor;
import br.com.caelum.revolution.scm.SCM;
import br.com.caelum.revolution.scm.SpecificSCMFactory;

@IsSCM(name="Local Git Repository", configs={"scm.repository"})
public class GitFactory implements SpecificSCMFactory {

	public SCM build(Config config) {
		return new Git(
				config.asString("scm.repository"), 
				new GitLogParser(), 
				new GitDiffParser(),
				new GitBlameParser(),
				new SimpleCommandExecutor());
	}

}
