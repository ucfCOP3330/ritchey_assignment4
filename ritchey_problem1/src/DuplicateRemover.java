import java.util.Scanner;
import java.io.File;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;


public class DuplicateRemover {
   private Set<String> uniqueWords;
  
   public void remove(String dataFile) throws FileNotFoundException
   {
       String word;
       uniqueWords = new HashSet<String>();
       Scanner newInput=new Scanner(new File(dataFile));
       while(newInput.hasNext())
       {
           word = newInput.next();
		   word = makeLowerCase(word);
           uniqueWords.add(word);
       }
       newInput.close();
      
      
   }
  
  
   public void write(String outputFile) throws IOException
   {

		FileWriter newFile = null; 
		File testFile = new File(outputFile);

		if(testFile.exists())
			{
				newFile=new FileWriter(testFile,true);
				Iterator counter=uniqueWords.iterator();

				while(counter.hasNext())
				{
					String newString=(String)counter.next();
					newFile.write(newString+"\n");     
				}
				newFile.close();
				System.out.println("New Input Added");
  
			}
		else
			{

				testFile.createNewFile();
				newFile=new FileWriter(testFile);
				Iterator counter=uniqueWords.iterator();

				while(counter.hasNext())
				{
					String newString=(String)counter.next();
					newFile.write(newString+"\n");     
				}
				newFile.close();
				System.out.println("New Input Added");
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