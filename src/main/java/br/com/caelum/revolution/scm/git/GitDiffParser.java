import java.util.HashMap;
		map = new HashMap<ModificationKind, String>();
			
	private int findTheLineWhereDiffStarts(List<String> lines) {
		int lineDiffsStarts = findTheLineWhereDiffStarts(lines);
		if(lineDiffsStarts == lines.size()) return "";
		
		int diffStarts = findTheLineWhereDiffStarts(lines);
		int modeLine = diffStarts == lines.size() ? 1 : diffStarts - 2;