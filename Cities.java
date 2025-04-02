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
    }
}
