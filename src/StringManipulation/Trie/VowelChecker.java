package StringManipulation.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelChecker {
    static class Solution {
        List<Character> vowels = Arrays.asList('a','e','i','o','u');
        class Trie{
            boolean isEnd;
            Trie small[];
            Trie caps[];

            Trie(){
                small = new Trie[26];
                caps = new Trie[26];
            }
        }

        private void insert(String word, int index, Trie head) {
            if(word.length() == index){
                head.isEnd = true;
                return;
            }
            char curr = word.charAt(index);
            if(Character.isLowerCase(curr)){
                head.small[curr - 'a'] = (head.small[curr - 'a'] == null) ? new Trie() : head.small[curr - 'a'];
                insert(word, index + 1, head.small[curr - 'a']);
            }
            else{
                head.caps[curr - 'A'] = (head.caps[curr - 'A'] == null) ? new Trie() : head.caps[curr - 'A'];
                insert(word, index + 1, head.caps[curr - 'A']);
            }
        }

        private String search(char word[],char res[],int index, Trie head) {

            if(word.length == index) {
                if (head.isEnd)
                    return new String(res);
                else
                    return "";
            }

            char curr = word[index];

            if(Character.isLowerCase(curr) && head.small[curr - 'a'] != null) {
                res[index] = curr;
                return search(word, res, index + 1, head.small[curr - 'a']);
            }

            if(Character.isUpperCase(curr) && head.caps[curr - 'A'] != null) {
                res[index] = curr;
                return search(word, res, index + 1, head.caps[curr - 'A']);
            }

            if(Character.isLowerCase(curr) && head.caps[Character.toUpperCase(curr) - 'A'] != null) {
                res[index] = Character.toUpperCase(curr);
                return search(word, res, index + 1, head.caps[Character.toUpperCase(curr) - 'A']);
            }

            if(Character.isUpperCase(curr) && head.small[Character.toLowerCase(curr) - 'a'] != null) {
                res[index] = Character.toLowerCase(curr);
                return search(word, res, index + 1, head.small[Character.toLowerCase(curr) - 'a']);
            }

            if(vowels.contains(curr)){
                for(char x : vowels)
                    if(x != curr) {
                        word[index] = x;
                        String result =  search(word, res, index, head);
                        if(result.length() != 0) return result;
                    }
            }

            return "";
        }

        public String[] spellchecker(String[] wordlist, String[] queries) {
            Trie head = new Trie();
            for(String x : wordlist){
                insert(x, 0, head);
            }

            String res[] = new String[queries.length];
            int i = 0;
            for(String x : queries){
                res[i++] = search(x.toCharArray(), new char[x.length()], 0, head);
            }

            return res;
        }
    }

    public static void main(String args[]) {
        String res[] = new Solution().spellchecker(new String[]{"KiTe","kite","hare","Hare"}, new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});
        for(String x : res)
            System.out.println(x);
    }
}
