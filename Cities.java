import java.util.HashMap; //import the HashMap Class
/**
 * Write a description of class Cities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cities
{
    public static void main(String[] args){
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        
        // Add keys and values (Country, city)
        capitalCities.put("New Zealand", "Wellington");
        capitalCities.put("China", "Beijing");
        capitalCities.put("Japan", "Tokyo");
        capitalCities.put("Austria", "Vienna");
        capitalCities.put("Slovakia", "Bratislava");
        capitalCities.put("France", "Paris");
        System.out.println(capitalCities);
        System.out.println(capitalCities.get("New Zealand"));
        
        // remove keys
        capitalCities.remove("France");
        System.out.println(capitalCities);
        // check the size
        System.out.println(capitalCities.size());
        
        // Prints all keys
        for(String i : capitalCities.keySet()){
            System.out.println(i);
            System.out.println();
        }
        // Print values
        for(String i : capitalCities.values()){
            System.out.println(i);
            System.out.println();
        }
        // Print keys and values
        for(String i : capitalCities.keySet()){
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
            System.out.println();
        }
        
        // Loop through hashmap and print out all countries that contain'a'
        for(String country: capitalCities.keySet()){
            System.out.println();
            if (country.toLowerCase().contains("a")){
                System.out.println("Country: " + country + " Capital: " + capitalCities.get(country));
            }
        }
    }
}
