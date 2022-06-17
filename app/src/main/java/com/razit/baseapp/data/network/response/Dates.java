package com.razit.baseapp.data.network.response;

import com.google.gson.annotations.SerializedName;

public class Dates{

	@SerializedName("maximum")
	private String maximum;

	@SerializedName("minimum")
	private String minimum;

	public String getMaximum(){
		return maximum;
	}

	public String getMinimum(){
		return minimum;
	}

	@Override
 	public String toString(){
		return 
			"Dates{" + 
			"maximum = '" + maximum + '\'' + 
			",minimum = '" + minimum + '\'' + 
			"}";
		}
}