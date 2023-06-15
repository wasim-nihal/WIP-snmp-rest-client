package com.snmprest.client.vo;

import java.util.List;

/**
 * SNMP V3 Message Model Class
 * @author snihal
 *
 */
public class V3Message {
	
	private String requestType;
	private String agentIp;
	private String agentPort;
	private String userName;
	private String securityLevel;
	private String authProtocol;
	private String authPassword;
	private String privProtocol;
	private String privPassword;
	private String contextName;
	private String contextEngineId;
	private int maxRepeations;
	private int nonRepeaters;
	private List<String> oids;

	

	public V3Message(String requestType, String agentIp, String agentPort, String userName, String securityLevel,
			String authProtocol, String authPassword, String privProtocol, String privPassword, String contextName,
			String contextEngineId, int maxRepeations, int nonRepeaters, List<String> oids) {
		super();
		this.requestType = requestType;
		this.agentIp = agentIp;
		this.agentPort = agentPort;
		this.userName = userName;
		this.securityLevel = securityLevel;
		this.authProtocol = authProtocol;
		this.authPassword = authPassword;
		this.privProtocol = privProtocol;
		this.privPassword = privPassword;
		this.contextName = contextName;
		this.contextEngineId = contextEngineId;
		this.maxRepeations = maxRepeations;
		this.nonRepeaters = nonRepeaters;
		this.oids = oids;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getAuthProtocol() {
		return authProtocol;
	}

	public void setAuthProtocol(String authProtocol) {
		this.authProtocol = authProtocol;
	}

	public String getAuthPassword() {
		return authPassword;
	}

	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}

	public String getPrivProtocol() {
		return privProtocol;
	}

	public void setPrivProtocol(String privProtocol) {
		this.privProtocol = privProtocol;
	}

	public String getPrivPassword() {
		return privPassword;
	}

	public void setPrivPassword(String privPassword) {
		this.privPassword = privPassword;
	}

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

	public String getContextEngineId() {
		return contextEngineId;
	}

	public void setContextEngineId(String contextEngineId) {
		this.contextEngineId = contextEngineId;
	}

	public String getAgentIp() {
		return agentIp;
	}

	public void setAgentIp(String agentIp) {
		this.agentIp = agentIp;
	}

	public String getAgentPort() {
		return agentPort;
	}

	public void setAgentPort(String agentPort) {
		this.agentPort = agentPort;
	}

	public List<String> getOids() {
		return oids;
	}

	public void setOids(List<String> oids) {
		this.oids = oids;
	}

	public int getMaxRepeations() {
		return maxRepeations;
	}

	public void setMaxRepeations(int maxRepeations) {
		this.maxRepeations = maxRepeations;
	}

	public int getNonRepeaters() {
		return nonRepeaters;
	}

	public void setNonRepeaters(int nonRepeaters) {
		this.nonRepeaters = nonRepeaters;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
