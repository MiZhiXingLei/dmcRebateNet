package com.dmc.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created on 17/6/7. ����API��Ʒ��DEMO����,�����а�����һ��SmsDemo�ֱ࣬��ͨ��
 * ִ��main��������������Ų�ƷAPI����(ֻ��Ҫ��AK�滻�ɿ�ͨ����ͨ��-���Ų�Ʒ���ܵ�AK����) ����������2��jar��(����ڹ��̵�libsĿ¼��)
 * 1:aliyun-java-sdk-core.jar 2:aliyun-java-sdk-dysmsapi.jar
 *
 * ��ע:Demo���̱������UTF-8 ���ʶ��ŷ���������մ�DEMO
 */
public class SmsDemo {

	// ��Ʒ����:��ͨ�Ŷ���API��Ʒ,�����������滻
	static final String product = "Dysmsapi";
	// ��Ʒ����,�����������滻
	static final String domain = "dysmsapi.aliyuncs.com";
	private String codes;

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	// TODO �˴���Ҫ�滻�ɿ������Լ���AK(�ڰ����Ʒ��ʿ���̨Ѱ��)
	static final String accessKeyId = "LTAITaW7bsFe4OCF";
	static final String accessKeySecret = "qRp20eozWMBKzMWoCAZEap7euHETjR";

	public static List sendSms(String userp) throws ClientException {

		// ������������ʱʱ��
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		List list = new ArrayList();
		list.clear();
		// ��ʼ��acsClient,�ݲ�֧��region��
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// ��װ�������-��������������̨-�ĵ���������
		SendSmsRequest request = new SendSmsRequest();
		// ����:�������ֻ���
		request.setPhoneNumbers(userp);
		// ����:����ǩ��-���ڶ��ſ���̨���ҵ�
		request.setSignName("���ҵ�è������");
		// ����:����ģ��-���ڶ��ſ���̨���ҵ�
		request.setTemplateCode("SMS_138515253");
		int ran = (int) (Math.random() * 9000) + 1000;
		String code = ran + "";
		// ��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
		request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + code + "\"}");

		// ѡ��-���ж�����չ��(�����������û�����Դ��ֶ�)
		// request.setSmsUpExtendCode("90997");

		// ��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
		request.setOutId("yourOutId");

		// hint �˴����ܻ��׳��쳣��ע��catch
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		list.add(sendSmsResponse);
		list.add(code);
		return list;
	}

	public static QuerySendDetailsResponse querySendDetails(String bizId, String userp) throws ClientException {

		// ������������ʱʱ��
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		// ��ʼ��acsClient,�ݲ�֧��region��
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// ��װ�������
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
		// ����-����
		request.setPhoneNumber(userp);
		// ��ѡ-��ˮ��
		request.setBizId(bizId);
		// ����-�������� ֧��30���ڼ�¼��ѯ����ʽyyyyMMdd
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		request.setSendDate(ft.format(new Date()));
		// ����-ҳ��С
		request.setPageSize(10L);
		// ����-��ǰҳ���1��ʼ����
		request.setCurrentPage(1L);

		// hint �˴����ܻ��׳��쳣��ע��catch
		QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

		return querySendDetailsResponse;
	}

	/*
	 * public static void main(String[] args) throws ClientException,
	 * InterruptedException {
	 * 
	 * // ������ SendSmsResponse response = sendSms();
	 * System.out.println("���Žӿڷ��ص�����----------------"); System.out.println("Code=" +
	 * response.getCode()); System.out.println("Message=" + response.getMessage());
	 * System.out.println("RequestId=" + response.getRequestId());
	 * System.out.println("BizId=" + response.getBizId());
	 * 
	 * // Thread.sleep(3000L);
	 * 
	 * // // ����ϸ // if (response.getCode() != null &&
	 * response.getCode().equals("OK")) { // // QuerySendDetailsResponse
	 * querySendDetailsResponse = // querySendDetails(response.getBizId()); //
	 * System.out.println("������ϸ��ѯ�ӿڷ�������----------------"); //
	 * System.out.println("Code=" + querySendDetailsResponse.getCode()); //
	 * System.out.println("Message=" + querySendDetailsResponse.getMessage()); //
	 * int i = 0; // for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO
	 * : // querySendDetailsResponse // .getSmsSendDetailDTOs()) { //
	 * System.out.println("SmsSendDetailDTO[" + i + "]:"); //
	 * System.out.println("Content=" + smsSendDetailDTO.getContent()); //
	 * System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode()); //
	 * System.out.println("OutId=" + smsSendDetailDTO.getOutId()); //
	 * System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum()); //
	 * System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate()); //
	 * System.out.println("SendDate=" + smsSendDetailDTO.getSendDate()); //
	 * System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus()); //
	 * System.out.println("Template=" + smsSendDetailDTO.getTemplateCode()); // } //
	 * System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
	 * // System.out.println("RequestId=" +
	 * querySendDetailsResponse.getRequestId()); // }
	 * 
	 * }
	 */
}
