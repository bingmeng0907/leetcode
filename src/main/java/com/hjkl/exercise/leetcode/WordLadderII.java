package com.hjkl.exercise.leetcode;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        List<String> path = new ArrayList<>();
        Map<String,Set<String>> graph = new HashMap<>();
        bfs(beginWord, endWord, dict, graph);
        dfs(beginWord, endWord, graph, path, ret);
        return ret;
    }

    private void dfs(String curWord, String endWord, Map<String, Set<String>> graph, List<String> path, List<List<String>> ret) {
        path.add(curWord);
        if (curWord.equals(endWord)) {
            ret.add(new ArrayList<>(path));
        } else if (graph.containsKey(curWord)){
            for(String next : graph.get(curWord)) {
                dfs(next, endWord, graph, path, ret);
            }
        }
        path.remove(path.size()-1);
    }

    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String,Set<String>> graph) {
        Set<String> visited = new HashSet<>();
        Set<String> toVisit = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        toVisit.add(beginWord);
        boolean found = false;
        while(!queue.isEmpty()) {
            visited.addAll(toVisit);
            toVisit.clear();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String word = queue.poll();
                List<String> childs = getNextChilds(word, dict);
                for(String child : childs) {
                    if (child == endWord) found = true;
                    if (!visited.contains(child)) {
                        if (!graph.containsKey(word)) {
                            graph.put(word, new HashSet<>());
                        }
                        graph.get(word).add(child);
                    }
                    if (!visited.contains(child) && !toVisit.contains(child)) {
                        queue.offer(child);
                        toVisit.add(child);
                    }
                }
            }
            if (found) break;
        }
    }

    private List<String> getNextChilds(String word, Set<String> dict) {
        List<String> childs = new ArrayList<>();
        char[] chs = word.toCharArray();
        for(int i=0; i<chs.length; i++) {
            char t = chs[i];
            for(char c='a'; c<='z'; c++) {
                if (c == t) continue;
                chs[i] = c;
                String child = new String(chs);
                if (dict.contains(child)) childs.add(child);
            }
            chs[i] = t;
        }
        return childs;
    }

    public static void main(String[] args) {
        String b = "hit";
        String e = "cog";
        String[] ar = {"hot","dot","dog","lot","log","cog"};
        new WordLadderII().findLadders(b, e, Arrays.asList(ar));
    }
}
