package calendar.calendarapppractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendar.calendarapppractice.domain.CalendarApp;
import calendar.calendarapppractice.repository.CalendarAppRepository;

@Service
public class CalendarAppService {
	@Autowired
	CalendarAppRepository calendarAppRepository;
	
	public CalendarApp create(CalendarApp calendarApp) {
		return calendarAppRepository.save(calendarApp);
	}
	
	public CalendarApp update(CalendarApp calendarApp) {
		return calendarAppRepository.save(calendarApp);
	}
	
	public void delete(Integer id) {
		calendarAppRepository.delete(id);
	}
	
	public List<CalendarApp> findSchedule(Integer year, Integer month) {
		return calendarAppRepository.findByYearAndMonth(year, month);
	}
}
