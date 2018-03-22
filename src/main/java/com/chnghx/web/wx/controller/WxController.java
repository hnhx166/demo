package com.chnghx.web.wx.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chnghx.common.utils.image.ImageUtils;
import com.chnghx.common.utils.image.Tools;
import com.chnghx.web.common.config.WeChatConfig;
import com.chnghx.web.wx.util.HttpClientUtils;

@Controller
@Scope("prototype")
@RequestMapping("wx")
@RestController
public class WxController {

	@RequestMapping(value = "photo", produces = "application/json;charset=UTF-8")
	public ModelAndView photo(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("wx/photo");
		return view;
	}

	@RequestMapping(value = "pt", produces = "application/json;charset=UTF-8")
	public ModelAndView pt(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("wx/pt");
		return view;
	}

	@RequestMapping(value = "p1", produces = "application/json;charset=UTF-8")
	public ModelAndView p1(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("wx/p1");
		return view;
	}

	@RequestMapping(value = "upload", produces = "application/json;charset=UTF-8")
	public void upload(DefaultMultipartHttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String uploadurl = "/bizwork/upload/";
		
		MultiValueMap<String, MultipartFile> fileMap = request
				.getMultiFileMap();
		List<MultipartFile> mutFileList = null;
		MultipartFile mutFile = null;
		for (String fileName : fileMap.keySet()) {
			mutFileList = fileMap.get(fileName);
			if (mutFileList != null && mutFileList.size() > 0) {
				mutFile = mutFileList.get(0);
			}
			break;// 每次只能上传一张图片
		}
		
		String name = "";// 文件名
		if (null != mutFile && mutFile.getOriginalFilename() != null) {
			name = mutFile.getOriginalFilename();
		} else {
		}

		String suffix = null;
		if (null != name && !"".equals(name)) {
			suffix = Tools.getFileSuffix(name);
		}
		long size = mutFile.getSize();
		size = size / 1024;
		if (size > 2048) {// 图片大小限制
			
		} else if (size < 5) {
			
		}
		// 支持png,gif,jpg,bmp
		if (suffix == null
				|| (!suffix.equals(".jpg") && !suffix.equals(".gif")
						&& !suffix.equals(".png") && !suffix.equals(".bmp")
						&& !suffix.equals(".JPG") && !suffix.equals(".GIF")
						&& !suffix.equals(".PNG") && !suffix.equals(".BMP")
						&& !suffix.equals(".jpeg") && !suffix.equals(".JPEG"))) {

		}
		InputStream inputStream = null;
		try {
			inputStream = mutFile.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage bufImg = null;
		try {
			bufImg = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis(); // 使用时间作为文件名
		name = time + suffix;

		// images/touxiang/2.jpg
		suffix = suffix.replace(".", ""); // 去掉点，以便后面保存图片格式,jpg/png/gif
		String url = ImageUtils.save(suffix, name, uploadurl,
				bufImg.getWidth(), bufImg.getHeight(), bufImg);
//		if (request.getContentLength() > 0) {
//			InputStream inputStream = null;
//			FileOutputStream outputStream = null;
//			try {
//				inputStream = request.getInputStream();
//				// 给新文件拼上时间毫秒，防止重名
//				long now = System.currentTimeMillis();
//				File file = new File("c:/", "file-" + now + ".txt");
//				file.createNewFile();
//				outputStream = new FileOutputStream(file);
//				byte temp[] = new byte[1024];
//				int size = -1;
//				while ((size = inputStream.read(temp)) != -1) { // 每次读取1KB，直至读完
//					outputStream.write(temp, 0, size);
//				}
//
//			} catch (IOException e) {
//				// request.getRequestDispatcher("/fail.jsp").forward(request, response);
//			} finally {
//				try {
//					outputStream.close();
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}
	}

	/**
	 * 1.1 开放数据接口–根据productPk或者produckId查询房源详情接口
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping(value = "index", produces = "application/json;charset=UTF-8")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("wx/index");

		String url = WeChatConfig.getProperty("access_token");
		url = String.format(url, WeChatConfig.getProperty("AppId"), WeChatConfig.getProperty("AppSecret"));
		String result = HttpClientUtils.sendGet(url, null);
		JSONObject data = JSONObject.parseObject(result);
		System.out.println("data=" + data);

		String jsapi_ticket_url = String.format(WeChatConfig.getProperty("jsapi_ticket"),
				data.getString("access_token"));
		String jsapi_ticket_Str = HttpClientUtils.sendGet(jsapi_ticket_url, null);
		JSONObject jsapi_ticket_data = JSONObject.parseObject(jsapi_ticket_Str);

		System.out.println("jsapi_ticket_data=" + jsapi_ticket_data);

		String noncestr = UUID.randomUUID().toString().replaceAll("-", "");
		String jsapi_ticket = jsapi_ticket_data.getString("ticket");

		long timestamp = System.currentTimeMillis();
		// 当前url地址不包括#后面的
		String curl = "http://wx.chnghx.com/wx/index.vhtml";

		String params = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ curl;

		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		messageDigest.reset();
		messageDigest.update(params.getBytes("UTF-8"));
		String signature = byteToHex(messageDigest.digest());
		view.addObject("signature", signature);

		view.addObject("noncestr", noncestr);
		view.addObject("jsapi_ticket", jsapi_ticket);
		view.addObject("appId", WeChatConfig.getProperty("AppId"));
		view.addObject("timestamp", timestamp);

		System.out.println("params=" + params);
		System.out.println("jsapi_ticket=" + jsapi_ticket);
		System.out.println("noncestr=" + noncestr);
		System.out.println("timestamp=" + timestamp);
		System.out.println("url=" + url);
		System.out.println("signature=" + signature);

		return view;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
