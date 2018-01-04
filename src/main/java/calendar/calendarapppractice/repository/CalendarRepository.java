package calendar.calendarapppractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import calendar.calendarapppractice.domain.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	// Spring Data JPAのfindByメソッドを使って、メソッド名からクエリを作成
	
	// 年(year)と月(month)を指定して予定の一覧を取得する
	List<Calendar> findByYearAndMonth(Integer year, Integer month);
}
