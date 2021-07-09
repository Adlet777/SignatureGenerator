package sig_gen;

import org.apache.commons.lang3.StringUtils;


import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;

public class SignatureGenerator {


    public static String implodeArrayUsingStringUtils(String[] arrayToImplode, String separator) {
        return StringUtils.join(arrayToImplode, separator);
    }

    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("pg_merchant_id", "540627");
        map.put("pg_user_id", "1234");
        map.put("pg_post_link", "http://site.kz/post");
        map.put("pg_back_link", "http://site.kz/back");
        map.put("pg_salt", "some random string");

        Map<String, String> treeMap = new TreeMap<String, String>(map);


        LinkedList<String> argsAsLinkedList = new LinkedList<String>(treeMap.values());
        argsAsLinkedList.addFirst("add");
        argsAsLinkedList.addLast("secret");

        String[] listToImplode = argsAsLinkedList.toArray(new String[0]);
        String implodeString = implodeArrayUsingStringUtils(listToImplode, ";");


        System.out.println(DigestUtils.md5Hex(implodeString));

//        System.out.println(implodeString);
    }


}
