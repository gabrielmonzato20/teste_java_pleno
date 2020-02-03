package com.br.springtimagen.springimage.model;
import org.json.JSONObject;

public class Imagen {

	String img;
	
	
	public String GetImg() {
		return this.img;
	}
	public void SetImg(String img) {
		this.img = img;
	}
	
	
	public void fromJSONObject(final JSONObject js) throws Exception {

		if (js.has("img")) {
			SetImg(js.optString("img"));
		}
		
	}

	public JSONObject toJSONObject() {
		return new JSONObject(this);
	}
}
