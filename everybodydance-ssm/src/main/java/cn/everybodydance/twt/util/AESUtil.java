package cn.everybodydance.twt.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * 对称加密器 AES加解密工具类
 * 
 * @author tanwentao
 *
 */
@Component
public class AESUtil {
	/**
	 * 写入日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
	/**
	 * 密钥算法名称
	 */
	private static final String KEY_ALGORITHM = "AES";
	/**
	 * 编码方式
	 */
	private static final String CHARSET = "UTF-8";
	/**
	 * 填充类型
	 */
	private static final String AES_TYPE = "AES/ECB/PKCS5Padding";
	/**
	 * 字符补全
	 */
	public static final String[] consult = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B",
			"C", "D", "E", "F", "G" };
	/**
	 * 偏移量
	 */
	private static String offset;

	/**
	 * 私钥
	 */
	private static String aesKey;

	/**
	 * 注入偏移量，该属性为静态属性
	 * 
	 * @param offset
	 */
	@Value("${arbd.security.aes.offset}")
	public void setOffset(String offset) {
		AESUtil.offset = offset;
	}

	/**
	 * 注入私钥，该属性为静态属性
	 * 
	 * @param aesKey
	 */
	@Value("${arbd.security.aes.privatekey}")
	public void setAesKey(String aesKey) {
		AESUtil.aesKey = aesKey;
	}

	/**
	 * 加密方法 加密方式：AES128(CBC/PKCS5Padding)+Base64
	 * 
	 * @param data 需要加密的数据
	 * @return
	 */
	public static String encrypt(String data) {
		try {
			// IvParameterSpec zeroIv=new IvParameterSpec(offset.getBytes());
			// 两个参数，第一个为私钥字节数组，第二个为加密方式，AES或DES
			SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(), KEY_ALGORITHM);
			// 实例化加密类，参数为加密方式，需要写全
			Cipher cipher = Cipher.getInstance(AES_TYPE);
			// 初始化，此方法可以采用三种方式，按加密算法要求来添加
			// （1）无第三个参数
			// （2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)
			// （3）采用此代码中的IVParameterSpec
			// 加密时使用：ENCRYPT_MODE 解密时使用：DECRYPT_MODE
			// CBC类型可以在第三个参数传递偏移量zeroIv，EBC没有偏移量
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 加密操作，返回加密后的字节数组，然后需要编码，主要编解码方式有Base64，HEX,UUE等
			byte[] encryptedData = cipher.doFinal(data.getBytes(CHARSET));
			return new BASE64Encoder().encode(encryptedData);
		} catch (Exception e) {
			logger.error("数据加密异常:{}", e);
			return null;
		}
	}

	/**
	 * 解密
	 * 
	 * @param encryptedData 需要解密的数据
	 * @return
	 */
	public static String decrypt(String encryptedData) {
		try {
			byte[] byteMi = new BASE64Decoder().decodeBuffer(encryptedData);
			//IvParameterSpec zreoIv = new IvParameterSpec(offset.getBytes());
			SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(), KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_TYPE);
			// 与加密不同MODE:Cipher.DECRYPT_MODE
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedData = cipher.doFinal(byteMi);
			return new String(decryptedData, CHARSET);
		} catch (Exception e) {
			logger.error("数据解密异常:{}", e);
			return null;
		}
	}

}
