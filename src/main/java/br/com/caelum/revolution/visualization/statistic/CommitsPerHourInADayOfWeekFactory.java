package br.com.caelum.revolution.visualization.statistic;

import java.math.BigInteger;

import br.com.caelum.revolution.config.Config;
import br.com.caelum.revolution.config.IsVisualization;
import br.com.caelum.revolution.visualization.SpecificVisualizationFactory;
import br.com.caelum.revolution.visualization.Visualization;
import br.com.caelum.revolution.visualization.common.BarChart;
import br.com.caelum.revolution.visualization.common.GroupedDataVisualization;
import br.com.caelum.revolution.visualization.common.MapToDataSetConverter;

@IsVisualization(name="Commits per Hour in Day of Week", configs={"weekday"})
public class CommitsPerHourInADayOfWeekFactory implements
		SpecificVisualizationFactory {

	public Visualization build(Config config) {

		StringBuilder sql = new StringBuilder();
		sql.append("select convert(hour(x.date), char) name, count(1) qty ");
		sql.append("from commit x ");
		sql.append("where dayname(x.date) = '" + config.asString("weekday") + "' ");
		sql.append("group by hour(x.date) ");
		sql.append("order by hour(x.date) ");

		return new GroupedDataVisualization<BigInteger>(new BarChart(
				"Commits per Hour in " + config.asString("weekday"), "Hours", "Quantity",
				new MapToDataSetConverter()), sql.toString());
	}

}
