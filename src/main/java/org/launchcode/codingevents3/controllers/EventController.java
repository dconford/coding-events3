package org.launchcode.codingevents3.controllers;

import org.launchcode.codingevents3.data.EventData;
import org.launchcode.codingevents3.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

  @GetMapping
  public String getAllEvents(Model model) {
    model.addAttribute("events", EventData.getAll());
    return "events/index";
  }

  @GetMapping("create")
  public String renderCreateEventForm() {
    return "events/create";
  }

  @PostMapping("create")
  public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
    if(errors.hasErrors()) {
      model.addAttribute("title", "Create Event");
      model.addAttribute( "errorMsg", "Bad data!");
      return "events/create";
    }
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
  public String deleteEvents(@RequestParam(required = false) Integer[] eventIds) {
    if (eventIds != null) {
      for (Integer id : eventIds) {
        EventData.remove(id);
      }
    }
    return "redirect:";
  }

  @GetMapping("delete/{eventId}")
  public String deleteEvent(Model model, @PathVariable Integer eventId) {
    EventData.remove(eventId);
    model.addAttribute("events", EventData.getAll());
    return "events/index";
  }

  @GetMapping("edit/{eventId}")
  public String renderEditForm(Model model, @PathVariable Integer eventId) {
    // controller code will go here
    EventData.getById(eventId);
    model.addAttribute("title", "Edit: " + EventData.getById(eventId).getName());
    model.addAttribute("events", EventData.getById(eventId));
    return "events/edit";
  }

  @PostMapping("edit")
  public String processEditForm(Integer eventId, String name, String description) {
    // controller code will go here
    EventData.getById(eventId).setName(name);
    EventData.getById(eventId).setDescription(description);
    return "redirect:";
  }

  @GetMapping("menuedit")
  public String renderMenueditEventForm(Model model) {
    model.addAttribute("title", "Edit Event");
    model.addAttribute("events", EventData.getAll());
    return "events/menuedit";
  }


  @PostMapping("menuedit")
  public String processMenuEditForm(Integer eventIds, Model model) {
    // controller code will go here
      EventData.getById(eventIds);
      model.addAttribute("title", "Edit: " + EventData.getById(eventIds).getName());
      model.addAttribute("events", EventData.getById(eventIds));
    return "events/edit";
  }

}
