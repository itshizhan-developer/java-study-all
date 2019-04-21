package com.itshizhan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCollection {
	private Object [] array;
	private List list;
	private Set set;
	private Map map;
	private Properties properties;


}
