package chart.bar;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart1 {
	public static String getBarChart(HttpSession session) throws IOException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(510, "深圳", "苹果");
		dataset.setValue(320, "深圳", "香蕉");
		dataset.addValue(580, "深圳", "橘子");
		dataset.addValue(390, "深圳", "梨子");
		JFreeChart chart = ChartFactory.createBarChart3D("水果销量统计图", "水果", "销售", dataset, PlotOrientation.VERTICAL, true, true, true);
		String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 500, null, session);
		return fileName;
	}
}
