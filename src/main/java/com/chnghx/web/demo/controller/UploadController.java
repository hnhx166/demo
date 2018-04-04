package com.chnghx.web.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.chnghx.common.utils.image.ImageUtils;
import com.chnghx.common.utils.image.Tools;
import com.chnghx.web.common.BaseController;

@Controller
@Scope("prototype")
@RequestMapping("upload")
@RestController
public class UploadController extends BaseController{
	
	@RequestMapping(value = "uploadImg", produces = "application/json;charset=UTF-8")
	public void uploadImg(DefaultMultipartHttpServletRequest request, HttpServletResponse response)
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

	}
	
}
