package calendar.calendarapppractice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm {
	@NotNull
	@Size(min = 1, max = 127)
	private String first_name;
	
	@NotNull
	@Size(min = 1, max = 127)
	private String last_name;
}
