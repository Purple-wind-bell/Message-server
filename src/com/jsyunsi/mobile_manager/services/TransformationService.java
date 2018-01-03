package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.servicesInter.TransformationInter;
import com.jsyunsi.mobile_manager.vo.FormatSMS;

public class TransformationService implements TransformationInter {

	@Override
	public FormatSMS toFormatSMS(String message) {
		// TODO Auto-generated method stub
		StringBuilder sms = new StringBuilder(message);
		String cmd = sms.substring(0, 6);
		String sourceAddress = sms.substring(6, 17);
		String targetAddress = sms.substring(17, 28);
		String status = sms.substring(28, 32);
		String SMSContent = sms.substring(32);
		return new FormatSMS(cmd, sourceAddress, targetAddress, status, SMSContent);
	}

	@Override
	public String toStringSMS(FormatSMS formatSMS) {
		// TODO Auto-generated method stub
		StringBuilder SMSString = new StringBuilder();
		SMSString.append(formatSMS.getCmd());
		SMSString.append(formatSMS.getSourceAddress());
		SMSString.append(formatSMS.getTargetAddress());
		SMSString.append(formatSMS.getStatus());
		SMSString.append(formatSMS.getSMSContent());
		return SMSString.toString();
	}

}
