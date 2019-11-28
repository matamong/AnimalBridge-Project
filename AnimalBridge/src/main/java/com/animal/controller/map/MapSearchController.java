package com.animal.controller.map;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.animal.controller.SubController;
import com.animal.service.MapService;
import com.animal.vo.MapVO;

public class MapSearchController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mapAddress = req.getParameter("mapAddress");
		System.out.println("parameter로 넘어온 검색주소: " + mapAddress);

		//여기서부터는 json만드는 것(따로 뺄 것!) -- dao.getAllJSON도 없애고 이걸로 만들자.
		MapService service = MapService.getInstance();
		ArrayList<MapVO> mapList = new ArrayList<MapVO>();

		mapList = service.searchAddress(mapAddress);

		JSONArray jsonArr = new JSONArray();

		for(int i=0; i<mapList.size(); i++) {
			JSONArray jsonArr2 = new JSONArray();

			JSONObject mapJson = new JSONObject();
			mapJson.put("value",mapList.get(i).getMap_address());
			System.out.println("Json에 담기는 vo맵주소 : " + mapList.get(i).getMap_address());
			jsonArr2.put(mapJson);
			
			JSONObject titleJson = new JSONObject();
			titleJson.put("value", mapList.get(i).getTitle());
			jsonArr2.put(titleJson);
			
			JSONObject specialJson = new JSONObject();
			specialJson.put("value", mapList.get(i).getSpecial());
			jsonArr2.put(specialJson);
			
			JSONObject nicknameJson = new JSONObject();
			nicknameJson.put("value", mapList.get(i).getMember_nickname());
			jsonArr2.put(nicknameJson);

			jsonArr.put(jsonArr2);
		}

		JSONObject json = new JSONObject();
		json.put("result", jsonArr);
		String jsonStr = json.toString();
		resp.getWriter().write(jsonStr);

		System.out.println("최종 출력되는 json: " + jsonStr);
	}

}
