package de.bitaix.knowhowtransfer.nomaven;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class Example {
	public boolean checkStringIsUpperCase(String string) {
		return StringUtils.isAllUpperCase(string);
	}
}
