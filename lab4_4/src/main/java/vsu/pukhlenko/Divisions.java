package vsu.pukhlenko;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Divisions {
    private Map<UUID, String> division = new HashMap<UUID, String>();

    public void add(String name) {
        if (!division.containsValue(name)) {
            division.put(UUID.randomUUID(), name);
        }
    }

    public UUID getIdByName(String name) {
        for (Map.Entry<UUID, String> entry : division.entrySet()) {
            if (Objects.equals(name, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getNameById(UUID id) {
        return division.get(id);
    }

    public void removeObj(String name) {
        division.remove(getIdByName(name));
    }

}
