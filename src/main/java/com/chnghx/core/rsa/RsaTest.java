package com.chnghx.core.rsa;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * 
	 * 
	 * IOException : DerInputStream.getLength(): lengthTag=127, too big. 
	 * 原因是：没有设置私钥(私钥为空)
	 * 
	 * 获取私钥可能出现异常:algid parse error, not a sequence异常
	 * 原因是私钥不是pkcs8格式，
	 * 解决方案 使用openssl执行：pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt
	 * 参考链接：
	 * https://stackoverflow.com/questions/6559272/algid-parse-error-not-a-sequence
	 * https://www.jianshu.com/p/aa6ff3ce49b5
*    
* 项目名称：demo   
* 类名称：RsaTest   
* 类描述：   
* 创建人：guohaixiang  
* 创建时间：2018年6月7日 下午3:04:32   
* 修改人：Administrator   
* 修改时间：2018年6月7日 下午3:04:32   
* 修改备注：   
* @version 1.0
*
 */
public class RsaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "5JexwZ9BGNdwxZotp6jProqzNQ2kobBabLC4wwJfxxaD1boBzWpxaD1boBzWp";
		// RSAPublicKey pubKey;
		// byte[] cipherText;
		// Cipher cipher;
		// String PUBLIC_KEY= "-----BEGIN PUBLIC
		// KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDlOJu6TyygqxfWT7eLtGDwajtNFOb9I5XRb6khyfD1Yt3YiCgQWMNW649887VGJiGr/L5i2osbl8C9+WJTeucF+S76xFxdU6jE0NQ+Z+zEdhUTooNRaY5nZiu5PgDB0ED/ZKBUSLKL7eibMxZtMlUDHjm4gwQco1KRMDSmXSMkDwIDAQAB-----END
		// PUBLIC KEY-----";
		// try {
		//
		// X509EncodedKeySpec spec = new
		// X509EncodedKeySpec(PUBLIC_KEY.getBytes("UTF-8"));
		// KeyFactory kf = KeyFactory.getInstance("RSA");
		// pubKey = (RSAPublicKey)kf.generatePublic(spec);
		//// PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(PUBLIC_KEY.getBytes());
		//// KeyFactory kf = KeyFactory.getInstance("RSA");
		//// pubKey = kf.generatePrivate(spec);
		//// privKey = (RSAPrivateKey) getPrivateKey(PRIVATE_KEY_PATH);
		// cipher = Cipher.getInstance(kf.getAlgorithm());
		// cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		// cipherText = cipher.doFinal(input.getBytes("UTF-8"));
		// // 加密后的东西
		// System.out.println("cipher: " + new String(cipherText));
		// // 开始解密
		//// cipher.init(Cipher.DECRYPT_MODE, privKey);
		//// byte[] plainText = cipher.doFinal(cipherText);
		//// System.out.println("publickey: " + Base64.getEncoder().encode(cipherText));
		//// System.out.println("plain : " + new String(plainText));
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		RSAPublicKey pubKey;
		RSAPrivateKey privKey;
		byte[] cipherText;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("RSA");
			pubKey = (RSAPublicKey) getPublicKey();
			privKey = (RSAPrivateKey) getPrivateKey();
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			cipherText = cipher.doFinal(input.getBytes());
			String en64 = Base64.getEncoder().encodeToString(cipherText);
			System.out.println(en64);
			// 加密后的东西
			System.out.println("cipher: " + new String(cipherText));
			// 开始解密
			cipher.init(Cipher.DECRYPT_MODE, privKey);
			byte[] plainText = cipher.doFinal(cipherText);
//			System.out.println("publickey: " + Base64.getEncoder().encode(cipherText));
			System.out.println("plain : " + new String(plainText));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// try {
		// RsaTest encrypt = new RsaTest();
		// String encryptText = "12345678";
		// KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		// keyPairGen.initialize(1024);
		// KeyPair keyPair = keyPairGen.generateKeyPair();
		// // Generate keys
		// RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // 私钥
		// RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // 公钥
		// byte[] e = encrypt.encrypt(publicKey, encryptText.getBytes());
		// byte[] de = encrypt.decrypt(privateKey, e);
		// System.out.println(encrypt.bytesToString(e));
		// System.out.println();
		//
		// System.out.println(encrypt.bytesToString(de));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 获取公钥
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey() throws Exception {
		String pbulicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDlOJu6TyygqxfWT7eLtGDwajtNFOb9I5XRb6khyfD1Yt3YiCgQWMNW649887VGJiGr/L5i2osbl8C9+WJTeucF+S76xFxdU6jE0NQ+Z+zEdhUTooNRaY5nZiu5PgDB0ED/ZKBUSLKL7eibMxZtMlUDHjm4gwQco1KRMDSmXSMkDwIDAQAB";
		byte[] keyBytes = pbulicKey.getBytes();
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(pbulicKey.getBytes()));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	/**
	 * 获取私钥
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey() throws Exception {
//		java.security.Security.addProvider(
//                new org.bouncycastle.jce.provider.BouncyCastleProvider()
//        );
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOU4m7pPLKCrF9ZPt4u0YPBqO00U5v0jldFvqSHJ8PVi3diIKBBYw1brj3zztUYmIav8vmLaixuXwL35YlN65wX5LvrEXF1TqMTQ1D5n7MR2FROig1FpjmdmK7k+AMHQQP9koFRIsovt6JszFm0yVQMeObiDBByjUpEwNKZdIyQPAgMBAAECgYB9j0ume5YrkGznRRV6nlz3dIl1SLza7vIzHiIcUxz9naF96d9gTO77nt8jh+/FND//kNvNFH9cpvy6U2/r4IfI8XfXGTtg4F+QYjyqMuirTpX4XIF8NLAvwpsvJ4ebspRmcs1BuTzIYvMHeJgqREeWZRqdAZo0wgnOJY6Q34310QJBAPQ41hE1l64zzN3xclNJ1whfhreDLcYYInE7O/XpcfEPTcZbpQ0uZ8/B6cq75x2tB5qoSLGsJ6Nd0AXP/v4FIykCQQDwRpI54/levdmtuIrOLpMYzAcy8Lsd0nFoEltVF8CkWsTT+Y/CY/ms3tDCOsxj7T4BtdybyZFDJDX4gYR6Zux3AkEA3prPxG/tCcP9gG+LnY84iVFJIgxXtLBa9IrhZIycZvVkFuGB2DnsNdqylzAewVXuEHJDkG8y0h24dxPXgQJ9wQJABN5pOCMWeoT+VDbZGTR4Zpg7zRxzrjcFdUZp819319y/AEyeTSIZfRdGw6jNW3kDOKWmwsFi4Clrro1xUcmkIQJBANOMjYBCEVzXJGcJT9iAOdKklWbWcBKhFSdTwl+bc7O6S7slRdxWm3TwMVJx4IRf26cK4xxPvasBCUul1mKvzvo=";
		byte[] keyBytes = privateKey.getBytes();
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey.getBytes("UTF-8")));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	/**
	 * byte数组转为string
	 *
	 * @param encrytpByte
	 * @return
	 */
	protected String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}

	/**
	 * 加密方法
	 *
	 * @param publicKey
	 * @param obj
	 * @return
	 */
	protected byte[] encrypt(RSAPublicKey publicKey, byte[] obj) {
		if (publicKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 解密方法
	 *
	 * @param privateKey
	 * @param obj
	 * @return
	 */
	protected byte[] decrypt(RSAPrivateKey privateKey, byte[] obj) {
		if (privateKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
