package com.oraclewdp.sxndajax;

import org.json.JSONArray;
import org.json.JSONException;

import com.oraclewdp.sxndvo.User;

public class TestJSON {

	public static void main(String[] args) {
		// 创建一个3 user数组
		User[] users = new User[3];
		users[0] = new User("z3", 22);
		users[1] = new User("w5", 21);
		users[2] = new User("l4", 23);
		try {
			JSONArray jsonArray = new JSONArray(users);
			//System.out.println(jsonArray.toString());
			jsonArray = new JSONArray(
					"[{\"name\":\"z3\",\"age\":22},{\"name\":\"w5\",\"age\":21},{\"name\":\"l4\",\"age\":23}]");
			//System.out.println(jsonArray.getJSONObject(0));
			//System.out.println(JSONML.toString(jsonArray));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
