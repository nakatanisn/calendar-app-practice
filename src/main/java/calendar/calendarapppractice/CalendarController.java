package calendar.calendarapppractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import calendar.calendarapppractice.repository.CalendarRepository;

@Controller
@RequestMapping(path = "/schedule")
public class CalendarController {
	@Autowired
	CalendarRepository calendarRepository;
	
	
}
