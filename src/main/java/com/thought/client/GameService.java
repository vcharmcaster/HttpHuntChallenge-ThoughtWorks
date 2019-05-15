package com.thought.client;

import java.util.Calendar;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;


public class GameService {

	

	public JSONObject solveStageOne(JSONObject ansObject, JSONArray jArr) throws Exception {
		ansObject.put("count", jArr.length());
		return ansObject;
	}

	public JSONObject solveStageTwo(JSONObject ansObject, JSONArray jArr) throws Exception {
		System.out.println("Solving Stage Three!!!....");
		int count = 0;
		for (int i = 0; i < jArr.length(); i++) {
			Object j = jArr.get(i);
			JSONObject tmp = (JSONObject) j;
			String start = tmp.getString("startDate");
			String end = null;
			if (!"null".equalsIgnoreCase(tmp.get("endDate").toString())) {
				end = tmp.getString("endDate");
			}

			// System.out.print(tmp.getInt("price") + " total: " + total + " ");
			System.out.print("s: " + start.toString());

			String[] sArr = start.split("\\-");
			String[] eArr = null;
			if (end != null) {
				System.out.println(" e: " + end.toString());
				eArr = end.split("\\-");
			} else {
				System.out.println(" e: null");
			}

			Calendar cal = Calendar.getInstance();

			// Creating Start Date Object
			cal.set(Calendar.DATE, Integer.parseInt(sArr[2]));
			cal.set(Calendar.MONTH, Integer.parseInt(sArr[1]));
			cal.set(Calendar.YEAR, Integer.parseInt(sArr[0]));
			Date Dstart = cal.getTime();

			// Creating End Date Object
			Date Dend = null;
			if (eArr != null) {
				cal.set(Calendar.DATE, Integer.parseInt(eArr[2]));
				cal.set(Calendar.MONTH, Integer.parseInt(eArr[1]));
				cal.set(Calendar.YEAR, Integer.parseInt(eArr[0]));
				Dend = cal.getTime();
			}

			// Creating Today's Date Object
			Date today = new Date();

			// Actual Logic for Date comparison
			if (!today.before(Dstart)) {
				if (Dend == null || !today.after(Dend)) {
					count++;
				}
			}

			System.out.print("s: " + Dstart.toString() + " t: " + today.toString());
			if (Dend != null) {
				System.out.println(" e: " + Dend.toString());
			} else {
				System.out.println(" e: null");
			}

		}
		ansObject.put("count", count);
		return ansObject;
	}

	public JSONObject solveStageThree(JSONObject ansObject, JSONArray jArr) throws Exception {
		System.out.println("Solving Stage Three!!!....");

		for (int i = 0; i < jArr.length(); i++) {
			Object j = jArr.get(i);
			JSONObject tmp = (JSONObject) j;
			String start = tmp.getString("startDate");
			String end = null;
			if (!"null".equalsIgnoreCase(tmp.get("endDate").toString())) {
				end = tmp.getString("endDate");
			}

			// System.out.print(tmp.getInt("price") + " total: " + total + " ");
			System.out.print("s: " + start.toString());

			String[] sArr = start.split("\\-");
			String[] eArr = null;
			if (end != null) {
				System.out.println(" e: " + end.toString());
				eArr = end.split("\\-");
			} else {
				System.out.println(" e: null");
			}

			Calendar cal = Calendar.getInstance();

			// Creating Start Date Object
			cal.set(Calendar.DATE, Integer.parseInt(sArr[2]));
			cal.set(Calendar.MONTH, Integer.parseInt(sArr[1]));
			cal.set(Calendar.YEAR, Integer.parseInt(sArr[0]));
			Date Dstart = cal.getTime();

			// Creating End Date Object
			Date Dend = null;
			if (eArr != null) {
				cal.set(Calendar.DATE, Integer.parseInt(eArr[2]));
				cal.set(Calendar.MONTH, Integer.parseInt(eArr[1]));
				cal.set(Calendar.YEAR, Integer.parseInt(eArr[0]));
				Dend = cal.getTime();
			}

			// Creating Today's Date Object
			Date today = new Date();

			// Actual Logic for Date comparison
			if (!today.before(Dstart)) {
				if (Dend == null || !today.after(Dend)) {
					if (ansObject.has("category")) {
						ansObject.put(tmp.getString("category"), String
								.valueOf(Integer.valueOf(ansObject.get(tmp.getString("category")).toString()) + 1));
					} else {
						ansObject.put(tmp.getString("category"), String.valueOf(1));
					}
				}
			}

			System.out.print("s: " + Dstart.toString() + " t: " + today.toString());
			if (Dend != null) {
				System.out.println(" e: " + Dend.toString());
			} else {
				System.out.println(" e: null");
			}
		}
		return ansObject;
	}

	public JSONObject solveStageFour(JSONObject ansObject, JSONArray jArr) throws Exception {
		System.out.println("Solving Stage Four!!!....");

		int total = 0;
		for (int i = 0; i < jArr.length(); i++) {
			Object j = jArr.get(i);
			JSONObject tmp = (JSONObject) j;
			String start = tmp.getString("startDate");
			String end = null;
			if (!"null".equalsIgnoreCase(tmp.get("endDate").toString())) {
				end = tmp.getString("endDate");
			}

			// System.out.print(tmp.getInt("price") + " total: " + total + " ");
			System.out.print("s: " + start.toString());

			String[] sArr = start.split("\\-");
			String[] eArr = null;
			if (end != null) {
				System.out.println(" e: " + end.toString());
				eArr = end.split("\\-");
			} else {
				System.out.println(" e: null");
			}

			Calendar cal = Calendar.getInstance();

			// Creating Start Date Object
			cal.set(Calendar.DATE, Integer.parseInt(sArr[2]));
			cal.set(Calendar.MONTH, Integer.parseInt(sArr[1]));
			cal.set(Calendar.YEAR, Integer.parseInt(sArr[0]));
			Date Dstart = cal.getTime();

			// Creating End Date Object
			Date Dend = null;
			if (eArr != null) {
				cal.set(Calendar.DATE, Integer.parseInt(eArr[2]));
				cal.set(Calendar.MONTH, Integer.parseInt(eArr[1]));
				cal.set(Calendar.YEAR, Integer.parseInt(eArr[0]));
				Dend = cal.getTime();
			}

			// Creating Today's Date Object
			Date today = new Date();

			// Actual Logic for Date Comparison
			if (!today.before(Dstart)) {
				if (Dend == null || !today.after(Dend)) {
					total += tmp.getInt("price");
				}
			}

			System.out.print(tmp.getInt("price") + " total: " + total + " ");
			System.out.print("s: " + Dstart.toString() + " t: " + today.toString());
			if (Dend != null) {
				System.out.println(" e: " + Dend.toString());
			} else {
				System.out.println(" e: null");
			}

		}
		ansObject.put("totalValue", String.valueOf(total));
		return ansObject;
	}
}
