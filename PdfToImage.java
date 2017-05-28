import java.io.*;
import java.util.Scanner;

public class PdfToImage
{
    // Input Objects
    String filename;
    File openFile;
    FileInputStream in;

    // Output Objects
    File writeFile;
    String writeName;
    FileOutputStream out;

    int[] file, matches, imgStart, imgEnd;

    // Counts the number of matches found
    int matchIndex = 0;
    int numImages;

    public PdfToImage(String filename) throws IOException
    {
        this.filename = filename;
        openFile = new File(filename);
        in = new FileInputStream(openFile);

        file    = new int[(int) openFile.length()+5];
        matches = new int[(int) openFile.length()];
    }

    public void loadFile() throws IOException
    {
        boolean ended = false;
        int i = 0;
        while ( !ended )
        {
            file[i] = in.read();
            if (file[i] == -1)
            {
                ended = true;
            }
            if (file[i] == 255)
            {
                matches[matchIndex++] = i;
            }
            i++;
        }
        in.close();
    }

    public void fillStartEndArrays() throws IOException
    {
        imgStart = new int[matches.length];
        imgEnd   = new int[matches.length];
        numImages = 0;

        for (int k=0; k<matchIndex; k++)
        {
            if (file[matches[k]+1] == 216 && file[matches[k]+2] == 255)
            {
                imgStart[numImages++] = matches[k];
            }
        }

        numImages = 0;
        for (int k=0; k<matchIndex; k++)
        {
            if (file[matches[k]+1] == 217)
            {
                imgEnd[numImages++] = matches[k];
            }
        }
    }

    public void saveImages() throws IOException
    {
        // Loop through each image
        for (int l=0; l<numImages; l++)
        {

            writeName = filename.substring(0, filename.indexOf('.')) + "/out" + l + ".jpg";
            writeFile = new File(writeName);
            out = new FileOutputStream(writeFile);

            // Write data for single image
            for (int m=imgStart[l]; m<=imgEnd[l]+1; m++)
            {
                out.write(file[m]);
            }
            out.close();
        }
    }

    public void run() throws IOException
    {
        double startTime = System.nanoTime();
        loadFile();
        fillStartEndArrays();
        saveImages();

        double endTime = System.nanoTime();
        double duration = (endTime - startTime);
        System.out.println("This took: " + (duration/1000000000) +" s to run");
    }

    public static void main(String[] args) throws IOException
    {
        for (int i=0; i<args.length; i++)
        {
            PdfToImage x = new PdfToImage(args[i]);
            {
                x.run();
            }
        }
    }
}
