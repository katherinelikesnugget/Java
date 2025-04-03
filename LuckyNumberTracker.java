import java.util.HashMap;
/**
 * Write a description of class LuckyNumberTracker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LuckyNumberTracker
{
     public static void main(String[] args){
         HashMap<String, Integer> luckyNumber = new HashMap<String, Integer>();
         
         // Add keys and values (Person, Lucky Number)
         luckyNumber.put("Katherine", 8);
         luckyNumber.put("Katelyn", 3);
         luckyNumber.put("Sara", 65);
         luckyNumber.put("Tamsin", 7);
         luckyNumber.put("Serena", 100);
         
         // Print out Katherine's lucky Number
         System.out.println(luckyNumber.get("Katherine"));
         System.out.println();
         // Print out entire HashMap
         System.out.println(luckyNumber);
         System.out.println();
         // Remove a student
         luckyNumber.remove("Katelyn");
         System.out.println("Katelyn has been removed");
         System.out.println();
         // Get size of HashMap
         System.out.println(luckyNumber.size());
         System.out.println(luckyNumber);
         System.out.println();
         
         // Print students names (keys)
         for(String i : luckyNumber.keySet()){
             System.out.println(i);
             System.out.println();
         }
         // Print lucky numbers (values)
         for(Integer i : luckyNumber.values()){
             System.out.println(i);
             System.out.println();
         }
         // Print names and lucky numbers (Keys and values)
         for(String i : luckyNumber.keySet()){
             System.out.println("Key: " + i + " Value: " + luckyNumber.get(i));
         }
         
         // Loop through hashmap and print out all students with lucky number > 10
         for(Integer number: luckyNumber.values()){
             System.out.println();
             if (number >= 10){
                 System.out.println("Student: " + luckyNumber.get(number) + "Lucky Number: " + number);
             }
         }
     }
    }
