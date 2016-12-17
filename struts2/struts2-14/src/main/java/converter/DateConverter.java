package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ognl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		// 将字符串转换为日期类型
		if (toType == String.class) {
			Date date = (Date) value;
			// 将日期类型转换为yyyy-MM-dd格式的字符串
			return format.format(date);
		}
		// 将日期字符串转换为日期类型
		else if (toType == Date.class) {
			String strDate = ((String[]) value)[0];
			// 按照指定的格式对strDate字符串进行转换
			try {
				return format.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
