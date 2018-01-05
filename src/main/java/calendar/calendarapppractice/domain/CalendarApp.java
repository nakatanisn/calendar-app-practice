package calendar.calendarapppractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPAのエンティティであることを示す
@Table(name = "schedule") // エンティティに対応するテーブル名を指定
@Data // Lombokを使って自動生成する
@NoArgsConstructor // Lombokで引数のないデフォルトコンストラクタを生成する
@AllArgsConstructor // Lombokで全フィールドを引数に持つコンストラクタを生成する
public class CalendarApp {
	@Id // エンティティの主キーであるフィールドを示す
	@GeneratedValue // 主キーがDBで自動採番されることを示す
	private Integer id;
	
	@Column(nullable = false) // 該当するDBのカラムに対する制約を設定.ここでは「not null」制約を設定
	private Integer year;
	
	@Column(nullable = false)
	private Integer month;
	
	@Column(nullable = false)
	private Integer day;
	
	@Column(nullable = false)
	private Integer day_of_week;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String content;
}
