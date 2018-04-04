package com.chnghx.web.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 文件下载
 * ajax 返回
 * 
 * 
 * @author Administrator
 *
 */
@Scope("singleton")
@RequestMapping("app")
@RestController
public class APPDownloadController {

	@RequestMapping(value = "download")
	public void download(HttpServletRequest request,
			HttpServletResponse response, String t) {
		response.setContentType("application/x-msdownload"); // 服务器存储地址，二期改不同APP不同目录

		if ("1".equals(t)) {//数据流
			try{
				response.setContentType("application/json");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");	
				response.setCharacterEncoding("UTF-8");
				PrintWriter out= null;
				out = response.getWriter();
				out.print("支付成功");
				out.flush();
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		} else {//文件流

			String filedownload = "/bizwork/tomcat-8.5.15/mywebapps/demo/down/樱桃阵.apk";
			System.out.println("********************" + filedownload);
			// 文件长度
			Long fileLength = new File(filedownload).length();
			response.addHeader("Content-Disposition",
					"attachment;filename=mall_android_6.3.apk");
			response.setHeader("Content-Length", String.valueOf(fileLength));
			OutputStream outp = null;
			FileInputStream in = null;
			try {
				outp = response.getOutputStream();
				in = new FileInputStream(filedownload);
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = in.read(b)) > 0) {
					outp.write(b, 0, i);
				}
				outp.flush();
				outp.close();
				in.close();
			} catch (Exception e) {
				System.out.println("Error!");
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (outp != null) {
						outp.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
