public class LC520 {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1)
            return true;

        // case 1, all capital case if the first one is upper case.
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            for(int i = 2; i < word.length(); i ++){
                if(!Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        else{

            // case 2, no matter what is first chararcter, all letter after first need to be lower case.
            for(int i = 1; i < word.length(); i ++){
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }



        return true;
    }
}
