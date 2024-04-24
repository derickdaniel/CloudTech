package com.comp.cloudtech.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Component
public class EnvUtil {
	
	@Autowired
	Environment environment;

	private String port;
	private String hostname;

	public String getPort() {
		if (port == null)
			port = environment.getProperty("local.server.port");
		return port;
	}

	public Integer getPortAsInt() {
		return Integer.valueOf(getPort());
	}

	public String getHostAddr() throws UnknownHostException {
		// TODO ... would this cache cause issue, when network env change ???
		if (hostname == null)
			hostname = InetAddress.getLocalHost().getHostAddress();
		return hostname;
	}

	public String getHostName() throws UnknownHostException {

		return InetAddress.getLocalHost().getHostName();
	}

	public String getCHostName() throws UnknownHostException {

		return InetAddress.getLocalHost().getCanonicalHostName();
	}

	public String getServerUrlPrefi() throws UnknownHostException {
		return "http://" + getHostAddr() + ":" + getPort();
	}
	
	public Map<String, Object> envDetailsMap() throws UnknownHostException {

		Map<String, Object> map = new HashMap<>();
		map.put("port", getPort());
		map.put("hostAddr", getHostAddr());
		map.put("hostNam", getHostName());
		map.put("cHostNam", getCHostName());
		map.put("uri", getServerUrlPrefi());

		return map;
	}
}