package com.ruchengxiao.assignment8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LyricAnalyzer { // score 4
    private HashMap<String, ArrayList<Integer>> map;
    int wordNum;

    public static void main(String[] args) {
        File file1 = new File("/Users/ruchengxiao/MyDocuments/" +
                "neu-sep17-assignments/src/com/ruchengxiao/assignment8/Question2_test4.txt");
        File file2 = new File("/Users/ruchengxiao/MyDocuments/" +
                "neu-sep17-assignments/src/com/ruchengxiao/assignment8/test.txt");
        LyricAnalyzer test = new LyricAnalyzer();
        try {
            test.read(file1);
            test.writeLyrics(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.displayWords();
        System.out.println(test.count());
        System.out.println(test.mostFrequentWord());

    }

    public void read(File file) throws IOException {
        map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        wordNum = 1;
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

            String[] strs = line.split(" ");
            for (int i = 0; i < strs.length; i++) {
                if (i != strs.length - 1) {
                    add(strs[i], wordNum);
                } else {
                    add(strs[i], -wordNum);
                }

                wordNum++;
            }
        }

        wordNum--;
        reader.close();
    }

    private void add(String lyricWord, int wordPosition) {
        if (map.containsKey(lyricWord)) {
            map.get(lyricWord).add(wordPosition);
            //System.out.println(lyricWord + ": " + wordPosition);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(wordPosition);
            //System.out.println(lyricWord + ": " + wordPosition);
            map.put(lyricWord, list);
        }
    }

    public void displayWords() {
        String[] result = map.keySet().toArray(new String[0]);
        Arrays.sort(result);
        for (String key : result) {
            System.out.print(key + ": ");
            String s = Arrays.toString(map.get(key).toArray());
            System.out.println(s.substring(1, s.length() - 1));
        }
    }

    public void writeLyrics(File file) throws IOException {
        String[] result = new String[wordNum];
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            for (int index : entry.getValue()) {
                if (index > 0) {
                    result[index - 1] = entry.getKey() + " ";
                } else {
                    result[-(index + 1)] = entry.getKey() + "\n";
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            writer.write(result[i]);
        }

        writer.close();

    }

    public int count() {
        return map.size();
    }

    public String mostFrequentWord() {
        String[] result = map.keySet().toArray(new String[0]);
        String res = "";
        int max = Integer.MIN_VALUE;
        for (String key : result) {
            if (map.get(key).size() > max) {
                res = key;
                max = map.get(key).size();
            }
        }
        return res;
    }
}
