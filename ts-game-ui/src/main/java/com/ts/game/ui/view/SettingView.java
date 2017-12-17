package com.ts.game.ui.view;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ts.game.ui.model.IPConfig;

@ManagedBean
@ApplicationScoped
public class SettingView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final String CENTRAL_SERVER = "CENTRAL_SERVER";
    private final String A_SERVER = "A_SERVER";
    private final String B_SERVER = "B_SERVER";
    private final String C_SERVER = "C_SERVER";
    private final String D_SERVER = "D_SERVER";

    private IPConfig ipConfig = new IPConfig();
    private Map<String, String> servers = new LinkedHashMap<String, String>();

    @PostConstruct
    public void init() {
	initIpConfig(null);
    }

    public void initIpConfig(IPConfig ipConfig) {
	if (ipConfig != null) {
	    servers.put(CENTRAL_SERVER, ipConfig.getCentralIp());
	    servers.put(A_SERVER, ipConfig.getaIp());
	    servers.put(B_SERVER, ipConfig.getbIp());
	    servers.put(C_SERVER, ipConfig.getcIp());
	    servers.put(D_SERVER, ipConfig.getdIp());
	}
    }

    public String saveSettings() {
	initIpConfig(this.ipConfig);
	return "pm:main";
    }

    public IPConfig getIpConfig() {
	return ipConfig;
    }

    public void setIpConfig(IPConfig ipConfig) {
	this.ipConfig = ipConfig;
    }

    public Map<String, String> getServers() {
	return servers;
    }

    public void setServers(Map<String, String> servers) {
	this.servers = servers;
    }

}
