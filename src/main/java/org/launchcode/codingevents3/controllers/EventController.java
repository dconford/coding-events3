package org.launchcode.codingevents3.controllers;


import org.launchcode.codingevents3.data.EventData;
import org.launchcode.codingevents3.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

 //private static List<Event> events = new ArrayList<>();

  @GetMapping
  public String getAllEvents(Model model) {
    model.addAttribute("events", EventData.getAll());
//      model.addAllAttributes(Map<String, String> events);
  return "events/index";
  }

  @GetMapping("create")
  public String renderCreateEventForm() {
    return "events/create";
  }

  @PostMapping("create")
  public String createEvent(@ModelAttribute Event newEvent) {
    EventData.add(newEvent);

  return "redirect:";
  }

  @GetMapping("delete")
  public String renderDeleteEventForm(Model model) {
    model.addAttribute("title", "Delete Events");
    model.addAttribute("events", EventData.getAll());

  return "events/delete";
  }

  @PostMapping("delete")
  public String deleteEvents(@RequestParam(required = false) int[] eventIds) {
    if (eventIds != null) {
      for (int id : eventIds) {
        EventData.remove(id);
      }
    }
  return "redirect:";
  }



}
