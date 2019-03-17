package com.cts.cloud.enablement.onlinesales.service;

import java.util.Map;
import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;

public interface SecurityTokenGenerator {
	
	/**
	 * Generate Token
	 * @param user
	 * @return
	 */
	Map<String, Object> generateToken(ActiveDirectory user);

}
