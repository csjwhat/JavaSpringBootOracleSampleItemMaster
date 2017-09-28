package jp.co.isegorup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// EntityアノテーションでSpringに役割を知らせる
@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

	// PKは自動採番する。
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMIDSEQ")
    @SequenceGenerator(name = "ITEMIDSEQ", sequenceName = "ITEMIDSEQ", allocationSize = 1)
	private Integer itemId;

	@Column(nullable = false)
	private String itemName;

	private String itemProperty1;
	private String itemProperty2;
	private String itemProperty3;

	@Column(nullable = false)
	private String registerUser;

	@Column(nullable = false)
	private String registerDate;

}
