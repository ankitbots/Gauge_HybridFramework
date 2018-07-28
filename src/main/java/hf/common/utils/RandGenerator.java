package hf.common.utils;

import java.util.UUID;

/**
 * Created by AnkitNigam on 7/28/2018.
 */
public class RandGenerator {
    public static String getRandString(String type, int len, String sufix){
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUID.randomUUID().toString();
        switch (type.toUpperCase()) {
            case "EMAIL":
                stringBuilder.append(uuid.replace("-","").substring(0,len)).append("@").append(sufix);
                break;
            default:
                stringBuilder.append(uuid).append(uuid.replace("-","").substring(0,len)).append(sufix);
        }

        return stringBuilder.toString();
    }
}
