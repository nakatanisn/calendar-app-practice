package calendar.calendarapppractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendar.calendarapppractice.domain.Calendar;
import calendar.calendarapppractice.repository.CalendarRepository;

@Service
public class CalendarService {
	@Autowired
	CalendarRepository calendarRepository;
	
	public Calendar create(Calendar calendar) {
		return calendarRepository.save(calendar);
	}
	
	public Calendar update(Calendar calendar) {
		return calendarRepository.save(calendar);
	}
	
	public void delete(Integer id) {
		calendarRepository.delete(id);
	}
	
	public List<Calendar> findSchedule(Integer year, Integer month) {
		return calendarRepository.findByYearAndMonth(year, month);
	}
}
