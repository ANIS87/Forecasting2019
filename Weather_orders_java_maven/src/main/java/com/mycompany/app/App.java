package com.mycompany.app;
//necessary components are imported
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import com.mycompany.model.Order;
import com.mycompany.model.Orders;
import com.mycompany.utils.ParseXmlFile;
import com.mycompany.utils.WriteInXml;
import com.thoughtworks.xstream.XStream;
/**
 * Hello world!
 *
 */


public class App 
{
    public static void helpme()
    {
    	
    	String message=" Pour utiliser ce module, il faut indiquer le fichier xml d'entree et le fichier de sortie ,avec options -i et -o \n "
    			+ "par exemple java -jar my-app-1.0-SNAPSHOT.jar -i testinput.xml -o testoutput.xml";
    	System.out.println(message);
    }
	
    public static void main( String[] args )throws IOException, URISyntaxException, JAXBException{
    	String filename="";
    	String outputfile="";
    	
    	if(args.length==4)
    	{
           for(int i=0;i<4;i++)
             {
    	       if(args[i].equalsIgnoreCase("-i") ||args[i].equalsIgnoreCase("-input") )
    	         {
                filename=args[i+1];
    	          }
    	          if(args[i].equalsIgnoreCase("-o") ||args[i].equalsIgnoreCase("-output") )
    	        	 outputfile=args[i+1];
                   }
    	}
    	
    	if(args.length<4 || filename.isEmpty())
    	{
    		helpme();	
    	}
    	else
    	{
        
    	ParseXmlFile parsexml=new ParseXmlFile();
    	WriteInXml writeinxml=new WriteInXml();
    	Map<String,String> result=ParseXmlFile.parsefile(filename,outputfile);
        GetResponseApi test=new GetResponseApi();
        //test.getdata(result);
    	}
    	
      
       
       
    }
}

