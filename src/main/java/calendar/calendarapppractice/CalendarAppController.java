package calendar.calendarapppractice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import calendar.calendarapppractice.domain.CalendarApp;
import calendar.calendarapppractice.service.CalendarAppService;
import calendar.calendarapppractice.service.CalendarCreate;

@Controller
@RequestMapping(path = "calendar") // リクエストがマッピングされるURLを定義する
public class CalendarAppController {
	@Autowired
	CalendarAppService calendarAppService;
	
	@Autowired
	CalendarCreate calendarCreate;
	
	@GetMapping // getScheduleメソッドがURLの/scheduleにマッピングされるように指定
	// 画面に値を渡すために、Modelオブジェクトを使用
	String getSchedule(Model model) {
		
		// 現在の日付を取得する
		Calendar cal = Calendar.getInstance(); // カレンダーオブジェクトを生成
		Integer year = cal.get(Calendar.YEAR); // 現在の年(西暦)を取得
		Integer month = cal.get(Calendar.MONTH); // 現在の月を取得.ただし取得できるのは月を表す定数(実際の月-1)なので注意
		Integer dispMonth = month + 1; // 表示する月は+1する必要あり
		
		// findScheduleの結果をModelに設定し、属性名を"schedulesOfTheMonth"として設定
		List<CalendarApp> schedules = calendarAppService.findSchedule(year, dispMonth);
		model.addAttribute("schedulesOfTheMonth", schedules);
		
		// getCalendarで表示する月のカレンダーを取得
		List<Integer> dateList = calendarCreate.getCalendar(year, month);
		model.addAttribute("dateList", dateList);
		
		// 現在の年と月も画面に渡す
		model.addAttribute("year", year);
		model.addAttribute("month", dispMonth);
		
		
		// コントローラのリクエスト処理メソッドの返り値は「ビュー名」すなわち「遷移する画面名」になる
		// SpringBootではデフォルトで「classpath:template/ + ビュー名 + .html」が画面のパスになる
		return "calendar/calendar";
	}
	
}
