package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class BirthdayConverter extends StrutsTypeConverter {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		// 转换为Date类型
		try {
			return format.parse(values[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertToString(Map map, Object object) {
		// 使用指定格式格式化Date对象
		return format.format(object);
	}

}
