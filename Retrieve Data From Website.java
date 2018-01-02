//http://prettyprinter.de/index.php
//check the first five boxes and seventh box.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        URL url;
        try
        {
            url = new URL("https://www.bing.com/search?q=current+weather");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            boolean found = false;
            String findString=" tabindex=\"0\" data-index=\"5\" aria-label=\"";
            String resultString="";
            while ((inputLine = in.readLine()) != null && !found)
            {
               // System.out.println(inputLine);
                if(inputLine.contains(findString))
                {
                    int index = inputLine.indexOf(findString);
                    //give me the numerical index of the first character of the findString.
                    int IndexOfResultString = index+findString.length();
                    //give me the numerical index of the first character of String content.
                    System.out.println("Index of context: " + IndexOfResultString);
                    found=true;
                    char c=inputLine.charAt(IndexOfResultString);
                    while ( c != '"')
                    {
                        resultString = resultString+c;
                        IndexOfResultString=IndexOfResultString+1;
                        c = inputLine.charAt(IndexOfResultString);
                    }
                }
            }
            System.out.println("Retrieved String: " + resultString);
            in.close();
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("The website is down!!!");
        }
    }
}