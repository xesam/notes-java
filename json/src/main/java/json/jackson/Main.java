package json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> values = new HashMap<>();
        values.put("k1", "value1");
        values.put("k2", "value2");
        values.put("k3", 100);
        values.put("k4", false);
        List<String> items = new ArrayList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");
        values.put("items", items);
        try {
            String js = objectMapper.writeValueAsString(values);
            System.out.println(js);
            Map<String, Object> jsValues = objectMapper.readValue(js, new TypeReference<>() {
            });
            System.out.println(jsValues.get("k1"));
            System.out.println(jsValues.get("k2"));
            System.out.println(jsValues.get("k3"));
            System.out.println(jsValues.get("k4"));
            System.out.println(jsValues.get("k5"));
            System.out.println(jsValues.get("items"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
