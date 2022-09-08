package json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
    static String json = "{\"msg\":\"ok\",\"ret\":0,\"data\":true,\"serverExecutedTime\":3}";

    static class Res {
    }

    static class JRes extends Res {
        public int ret;
        public int ret2;
        public String msg;
        public int serverExecutedTime;
        public Boolean data;
    }

    static <T extends Res> T parse() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    static <T extends Res> T parse(Class<T> klass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, klass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    static <T> T parse(TypeReference<T> t) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JRes jRes1 = Main2.parse(new TypeReference<>() {
        });
        System.out.println(jRes1.data);

        JRes jRes2 = Main2.parse(JRes.class);
        System.out.println(jRes2.data);

        JRes jRes3 = Main2.parse();
        System.out.println(jRes3);
    }
}
