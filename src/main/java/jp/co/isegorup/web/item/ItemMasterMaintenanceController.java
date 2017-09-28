package jp.co.isegorup.web.item;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.isegorup.domain.ItemEntity;
import jp.co.isegorup.service.ItemService;

// ControllerアノテーションでSpringに役割を知らせる
@Controller
@RequestMapping("itemMasterMaintenance")
public class ItemMasterMaintenanceController {
	
	private static final String ITEM_SEARCH_SCREEN = "itemMasterMaintenance/search";

	private static final String ITEM_EDIT_SCREEN = "itemMasterMaintenance/edit";

	private static final String REDIRECT_FOR_SERACH = "redirect:/itemMasterMaintenance";
	
	@Autowired
	ItemService itemService;
	
	@ModelAttribute
	ItemMasterMaintenanceForm setUpForm() {
		return new ItemMasterMaintenanceForm();
	}
	
	// ルートのURLをGetでリクエストされた場合
	@GetMapping
	String init(Model model) {
		model.addAttribute("items", null);
		return ITEM_SEARCH_SCREEN;
	}
	
	// ルートのURLにsearch というパラメータを持つPostでリクエストが来た場合
	@GetMapping(path = "search")
	String initSearch(Model model) {
		return ITEM_SEARCH_SCREEN;
	}

	// ルートのURL/searchにsearchというパラメータをもつPostのリクエストが来た場合
	@PostMapping(path = "search" , params = "search")
	String search(Model model) {
		List<ItemEntity> items = itemService.findAll();
		model.addAttribute("items", items);
		return ITEM_SEARCH_SCREEN;
	}
	
	// 更新画面で”編集”の時の処理
	// ルートのURL/editに、パラメータ "register"でpostでリクエストが来た場合 //
	@PostMapping(path = "edit" , params = "goEdit")
	String editItemMasterMaintenaneForm(@RequestParam Integer itemId, ItemMasterMaintenanceForm itemForm) {
		ItemEntity itemEntity = itemService.findOne(itemId);
		BeanUtils.copyProperties(itemEntity, itemForm);
		return ITEM_EDIT_SCREEN;
	}

	// ルートのURL/editで"更新"ボタンを押した場合
	// 引数は、RequestParameterのIdのほかに、@Validated をつけてテスト済みのformが返却される。 //
	@PostMapping(path = "edit" , params = "edit")
	String edit(@RequestParam Integer itemId, @Validated ItemMasterMaintenanceForm itemForm, BindingResult result) {
		if (result.hasErrors()) {
			// Formの中身をセットしたうえで、編集画面を再度呼び出す
			return editItemMasterMaintenaneForm(itemId, itemForm);
		}
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(itemForm, itemEntity);
		itemEntity.setItemId(itemId);
		itemEntity.setRegisterUser("isegroup");
		itemEntity.setRegisterDate(new Date().toString());
		itemService.update(itemEntity);
		return REDIRECT_FOR_SERACH;
	}


	// 更新画面で”登録”の時の処理
	// ルートのURL/editに、パラメータ "register"でpostでリクエストが来た場合 //
	@PostMapping(path = "edit" , params = "goRegister")
	String registerItemMasterMaintenaneForm(ItemMasterMaintenanceForm itemForm) {
		itemForm.setItemProperty3("test");
		return ITEM_EDIT_SCREEN;
	}
	
	// ルートのURL/editで"登録"ボタンを押した場合 //
	// ルートのURL/editで登録した場合
	@PostMapping(path = "edit" , params = "register")
	String register(@Validated ItemMasterMaintenanceForm itemForm, BindingResult result) {
		if (result.hasErrors())  {
			// Formの中身をセットしたうえで、初期画面を呼びだす
			return registerItemMasterMaintenaneForm(itemForm);
		}
		// エラーがなければ登録
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(itemForm, itemEntity);
		itemService.create(itemEntity);
		return REDIRECT_FOR_SERACH;
	}

	// 戻るボタン //
	@PostMapping(path = "edit", params = "goToSearch")
	String goToSearch() {
		return REDIRECT_FOR_SERACH;
	}
	
	// 削除ボタン
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer itemId) {
		itemService.delete(itemId);
		return REDIRECT_FOR_SERACH;
	}
	
}
