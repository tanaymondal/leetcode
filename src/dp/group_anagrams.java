package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class group_anagrams {

    public static void main(String[] args) {

        String[] array = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(array));

    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String key = new String(getCharArray(strs[i]));
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    static char[] getCharArray(String str) {
        char[] m = new char[26];
        for (int i = 0; i < str.length(); i++) {
            m[str.charAt(i) - 'a']++;
        }
        return m;
    }
}
