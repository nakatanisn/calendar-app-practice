package calendar.calendarapppractice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalendarCreate {
	public List<Integer> getCalendar() {
		Calendar today = Calendar.getInstance(); // カレンダーオブジェクトを生成
		today.setFirstDayOfWeek(Calendar.MONDAY); // 週の最初の曜日を月曜日に設定（デフォルトでは日曜日始まり）
		
		Calendar firstDay = Calendar.getInstance(); // 月初めの曜日を取得するためのオブジェクトを生成
		firstDay.set(Calendar.DATE, 1); // 1日をセット
		
		int weeks = today.getActualMaximum(Calendar.WEEK_OF_MONTH); // その月に何週まであるのか、最大週を取得（週の最初が月曜か日曜かで週数が変わる）
		int days = today.getActualMaximum(Calendar.DAY_OF_MONTH); // その月に何日まであるのか、最大日を取得
		
		int firstDayOfWeek = firstDay.get(Calendar.DAY_OF_WEEK); // その月のはじめの曜日を取得
		
		// 画面に表示する日数の枠と日付を入れるListを作成
		List<Integer> list = new ArrayList<>();
		
		int maxNum = weeks * 7; // カレンダーに表示する日数の枠の数を定義
		
		// listを0で初期化する
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
