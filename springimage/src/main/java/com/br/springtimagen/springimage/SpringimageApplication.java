package com.br.springtimagen.springimage;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.springtimagen.bussin.ImagenBuniss;


@SpringBootApplication
public class SpringimageApplication implements CommandLineRunner {
    private static Logger LOG =LoggerFactory.getLogger(SpringimageApplication.class);
	public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringimageApplication.class, args);
        LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		
        LOG.info("Executando : command line runner");
        ImagenBuniss img = new ImagenBuniss();
       img.GetWithOutLegendImagen("src/main/resources/static/splits_radom_imagens/");
       img.GetSplitRandomImagen("src/main/resources/static/splits_radom_imagens/");
       

}
}
