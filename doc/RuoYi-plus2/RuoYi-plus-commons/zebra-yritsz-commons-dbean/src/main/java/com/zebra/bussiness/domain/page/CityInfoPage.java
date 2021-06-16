package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.CityInfo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityInfoPage extends CityInfo {
	private static final long serialVersionUID = 1L;

 	private String provinceName;
 	
}
