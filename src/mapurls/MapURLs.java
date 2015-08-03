
package mapurls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author khaledd
 */
public class MapURLs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MapURLs obj = new MapURLs();
        obj.mapURL("K:\\URL Analysis\\Data\\allMappedURLs_User_researchers\\url_map");
        
    }
    
    public void mapURL(String inputFile)
    {
        BufferedReader br=null;
        String line = "";
        
        Map<String,List<String>> url_map = new HashMap<String,List<String>>();
        int count=0;
        try{
            br = new BufferedReader(new FileReader(inputFile));
            
            while ((line = br.readLine()) != null) {
                String row[]=line.split("\t");
                if(url_map.containsKey(row[0])){                                    //if contains the short url in the map
                    List<String> url_list_by_same_short_url=url_map.get(row[0]);    //find out the list of expanded urls under the same short url
                    url_list_by_same_short_url.add(row[1]);                         //add the new expanded url in the list
                    url_map.put(row[0], url_list_by_same_short_url);                //add the updated list with the same short url in the map
                    
                } else {
                    List<String> url_list_by_same_short_url = new ArrayList<String>();  //if not contains the short url in the map create a new list for that short url
                    url_list_by_same_short_url.add(row[1]);                             //add the expanded url under the newly gotted short url short url list
                    url_map.put(row[0], url_list_by_same_short_url);                    //add this new list under the newly gotted short url    
                }
                /*if(url_map.containsKey(row[1])){
                    List<String> url_list_by_same_short_url=url_map.get(row[1]);
                    url_list_by_same_short_url.add(row[0]);
                    url_map.put(row[1], url_list_by_same_short_url);
                    
                } else {
                    List<String> url_list_by_same_short_url = new ArrayList<String>();
                    url_list_by_same_short_url.add(row[0]);
                    url_map.put(row[1], url_list_by_same_short_url);
                }*/
                
                
            } 
            Map<String,String> standard_url_map = new HashMap<String,String>();         //create a map for unify a short url with the expanded url
            
            for (Map.Entry<String, List<String>> urls : url_map.entrySet()) {
                    
                //System.out.println(urls.getKey()+"\t"+Arrays.toString(urls.getValue().toArray())); //print the maped urls
                
                String standart_url=getLogestURLs(urls.getValue());                     //pass the list of expanded url under a same shorted url and mapped the longest url for the short url
                standard_url_map.put(urls.getKey(), standart_url);
            }
            for (Map.Entry<String, String> urls : standard_url_map.entrySet()) {
                    
                System.out.println(urls.getKey()+"\t"+urls.getValue());
                
            }
                       
            
            br.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getLogestURLs(List<String> url_map_list)
    {
        Comparator<String> x = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                String str1[]=o1.split(",");
                String str2[]=o2.split(",");
                if(str1[0].length() > str2[0].length())
                    return -1;

                if(str2[0].length() > str1[0].length())
                    return 1;

                return 0;
            }
        };

        Collections.sort(url_map_list,  x);                     //short the expanded urls by length 
        String longest_url=url_map_list.get(0);                 //get which is longest url
        
        return longest_url;
           
    }
}
