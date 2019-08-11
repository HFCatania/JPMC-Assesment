package com.example.jpmcassesment;

import apple.laf.JRSUIUtils;

import java.util.*;

public class ProblemTwo {
    private Map<Character, List<Character>> dialpadMap = new HashMap<>();
    private TreeSet<String> results = new TreeSet<>();

    public ProblemTwo(){
        this.mapMaker();
    }

    private TreeSet<String> converter(String phoneNumber){
        char[] numArr = phoneNumber.toCharArray();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while (count < 4){
            for(int index = 0; index < phoneNumber.length()-1; index++){
                for(int i = 0; i < 4; i++){
                    for (int j =0; j<index; j++){
                        sb.append(this.dialpadMap.get(numArr[j]).get(count));
                    }
                    sb.append(this.dialpadMap.get(numArr[index]).get(i));
                    for(int k = index + 1; k < numArr.length; k++){
                        sb.append(this.dialpadMap.get(numArr[k]).get(count));
                    }
                    results.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            count++;
        }
        return results;
    }


    private void mapMaker(){
        this.dialpadMap.put('0', new ArrayList<>(Arrays.asList('0','0','0','0')));
        this.dialpadMap.put('1', new ArrayList<>(Arrays.asList('1','1','1','1')));
        this.dialpadMap.put('2', new ArrayList<>(Arrays.asList('a','b','c','c')));
        this.dialpadMap.put('3', new ArrayList<>(Arrays.asList('d','e','f','f')));
        this.dialpadMap.put('4', new ArrayList<>(Arrays.asList('g','h','i','i')));
        this.dialpadMap.put('5', new ArrayList<>(Arrays.asList('j','k','l','l')));
        this.dialpadMap.put('6', new ArrayList<>(Arrays.asList('m','n','o','o')));
        this.dialpadMap.put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
        this.dialpadMap.put('8', new ArrayList<>(Arrays.asList('t','u','v','v')));
        this.dialpadMap.put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));
    }

    public static void main(String[] args) {
        ProblemTwo problemTwo = new ProblemTwo();
        TreeSet<String> resultTree = problemTwo.converter("1234567");
        ArrayList<String> results = new ArrayList<>(resultTree);
        System.out.println(String.join(",", results));
    }
}
