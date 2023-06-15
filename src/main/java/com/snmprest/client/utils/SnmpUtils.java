package com.snmprest.client.utils;

import org.snmp4j.ScopedPDU;
import org.snmp4j.security.AuthHMAC128SHA224;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.AuthSHA;
import org.snmp4j.security.Priv3DES;
import org.snmp4j.security.PrivAES128;
import org.snmp4j.security.PrivDES;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;

import com.snmprest.client.errors.ErrorMessage;
import com.snmprest.client.errors.RequestProcessingException;
import com.snmprest.client.vo.V3Message;

/**
 * Utility Class for Processing the Request
 * @author snihal
 *
 */
public class SnmpUtils {
	
	/**
	 * Returns the int value for corresponding string representation of security level. (authPriv or authNoPriv or noAuthNoPriv) 
	 * @param level
	 * @return int
	 * @throws RequestProcessingException
	 */
	public static int getSecurityLevel(String level) throws RequestProcessingException {
		try {
			return SecurityLevel.valueOf(level).getSnmpValue();
		} catch (Exception e) {
			ErrorMessage err = new ErrorMessage("Invalid SecurityLevel", 0, 0,
					"Unable to determine the value of SecurityLevel. Values can be either of authPriv | authNoPriv | noAuthNoPriv");
			throw new RequestProcessingException(err);
		}
	}

	
	/**
	 * Returns OctetString representation of SNMP v3 user name.
	 * @param userName
	 * @return OctetString
	 * @throws RequestProcessingException
	 */
	public static OctetString getSecurityName(String userName) throws RequestProcessingException {
		if (userName == null || userName == "") {
			ErrorMessage err = new ErrorMessage("userName cannot be empty or null", 0, 0,
					"userName is either null or empty");
			throw new RequestProcessingException(err);
		}
		return new OctetString(userName);

	}

	/**
	 * Returns an instance of ScopedPDU based on the V3Message object. 
	 * @param message
	 * @param requestType
	 * @return ScopedPDU
	 */
	public static ScopedPDU prepareScopedPUD(V3Message message, int requestType) {
		ScopedPDU pdu = new ScopedPDU();

		VariableBinding[] columns = new VariableBinding[message.getOids().size()];
		for (int i = 0; i < message.getOids().size(); i++) {
			columns[i] = new VariableBinding(new OID(message.getOids().get(i)));
		}

		pdu.addAll(columns);
		pdu.setType(requestType);
		pdu.setMaxRepetitions(message.getMaxRepeations());
		pdu.setNonRepeaters(message.getNonRepeaters());
		return pdu;
	}

	/**
	 * Returns instance of Auth protocols based on the input string values. <P>
	 * Currently supported Auth protocols are "md5", "sha" and "hamc128sha224"
	 * @param protocol
	 * @return OID
	 * @throws RequestProcessingException
	 */
	public static OID getAuthProtocol(String protocol) throws RequestProcessingException {
		if (protocol == null || protocol == "") {
			ErrorMessage err = new ErrorMessage("auth protocol cannot be empty or null", 0, 0,
					"auth protocol is either null or empty");
			throw new RequestProcessingException(err);
		}
		switch (protocol) {
		case "md5":
			return AuthMD5.ID;
		case "sha":
			return AuthSHA.ID;

		case "hamc128sha224":
			return AuthHMAC128SHA224.ID;
		}
		ErrorMessage err = new ErrorMessage("auth protocol is invalid", 0, 0,
				protocol + " auth protocol is invalid. Should be either of md5 | sha | hamc128sha224");
		throw new RequestProcessingException(err);
	}

	/**
	 * Returns instance of Priv protocols based on the input string values. <P>
	 * Currently supported Auth protocols are "aes", "des" and "3des"
	 * @param protocol
	 * @return
	 * @throws RequestProcessingException
	 */
	public static OID getPrivProtocol(String protocol) throws RequestProcessingException {
		if (protocol == null || protocol == "") {
			ErrorMessage err = new ErrorMessage("priv protocol cannot be empty or null", 0, 0,
					"priv protocol is either null or empty");
			throw new RequestProcessingException(err);
		}
		switch (protocol) {
		case "aes":
			return PrivAES128.ID;
		case "des":
			return PrivDES.ID;
		case "3des":
			return Priv3DES.ID;
		}
		ErrorMessage err = new ErrorMessage("priv protocol is invalid", 0, 0,
				protocol + " priv protocol is invalid. Should be either of aes | des | 3des");
		throw new RequestProcessingException(err);
	}
}
