package org.akj.mybatis.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class Amount {
	private String currency = "CNY";

	private BigDecimal amount;

}
