package com.ngoquang2708.me.midp.io.impl;

import javax.microedition.pki.Certificate;

import com.ngoquang2708.me.midp.io.SecurityInfo;


public class SecurityInfoImpl implements SecurityInfo {

	protected final javax.microedition.io.SecurityInfo securityInfo;

	public SecurityInfoImpl(javax.microedition.io.SecurityInfo securityInfo) {
		if ((this.securityInfo = securityInfo) == null)
			throw new NullPointerException();
	}

	public Certificate getServerCertificate() {
		return securityInfo.getServerCertificate();
	}

	public String getProtocolVersion() {
		return securityInfo.getProtocolVersion();
	}

	public String getProtocolName() {
		return securityInfo.getProtocolName();
	}

	public String getCipherSuite() {
		return securityInfo.getCipherSuite();
	}
}