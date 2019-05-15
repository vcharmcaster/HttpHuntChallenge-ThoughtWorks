package com.thought.client;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class GameApp {

	public static void main(String[] args) throws Exception {
		RequestCaller req = new RequestCaller();
		GameService gameService = new GameService();
		JSONObject ansObject = new JSONObject();
		JSONObject responseStatus = new JSONObject(req.getStatus());
		System.out.println(responseStatus);
		if (responseStatus.has("stage")) {
			String stg = responseStatus.get("stage").toString();
			Integer stage = Integer.parseInt(stg.substring(0, stg.indexOf("/")));
			JSONArray jArr = null;
			if (stage <= 4) {
				jArr = new JSONArray(req.getInput());
				System.out.println(jArr);
			} else {
				String tmp = req.getInput();
				System.out.println(tmp);
				return;
			}
			switch (stage) {
			case 1:
				ansObject = gameService.solveStageOne(ansObject, jArr);
				break;
			case 2:
				ansObject = gameService.solveStageTwo(ansObject, jArr);
				break;

			case 3:
				ansObject = gameService.solveStageThree(ansObject, jArr);
				break;

			case 4:
				ansObject = gameService.solveStageFour(ansObject, jArr);
				break;

			default:
				ansObject = new JSONObject();
				break;

			}
		}
		req.post(ansObject);
	}
}
