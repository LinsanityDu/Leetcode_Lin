/*An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true*/

public class ValidWordAbbr {

    public ValidWordAbbr(String[] dictionary) {
        
    }

    public boolean isUnique(String word) {
        
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");



public class ValidWordAbbr {

Map<String, String> map = new HashMap<>();

public ValidWordAbbr(String[] dictionary) {
    for (String dic : dictionary) {
        String key = getKey(dic);
        if (map.containsKey(key)) {
            map.put(key, "");
        } else {
            map.put(key, dic);
        }
    }
}

public boolean isUnique(String word) {
    String key = getKey(word);
    return !map.containsKey(key) || map.get(key).equals(word);
}

private String getKey(String word) {
    String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    return key;
}
}