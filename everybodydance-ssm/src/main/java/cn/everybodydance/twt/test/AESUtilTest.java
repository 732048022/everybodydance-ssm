package cn.everybodydance.twt.test;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import cn.everybodydance.twt.util.AESUtil;
import sun.misc.BASE64Decoder;

/**
 * AES工具包测试类
 * 
 * @author tanwentao
 *
 */
public class AESUtilTest {
	static String CODE_TYPE = "UTF-8";
	static String AES_TYPE = "AES/ECB/NoPadding";

	public static void main(String[] args) throws Exception {
		String content = "gIyR66p9uoU+1yIX/+biCw==";
		decrypt(content);
		System.out.println("解密内容为："+decrypt(content));
		//test(content);
	}

	public static String decrypt(String encryptedData){
		try {
			byte[] byteMi = new BASE64Decoder().decodeBuffer(encryptedData);
			//IvParameterSpec zreoIv = new IvParameterSpec(offset.getBytes());
			SecretKeySpec key = new SecretKeySpec("0282199602160214".getBytes(), "AES");
			Cipher cipher = Cipher.getInstance(AES_TYPE);
			// 与加密不同MODE:Cipher.DECRYPT_MODE
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedData = cipher.doFinal(byteMi);
			return new String(decryptedData, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void test(String content) throws UnsupportedEncodingException {
		System.out.println("加密内容：" + content);
		// 字节数
		int num = content.getBytes(CODE_TYPE).length;
		System.out.println("加密内容字节数: " + num);
		System.out.println("加密内容是否16倍数: " + (num % 16 == 0 ? true : false));

		// 字节补全
		if (AES_TYPE.equals("AES/ECB/NoPadding")) {
			System.out.println();
			content = completionCodeFor16Bytes(content);
			System.out.println("加密内容补全后: " + content);
		}

		System.out.println();

		// 加密

//		content = new String(encryptResult);
		System.out.println("加密后：" + content);

		System.out.println();

		// 解密
//		String decryptResult = AESUtil.decrypt(encryptResult);
//		content = new String(decryptResult);
		// 还原
		if (AES_TYPE.equals("AES/ECB/NoPadding")) {
			System.out.println("解密内容还原前: " + content);
			content = resumeCodeOf16Bytes(content);
		}

		System.out.println("解密完成后：" + content);
	}

	// NoPadding
	// 补全字符
	public static String completionCodeFor16Bytes(String str) throws UnsupportedEncodingException {
		int num = str.getBytes(CODE_TYPE).length;
		int index = num % 16;
		// 进行加密内容补全操作, 加密内容应该为 16字节的倍数, 当不足16*n字节是进行补全, 差一位时 补全16+1位
		// 补全字符 以 $ 开始,$后一位代表$后补全字符位数,之后全部以0进行补全;
		if (index != 0) {
			StringBuffer sbBuffer = new StringBuffer(str);
			if (16 - index == 1) {
				sbBuffer.append("$" + AESUtil.consult[16 - 1] + addStr(16 - 1 - 1));
			} else {
				sbBuffer.append("$" + AESUtil.consult[16 - index - 1] + addStr(16 - index - 1 - 1));
			}
			str = sbBuffer.toString();
		}
		return str;
	}

	// 追加字符
	public static String addStr(int num) {
		StringBuffer sbBuffer = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			sbBuffer.append("0");
		}
		return sbBuffer.toString();
	}

	// 还原字符(进行字符判断)
	public static String resumeCodeOf16Bytes(String str) {
		int indexOf = str.lastIndexOf("$");
//	    	System.out.println(indexOf);
		if (indexOf == -1) {
			return str;
		}
		String trim = str.substring(indexOf + 1, indexOf + 2).trim();
//	    	System.out.println(trim);
		int num = 0;
		for (int i = 0; i < AESUtil.consult.length; i++) {
			if (trim.equals(AESUtil.consult[i])) {
				num = i;
			}
		}
		if (num == 0) {
			return str;
		}
		return str.substring(0, indexOf).trim();
	}
}
