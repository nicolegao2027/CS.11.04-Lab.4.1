public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {
                balance--;
            }
        }
        if (balance < 0) {
            return false;
        }
        if (balance >0) {
            return false;
        }
        return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        StringBuilder reversed = new StringBuilder();
        reversed.append(num);
        return reversed.reverse().toString();
    }

    // 3. encryptThis
    public static String encryptThis(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(encryptWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private static String encryptWord(String word) {
        if (word.length() == 1) {
            return String.valueOf((int) word.charAt(0));
        }

        StringBuilder encrypted = new StringBuilder();

        // Replace first letter with its ASCII code
        encrypted.append((int) word.charAt(0));

        if (word.length() > 2) {
            // Switch second and last letter
            encrypted.append(word.charAt(word.length() - 1));
            encrypted.append(word.substring(2, word.length() - 1));
            encrypted.append(word.charAt(1));
        } else {
            // For two-letter words, just append the second letter
            encrypted.append(word.charAt(1));
        }

        return encrypted.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (String word : text.split(" ")) {
            // Extract first character code and convert it to a character
            StringBuilder firstCharCode = new StringBuilder();
            int index = 0;
            while (index < word.length() && Character.isDigit(word.charAt(index))) {
                firstCharCode.append(word.charAt(index));
                index++;
            }
            char firstChar = (char) Integer.parseInt(firstCharCode.toString());
            StringBuilder newWord = new StringBuilder().append(firstChar);

            //second and last character switching
            if (index < word.length()) {
                String remaining = word.substring(index);
                if (remaining.length() > 1) {
                    newWord.append(remaining.charAt(remaining.length() - 1)); // Last char
                    newWord.append(remaining, 1, remaining.length() - 1); // Middle part
                    newWord.append(remaining.charAt(0)); // First char
                } else {
                    newWord.append(remaining); // Just one character
                }
            }
            decrypted.append(newWord).append(" ");
        }
        return decrypted.toString().trim();
    }

}