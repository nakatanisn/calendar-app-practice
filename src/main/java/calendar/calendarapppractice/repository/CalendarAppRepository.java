package calendar.calendarapppractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import calendar.calendarapppractice.domain.CalendarApp;

public interface CalendarAppRepository extends JpaRepository<CalendarApp, Integer>{
	// Spring Data JPAのfindByメソッドを使って、メソッド名からクエリを作成
	
	// 年(year)と月(month)を指定して予定の一覧を取得する
	List<CalendarApp> findByYearAndMonth(Integer year, Integer month);
}
