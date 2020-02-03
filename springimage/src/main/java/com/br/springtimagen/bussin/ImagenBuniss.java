package com.br.springtimagen.bussin;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.br.springtimagen.springimage.SpringimageApplication;
import com.br.springtimagen.springimage.model.Imagen;

public class ImagenBuniss {
	public Imagen img = new Imagen();
    private static Logger LOG =LoggerFactory.getLogger(SpringimageApplication.class);
    public String data;
    public BufferedImage source;
    public List<BufferedImage> imgs = new ArrayList<BufferedImage>();
    
    
    
    public ImagenBuniss() throws Exception {
	    // inicia o contrutor para serializar a model 
    	// de imagen e pega a data em tempo de execucao
    	// this.readJsonFromUrl("https://xkcd.com/info.0.json");
		source = ImageIO.read(new File("src/main/resources/static/teste.png"));
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    this.data = dtf.format(now).toString();
    }
    
    public void GetWithOutLegendImagen(String pathTarget) {

	try {
	
		int endheigh=(int) Math.round(source.getHeight()* 0.9);
		int endweigh =  source.getWidth();
		ImageIO.write(source.getSubimage(0,0,endweigh,endheigh), "png",
				new File(pathTarget+"Clean_"+data+ ".png"));	
		LOG.info("Imagen sem legenda salva  salva com suceso");
	} catch (IOException e) {
		e.printStackTrace();
	}


}
    public void GetSplitRandomImagen(String pathTarget) {
	
	try {
		int startheigh= 0 ;
		int endtheigh =  source.getHeight() /2;
		int startweigh= 0 ;
		int endweigh =  source.getWidth() /2;
		
		
		
		
		for(int heigh = 0; heigh < 2;heigh++ ) {
		
			for(int width = 0; width < 2;width++ ) {
				BufferedImage item =source.getSubimage(startweigh,startheigh,source.getWidth() /2,source.getHeight() /2);
				imgs.add(item);
				startweigh = endweigh;	
		
						}
			startheigh = endtheigh ; 
			startweigh= 0;	
		}
		
		Collections.shuffle(imgs);

        BufferedImage joinedImg = joinBufferedImage( imgs.get(0),imgs.get(1),imgs.get(2),imgs.get(3));
		
		ImageIO.write(joinedImg, "png",
				new File(pathTarget+"Crypt_"+data+ ".png"));	
		LOG.info("Imagen embaralhada salva com sucesso");
	} catch (IOException e) {
		e.printStackTrace();
	}


}
    public static BufferedImage joinBufferedImage(BufferedImage img1,
    	      BufferedImage img2, BufferedImage img3,BufferedImage img4) {
    	    int width = img1.getWidth() + img2.getWidth();
    	    int height = img1.getHeight()+ img2.getHeight();
    	    BufferedImage newImage = new BufferedImage(width, height,
    	        BufferedImage.TYPE_INT_ARGB);
    	    Graphics2D g2 = newImage.createGraphics();
    	    Color oldColor = g2.getColor();
    	    g2.setPaint(Color.BLACK);
    	    g2.fillRect(0, 0, width, height);
    	    g2.setColor(oldColor);
    	    g2.drawImage(img1, null, 0, 0);
    	    g2.drawImage(img2, null, img1.getWidth(), 0);
    	    g2.drawImage(img3, null, 0, img1.getHeight());
    	    g2.drawImage(img4, null, img3.getWidth(), img2.getHeight());
    	    g2.dispose();
    	    return newImage;
    	  }
 //public void  readJsonFromUrl(String url) throws Exception {
   //     InputStream is = new URL(url).openStream();
     //   try {
       //   BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
         // String jsonText = readAll(rd);
          //JSONObject json = new JSONObject(jsonText);
          //img.fromJSONObject(json);
        //} finally {
          //is.close();
        //}
      //}
 //private static String readAll(Reader rd) throws IOException {
	//    StringBuilder sb = new StringBuilder();
	  //  int cp;
	    //while ((cp = rd.read()) != -1) {
	      //sb.append((char) cp);
	    //}
	    //return sb.toString();
	  //}
 
}
