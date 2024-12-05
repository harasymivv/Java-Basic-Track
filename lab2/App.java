package lab2;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    int C3 = 4%3;
    int C17 = 4%17;

    System.out.println("C3 = " + C3 + "\nC17 = " + C17 );
      // Вхідний текстовий рядок
    Scanner scanner = new Scanner(System.in);
        
    System.out.println("Enter a text:");
    String inputText = scanner.nextLine(); 
      
      try {
          // Виклик методу трансформації тексту
          String transformedText = SentenceTransformer.transformSentences(inputText);
          
          // Виведення результату
          System.out.println("Original text: " + inputText);
          System.out.println("Transformed text: " + transformedText);
      } catch (IllegalArgumentException e) {
          // Обробка винятку, якщо передано некоректний текст
          System.err.println("Error: " + e.getMessage());
      }

      scanner.close();
  }
}
