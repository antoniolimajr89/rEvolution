package br.com.caelum.revolution.visualization.statistic;

import java.math.BigInteger;

import br.com.caelum.revolution.config.Config;
import br.com.caelum.revolution.config.IsVisualization;
import br.com.caelum.revolution.visualization.SpecificVisualizationFactory;
import br.com.caelum.revolution.visualization.Visualization;
import br.com.caelum.revolution.visualization.common.MapToDataSetConverter;
import br.com.caelum.revolution.visualization.common.PieChart;
import br.com.caelum.revolution.visualization.common.ThresholdedGroupedDataVisualization;

@IsVisualization(name="Bugged Artifacts", configs={"threshold"})
public class BuggedArtifactsFactory implements SpecificVisualizationFactory{

	public Visualization build(Config config) {
		return new ThresholdedGroupedDataVisualization<BigInteger>(
				new PieChart("Most Bugged Artifacts", new MapToDataSetConverter()), 
				config.asInt("threshold"),
				"select a.name, count(1) qty from artifact a inner join modification m on m.artifact_id = a.id inner join bugorigin bo on bo.modification_id = m.id group by a.name order by qty desc");
	}

}
