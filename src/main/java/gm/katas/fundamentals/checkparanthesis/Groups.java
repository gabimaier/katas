package gm.katas.fundamentals.checkparanthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.codewars.com/kata/54b80308488cb6cd31000161/train/java
 */

public class Groups {
    final static Map<Character, Character> pairMap = initializePairsMap();

    public static boolean groupCheck(String s){
        if(s==null || s.length()==0){
            return true;
        }
        final int length = s.length();
        if(length % 2 != 0){
            return false;
        }

        final Stack<Character> waitingForClosure = new Stack<>();
        for (int i = 0; i < length; i++) {
            final Character crtChar = s.charAt(i);
            checkValidity(crtChar);

            if(pairMap.containsKey(crtChar)){
                waitingForClosure.push(crtChar);
            }
            else {
                if(waitingForClosure.isEmpty()){
                    return false;
                }
                final Character expectedChar = pairMap.get(waitingForClosure.peek());
                if(crtChar.equals(expectedChar)){
                    waitingForClosure.pop();
                }
                else {
                    return false;
                }
            }
        }

        return waitingForClosure.isEmpty();
    }

    private static void checkValidity(Character crtChar) {
        if(!pairMap.containsKey(crtChar) && !pairMap.containsValue(crtChar)){
            throw new IllegalArgumentException(crtChar.toString());
        }
    }

    private static Map<Character, Character> initializePairsMap() {
        final Map<Character, Character> pairMap = new HashMap<>(3);
        pairMap.put('(', ')');
        pairMap.put('[', ']');
        pairMap.put('{', '}');
        return pairMap;
    }
}
