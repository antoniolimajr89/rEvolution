package br.com.caelum.revolution.scm.changesets;

import br.com.caelum.revolution.config.Config;
import br.com.caelum.revolution.scm.SCM;

public class OnlyOneChangeSetFactory implements SpecificChangeSetFactory{

	public ChangeSetCollection build(SCM scm, Config config) {
		return new OnlyOneChangeSet(config.get("changesets.one"));
	}
}
