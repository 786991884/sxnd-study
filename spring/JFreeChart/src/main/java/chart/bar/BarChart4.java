package chart.bar;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class BarChart4 {
	public static String getBarChart(HttpSession session) throws IOException {
		double[][] data = new double[][] { { 1320, 1110, 1123, 321 }, { 720, 210, 1423, 1321 }, { 830, 1310, 123, 521 }, { 400, 1110, 623, 321 } };
		String[] columnKeys = { "深圳", "北京", "上海", "南京" };
		String[] rowKeys = { "苹果", "香蕉", "橘子", "梨子" };
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
		JFreeChart chart = ChartFactory.createBarChart3D("水果销售统计图", "水果", "销售", dataset, PlotOrientation.VERTICAL, true, true, true);
		String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 500, null, session);
		return fileName;
	}
}
