package taggr;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;


public class ExtractImages {

    public void extractImage(File videoFile, Integer videoNumber) throws IOException, JCodecException {
    	int i = 0;
    	ExtractText extractingInstance = new ExtractText();
    	String convertedDestination = "videoFile"+videoNumber;
    	FileWriter writeToDestination = new FileWriter("F:/MultimediaFiles/textsFromVideos/"+convertedDestination+".txt");
    	StringBuilder textFromImages = new StringBuilder();
    	String fileName = null;
    	File inputFile = null;
        long time = System.currentTimeMillis();
        try{
        for (i = 1; i < 150; i=i+30) { 
            BufferedImage frame = FrameGrab.getFrame(videoFile,i);
            fileName = "F:/MultimediaFiles/videoToFrames/videoNumber/"+i+".png";
            inputFile = new File(fileName);
            ImageIO.write(frame, "png", inputFile);
            textFromImages.append(extractingInstance.extractText(inputFile));
            textFromImages.append("\n+++++\n");
        }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("the frame got over at "+i);
        }
        
        writeToDestination.write(textFromImages.toString());
        System.out.println("Time Used:" + (System.currentTimeMillis() - time)+" Milliseconds");
        writeToDestination.close();
    }
}