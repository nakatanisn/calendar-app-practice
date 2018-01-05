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

@Controller
@RequestMapping(path = "calendar") // リクエストがマッピングされるURLを定義する
public class CalendarAppController {
	@Autowired
	CalendarAppService calendarAppService;
	
	// 現在の日付を取得する
	Calendar now = Calendar.getInstance(); // カレンダーオブジェクトを生成
	Integer year = now.get(Calendar.YEAR);
	Integer month = now.get(Calendar.MONTH) + 1;
	
	// 曜日はどうするか検討
	
	@GetMapping // listメソッドがURLの/scheduleにマッピングされるように指定
	// 画面に値を渡すために、Modelオブジェクトを使用
	String getSchedule(Model model) {
		
		// findScheduleの結果をModelに設定し、属性名を"schedulesOfTheMonth"として設定
		List<CalendarApp> schedules = calendarAppService.findSchedule(year, month);
		model.addAttribute("schedulesOfTheMonth", schedules);
		
		// 現在の年と月も画面に渡す
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		
		// コントローラのリクエスト処理メソッドの返り値は「ビュー名」すなわち「遷移する画面名」になる
		// SpringBootではデフォルトで「classpath:template/ + ビュー名 + .html」が画面のパスになる
		return "calendar/calendar";
	}
	
}
