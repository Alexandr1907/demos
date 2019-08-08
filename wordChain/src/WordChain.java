import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.
*/
public class WordChain {
    public static void main(String[] args) throws IOException {
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(getLine(getWords(fileNameReader.readLine())));
        }
    }

    private static String[] getWords(String fileName) {

        String[] word;
        ArrayList<String> lines = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis))) {
            lines.add(fileReader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.out.println("---------------------------------------");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        word = getSplitedWords(lines);

        return word;
    }

    private static String[] getSplitedWords(ArrayList<String> lines) {

        ArrayList<String> words = new ArrayList();
        ArrayList<String[]> mas = new ArrayList<>();

        for (String currentString : lines) {
            mas.add(currentString.split(" "));
        }

        for (String[] currentMas : mas) {
            words.addAll(Arrays.asList(currentMas));
        }

        String[] result = words.toArray(new String[0]);

        return result;
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        String[] currentTry = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            currentTry[i] = words[i];
        }

        int counter = 0;

        for(int k = 0; k < words.length; k++) {
            String currentString = currentTry[k];
            currentTry[k] = null;
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (currentTry[j] != null && currentTry[j].toLowerCase().charAt(0) == currentString.toLowerCase().charAt(currentString.length() - 1)) {
                        result.append(currentString + " ");
                        counter++;
                        currentString = currentTry[j];
                        currentTry[j] = null;
                    }
                }
            }
            counter++;
            result.append(currentString);
            if(counter == words.length) {
                break;
            }else {
                //System.out.println(result);
                result = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    currentTry[i] = words[i];
                }
                //System.out.println(Arrays.toString(currentTry));
                counter = 0;
            }
        }


        return result;
    }
}
