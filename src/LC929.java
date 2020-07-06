import java.util.HashSet;

public class LC929 {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailList = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String email: emails){
            // split local and domain names
            String[] str = email.split("@");
            // ignore "." in local name
            str[0] = str[0].replace(".", "");
            // remove everything after "+"
            String[] local = str[0].split("\\+");
            sb = new StringBuilder();
            sb.append(local[0]);
            sb.append("@");
            sb.append(str[1]);
            emailList.add(sb.toString());

        }


        return emailList.size();
    }
}
