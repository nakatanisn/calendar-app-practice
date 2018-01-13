package calendar.calendarapppractice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalendarCreate {
	public List<Integer> getCalendar(Integer year, Integer month) {
		Calendar dispCal = Calendar.getInstance(); // カレンダーオブジェクトを生成
		dispCal.setFirstDayOfWeek(Calendar.MONDAY); // 週の最初の曜日を月曜日に設定（デフォルトでは日曜日始まり）
		dispCal.set(year, month, 1); // 引数に指定した「年」と「月」を設定
		
		int weeks = dispCal.getActualMaximum(Calendar.WEEK_OF_MONTH); // その月に何週まであるのか、最大週を取得（週の最初が月曜か日曜かで週数が変わる）
		int days = dispCal.getActualMaximum(Calendar.DAY_OF_MONTH); // その月に何日まであるのか、最大日を取得

		int firstDayOfWeek = dispCal.get(Calendar.DAY_OF_WEEK); // その月のはじめの曜日を取得
		
		// 画面に表示する日数の枠と日付を入れるListを作成
		List<Integer> list = new ArrayList<>();
		
		int maxNum = weeks * 7; // カレンダーに表示する日数の枠の数を定義
		
		// listを0で初期化する(1-31の日付が入らない部分には0が入る)
		int i = 0;
		while (true) {
			if (maxNum <= i) {
				break;
			}
			list.add(i, 0);
			i++;
		}
				
		int setNum = firstDayOfWeek - 2; // 最初の週で日付を表示しないカレンダーの枠の数を求める 
		if (setNum == -1) { // 日曜日のみマイナスになるので補正する
			setNum = 6;
		} 
		
		// listに日付を設定していく
		int date = 1; // listに設定する日付を初期化
		while (setNum <= maxNum) { // Listの要素は0から始まるので、setNumがはじめに値を入れる要素番号になる
			if (date > days) {
				break;
			}
			list.set(setNum, date); // 既にlistには値が入っているのでsetで置換する(addすると置換されず、要素数が増える)
			setNum++;
			date++;
		}

		return list;
	}
}
