package lab2;

public class SentenceTransformer {

    public static String transformSentences(String text) {
        // Перевірка вхідного тексту на коректність
        if (text == null || text.trim().length() == 0) {
            throw new IllegalArgumentException("Text cannot be empty");
        }
        
        // Додавання роздільника в кінець, якщо його немає
        if (!text.endsWith(".") && !text.endsWith("!") && !text.endsWith("?")) {
            text += ".";
        }
        
        String result = "";
        int startIndex = 0;
        
        // Обробка кожного речення
        while (startIndex < text.length()) {
            // Знаходження кінця речення
            int endIndex = findEndOfSentence(text, startIndex);
            
            // Витягування речення
            String sentence = text.substring(startIndex, endIndex + 1);
            
            // Трансформація речення
            String transformedSentence = transformSingleSentence(sentence);
            
            // Додавання трансформованого речення до результату
            result += transformedSentence + " ";
            
            // Перехід до наступного речення
            startIndex = endIndex + 1;
            
            // Пропуск пробілів
            while (startIndex < text.length() && text.charAt(startIndex) == ' ') {
                startIndex++;
            }
        }
        
        return result.trim();
    }
    

    private static int findEndOfSentence(String text, int startIndex) {
        for (int i = startIndex; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                return i;
            }
        }
        return text.length() - 1;
    }
    

    private static String transformSingleSentence(String sentence) {
        // Видалення пробілів на початку та в кінці
        sentence = sentence.trim();
        
        // Пошук першого та останнього прогалу
        int firstSpaceIndex = sentence.indexOf(' ');
        int lastSpaceIndex = sentence.lastIndexOf(' ');
        
        // Якщо в реченні менше двох слів, повертаємо його без змін
        if (firstSpaceIndex == -1 || firstSpaceIndex == lastSpaceIndex) {
            return sentence;
        }
        
        // Витягування першого та останнього слова
        String firstWord = sentence.substring(0, firstSpaceIndex);
        String lastWord = sentence.substring(lastSpaceIndex + 1, sentence.length() - 1);
        
        // Створення трансформованого речення
        return lastWord + sentence.substring(firstSpaceIndex, lastSpaceIndex + 1) + 
               firstWord + sentence.charAt(sentence.length() - 1);
    }
}
