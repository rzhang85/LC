public class LC824 {

    public String toGoatLatin(String S) {
        String[] inputs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String a = "a";
        for(String s : inputs){
            String newWord = "";
            if(isVowel(Character.toLowerCase(s.charAt(0)))){
                newWord = s + "ma" + a;
            }
            else{
                newWord = s.substring(1) + s.charAt(0) + "ma" + a;
            }
            a = a + "a";
            sb.append(" " + newWord);
        }

        return sb.toString().substring(1);
    }

    private boolean isVowel(char c){ // helper method for isVowel check
        return (c=='a'|| c=='e'|| c=='i'|| c=='o'||c=='u');
    }
}
