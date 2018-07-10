package biller.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class LoadConfigFile
{
 Properties properties;

 public LoadConfigFile(String fileName)
 {
     properties = new java.util.Properties();
     try
     {
         File f = new File(fileName);
         if (f.exists())
         {
             properties.load(new FileInputStream(fileName));
         }
         else
         {
             properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
         }

     }
     catch (Exception e)
     {
         e.printStackTrace();
     }

 }

 public String getProperty(String key)
 {
     String value = properties.getProperty(key);
     return value;
 }

 public HashMap<String, String> getAllProperty()
 {
     HashMap<String, String> hm = new HashMap<>();
     try
     {
         Enumeration<?> e = properties.propertyNames();
         while (e.hasMoreElements())
         {
             String key = (String) e.nextElement();
             String value = properties.getProperty(key);
             hm.put(key, value);
         }
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
     return hm;
 }
}

