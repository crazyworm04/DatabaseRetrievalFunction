package com.amazonaws.lambda.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class DatabaseRetrieval implements RequestHandler<JSONObject, JSONObject> {
	
	private final String url = "";
	private final String user = "";
	private final String password = "";
	private Connection connection = null;
		
	JSONObject dataOutput = new JSONObject();
	JSONObject dataObject = new JSONObject();
	JSONObject headersObject = new JSONObject();
	JSONObject bodyText = new JSONObject();
	
	//Method that establishes connection with the postgreSQL database
	public Connection connect() {
		if(connection == null) {
		try {
			connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
		return connection;
		}
	
	//Method for getting the data from the database
	@Override
    public JSONObject handleRequest(JSONObject input, Context context) {
        connect();
		
        try {
			ResultSet result = connection.createStatement().executeQuery("SELECT * FROM \"columnName\"");
			System.out.println("The data has been sucessfully retrieved.");
			
			JSONObject dataObj = new JSONObject();
								
			while(result.next()) {
									
				dataObj.put("DataOutput", result.getString(3));
			}
			headersObject.put("Access-Control-Allow-Origin", "*");
			bodyText.put("bodyText", dataObj);
											
			dataOutput.put("isBase64Encoded", false);
			dataOutput.put("statusCode", 200);
			dataOutput.put("headers", headersObject);         
			dataOutput.put("body", bodyText.toJSONString());
                                    
		} 
        catch(SQLException e) {
		System.out.println(e.getMessage());
	} 
		return dataOutput;
	}
}