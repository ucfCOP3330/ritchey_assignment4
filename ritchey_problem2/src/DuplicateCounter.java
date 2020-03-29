import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.util.HashMap;


public class DuplicateCounter{
   private HashMap<String, Integer> wordCounter;
   public DuplicateCounter(){
       wordCounter = new HashMap<String, Integer>();
   }

   public void count(String dataFile) 
	{
       wordCounter.clear();
       try{
           Scanner newInput = new Scanner(new File(dataFile));
           String word;
           while(newInput.hasNext()){
               word = newInput.next();
               word = makeLowerCase(word);
               if(!word.equals("")) {
                   if(wordCounter.get(word) == null)
                       wordCounter.put(word, 1);
                   else
                       wordCounter.put(word, wordCounter.get(word) + 1);
               }
           }
           newInput.close();
       }
       catch(Exception e){
           System.out.println("Something went wrong.");
    
       }
   }


   public void write(String outputFile){
       try{
           FileWriter newFile = new FileWriter(new File(outputFile));
           for(String word : wordCounter.keySet()){
               newFile.write(word + " " + wordCounter.get(word) +"\n");
           }
           newFile.close();
       }
       catch(Exception e){
           System.out.println("Something went wrong.");
    
       }
   }

   private String makeLowerCase(String word){
       String whiteSpace = "";
       for(int i = 0; i < word.length(); i++){
           char atDigitI = word.charAt(i);
           if(Character.isAlphabetic(atDigitI))
               whiteSpace = whiteSpace + atDigitI;
       }
       return whiteSpace.toLowerCase();
   }
   
}

