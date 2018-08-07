package com.healthec.Practice;

import java.util.HashMap;
import java.util.Set;

public class DuplicateCharInString {

    public static void getduplicateChar(String input){

        char[]chArray = input.toCharArray();
        HashMap<Character,Integer>charList = new HashMap();
        for(char ch : chArray ){
            if(charList.containsKey(ch)){
                charList.put(ch,charList.get(ch)+1);
            }else
                charList.put(ch,1);
        }
        Set<Character>keys = charList.keySet() ;
        for(char k : keys){
            if(charList.get(k)>1){
                System.out.println(k+"--->"+charList.get(k));
            }
        }

    }

    public static void main(String[] args) {
        getduplicateChar("Java2Novice");
    }
}
