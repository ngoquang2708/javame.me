package com.ngoquang2708.me.midp.io;

import javax.microedition.pki.Certificate;

public interface SecurityInfo {

	Certificate getServerCertificate();

	String getProtocolVersion();

	String getProtocolName();

	String getCipherSuite();

}
