/**
 * 
 */
package com.collegelocator.utils;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBUtils {

	public static volatile MongoClient mongo = null;

	public static MongoClient getInstance() {
		try {
			if (mongo == null)
				mongo = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mongo;
	}

	public static CommandResult getGeospatialResult(String lat, String lon,String distance) {
		DB db = getInstance().getDB("newdb");

		/**** Get collection / table from 'testdb' ****/
		// if collection doesn't exists, MongoDB will create it for you
		DBCollection table = db.getCollection("CollegeInfo");
		table.ensureIndex(new BasicDBObject("LOCATION", "2dsphere"));
		BasicDBObject cmd = new BasicDBObject();
		cmd.put("geoNear", "CollegeInfo");
		Double coord[] = new Double [2];
		coord[0]= Double.parseDouble(lat);
		coord[1]= Double.parseDouble(lon);
		
		
		cmd.put("near", coord);
		// cmd.put("num", 2);
		cmd.put("spherical", true);
		cmd.put("distanceMultiplier", 6371.3928);
		Double disFilter=Double.parseDouble(distance);
		Double disFilterRadians=disFilter/6371.3928;
		cmd.put("maxDistance", disFilterRadians);
		
		CommandResult r = db.command(cmd);

		return r;
	}

}
