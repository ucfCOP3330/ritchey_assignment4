public class Application{
   public static void main(String[] args){
       String inputFile = "problem2.txt";
       String outputFile = "unique_word_counts.txt";
      
       DuplicateCounter duplicateCounter = new DuplicateCounter();
       duplicateCounter.count(inputFile);
       duplicateCounter.write(outputFile);
       System.out.println("Data has been written to " + outputFile);
   }
}