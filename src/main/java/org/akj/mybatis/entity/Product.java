package org.akj.mybatis.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product {
	private String id;

	private String code;

	private String name;

	private Amount price;

	private String description;

	private boolean inStock = false;

}