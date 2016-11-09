package taggr;
import java.io.File;
import java.io.IOException;

import org.jcodec.api.JCodecException;

public class Driver {
	
	public static void main(String[] args) throws NumberFormatException, IOException, JCodecException
	{
		ExtractImages extractImageInstance = new ExtractImages();
		extractImageInstance.extractImage(new File("F:/MultimediaFiles/videos/Video1.mp4"), Integer.parseInt("1"));
	}

}
