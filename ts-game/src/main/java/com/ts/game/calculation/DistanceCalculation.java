package com.ts.game.calculation;

public class DistanceCalculation {
	
	public static double distance(double lat1, double lng1, double lat2, double lng2) {
		double a = (lat1 - lat2) * distPerLat(lat1);
		double b = (lng1 - lng2) * distPerLng(lat1);
		return Math.sqrt(a * a + b * b)/1000;
	}

	private static double distPerLng(double lat) {
		return 0.0003121092 * Math.pow(lat, 4) + 0.0101182384 * Math.pow(lat, 3) - 17.2385140059 * lat * lat
				+ 5.5485277537 * lat + 111301.967182595;
	}

	private static double distPerLat(double lat) {
		return -0.000000487305676 * Math.pow(lat, 4) - 0.0033668574 * Math.pow(lat, 3) + 0.4601181791 * lat * lat
				- 1.4558127346 * lat + 110579.25662316;
	}

	public static void main(String args[]) {
		// 13.729743, 100.531508
		// 13.725190, 100.514862
		double distance = distance(13.729743, 100.531508, 13.725190, 100.514862);
		System.out.println("distance :" + distance);

	}
}
