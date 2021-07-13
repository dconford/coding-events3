package org.launchcode.codingevents3.data;

import org.launchcode.codingevents3.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

  private static final Map<Integer, Event> events = new HashMap<>();

  public static Collection<Event> getAll() {
    return events.values();
  }

  public static void add(Event event) {
    events.put(event.getId(), event);
  }

  public static Event getById(Integer id) {
    return events.get(id);
  }

  public static void remove(Integer id) {
      events.remove(id);
  }

}
