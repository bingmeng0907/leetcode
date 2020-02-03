package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
           int size = queue.size();
           for(int i=0; i<size; i++) {
               String word = queue.pollFirst();
               char[] chs = word.toCharArray();
               for(int j=0; j<chs.length; j++) {
                   char tmp = chs[j];
                   for(char ch='a'; ch<='z';ch++) {
                       chs[j] = ch;
                       String newWord = new String(chs);
                       if (wordSet.contains(newWord)) {
                           if (newWord.equals(endWord)) {
                               return count+1;
                           }
                           wordSet.remove(newWord);
                           queue.add(newWord);
                       }
                   }
                   chs[j] = tmp;
               }
           }
           count++;
        }
        return 0;
    }
}
