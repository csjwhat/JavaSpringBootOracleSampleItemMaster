package jp.co.isegorup.web.item;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

// 画面との受け渡し
@Data
public class ItemMasterMaintenanceForm {
	private Integer itemId;
	
	// 入力チェックをアノテーションで定義する。
	@NotNull
	@Size(min=1, max=50)
	private String itemName;
	@Size(min=1, max=50)
	private String itemProperty1;
	@Size(min=1, max=50)
	private String itemProperty2;
	@Size(min=1, max=50)
	private String itemProperty3;
	private String registerUser;
	private String registerDate;
}
