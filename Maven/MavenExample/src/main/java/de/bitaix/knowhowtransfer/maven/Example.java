package de.bitaix.knowhowtransfer.maven;

import org.apache.commons.lang3.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class Example {
	public boolean checkString() {
		return StringUtils.isAllLowerCase("abd");
	}
}
