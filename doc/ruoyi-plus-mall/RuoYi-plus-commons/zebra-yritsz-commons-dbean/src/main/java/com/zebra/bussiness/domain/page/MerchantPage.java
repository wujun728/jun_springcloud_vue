package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.Merchant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantPage extends Merchant {
	private static final long serialVersionUID = 1L;

	private String deptName;
}
