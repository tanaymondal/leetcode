package array;

import java.util.ArrayList;
import java.util.List;

@NotResolved(reason = "My trial. Not done yet.")
public class encode_decode_string {

    public static void main(String[] args) {
        // "neet","code","love","you"
        // "we","say",":","yes","!@#$%^&*()"
        List<String> lists = new ArrayList<String>();
        lists.add("we");
        lists.add("say");
        lists.add(":");
        lists.add("yes");
        lists.add("!@#$%^&*()");

        String data = Solution.encode(lists);
        System.out.println(data);
        List<String> list = Solution.decode(data);
        System.out.println(list);
    }

    static class Solution {

        public static String encode(List<String> strs) {
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < strs.size(); i++) {
                String data = strs.get(i);
                r.append(data.length()).append(data);
            }
            return r.toString();
        }

        public static List<String> decode(String str) {
            List<String> list = new ArrayList<>();
            char[] array = str.toCharArray();
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (Character.isDigit(array[i])) {
                    if (array[i] == '0') {
                        if (!number.isEmpty()) {
                            number.append(array[i]);
                        } else {
                            list.add("");
                        }
                    } else {
                        number.append(array[i]);
                    }
                } else {
                    int startIndex = i;
                    int endIndex = startIndex + Integer.parseInt(number.toString());
                    list.add(getString(array, startIndex, endIndex));
                    i = endIndex - 1;
                    number.setLength(0);
                }
            }
            return list;
        }

        static String getString(char[] array, int startIndex, int endIndex) {
            StringBuilder builder = new StringBuilder();
            for (int i = startIndex; i < endIndex; i++) {
                builder.append(array[i]);
            }
            return builder.toString();
        }
    }
}
