package ru.job4j.userconvert;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        list
                .forEach(u -> {
                    result.put(u.getId(), u);
                });
        return result;
    }
}
