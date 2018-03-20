package com.chnghx.web.wechat.utils;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 图片合成工具
 * 
 * @author Administrator
 *
 */
public class PhotoMontageUtil {

	private Font font = new Font("华文琥珀", Font.PLAIN, 40);// 添加字体的属性设置

	private Graphics2D g = null;

	private int fontsize = 0;

	private int x = 0;

	private int y = 0;
	private static final String imgType="jpg";
	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 导入网络图片到缓冲区
	 */
	public BufferedImage loadImageUrl(String imgName) {
		try {
			URL url = new URL(imgName);
			return ImageIO.read(url);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 生成新图片到本地
	 * 
	 * @param newImage
	 *            新图片名称
	 * @param img
	 *            要合成的图片
	 * @param imgType
	 *            要合成图片后缀
	 */
	public void writeImageLocal(String newImage, BufferedImage img, String imgType) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, imgType, outputfile);
				System.err.println("图片合并成功>>>>>>");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 设定文字的字体等
	 */
	public void setFont(String fontStyle, int fontSize) {
		this.fontsize = fontSize;
		this.font = new Font(fontStyle, Font.PLAIN, fontSize);
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.orange);// 设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (content != null) {
				g.drawString(content.toString(), this.x, this.y);
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
	 */
	public BufferedImage modifyImage(BufferedImage img, Object[] contentArr, int x, int y, boolean xory) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.RED);
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (contentArr != null) {
				int arrlen = contentArr.length;
				if (xory) {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.x += contentArr[i].toString().length() * this.fontsize / 2 + 5;// 重新计算文本输出位置
					}
				} else {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.y += this.fontsize + 2;// 重新计算文本输出位置
					}
				}
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 * 
	 * 时间:2007-10-8
	 * 
	 * @param img
	 * @return
	 */
	public BufferedImage modifyImageYe(BufferedImage img) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.blue);// 设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			// g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 将两长图片合并
	 * 
	 * @param back
	 *            背景图（海报图）
	 * @param before
	 *            前景图（合并图，二维码）
	 * @param location_x
	 *            定位：前景图要展示在北京图的X位置
	 * @param location_y
	 *            定位：前景图要展示在北京图的Y位置
	 * @param showSize_x
	 *            前景图展示的大小X
	 * @param showSize_y
	 *            前景图展示的大小Y
	 * @return
	 */
	public BufferedImage modifyImagetogeter(BufferedImage back, BufferedImage before, Integer location_x,
			Integer location_y, Integer showSize_x, Integer showSize_y) {

		try {
			g = back.createGraphics();
			g.drawImage(before, location_x, location_y, showSize_x, showSize_y, null);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return back;
	}
	/**
	 * 本地加URL
	 * @param imgLocal本在图片地址
	 * @param imgUrl　网络图片地址
	 * @param location_x 定位X
	 * @param location_y 定位Y
	 * @param showSize_x 展示X
	 * @param showSize_y 展示Y
	 * @param imgType 合并图片类型
	 * @param loadImageLocal　合并图片名称
	 */
	public void mergePhoto(String backImage,Boolean backImageIsLocal,String beforeImage,Boolean beforeImageIsLocal, Integer location_x,Integer location_y, Integer showSize_x, Integer showSize_y,String loadImageLocal) {
		PhotoMontageUtil tt = new PhotoMontageUtil();
		BufferedImage back =null;
		BufferedImage before =null;
		if(backImageIsLocal) {
			back =tt.loadImageLocal(backImage);
		}else {
			back =tt.loadImageUrl(beforeImage);
		}
		if(beforeImageIsLocal) {
			 before =tt.loadImageLocal(beforeImage);
		}else {
			 before =tt.loadImageUrl(beforeImage);
		}
		tt.writeImageLocal(loadImageLocal, tt.modifyImagetogeter(back,before, location_x, location_y, showSize_x, showSize_y),imgType );
	}
	
	
	
	public static void main(String[] args) {

		PhotoMontageUtil tt = new PhotoMontageUtil();

		BufferedImage d = tt.loadImageLocal("D:\\110.jpg");
		BufferedImage b = tt.loadImageUrl(
				"http://mmbiz.qpic.cn/mmbiz_jpg/Lt0OA957rNZLhWPGGUxrR1wAAgmBxjypgOyG7ITMWnPWiac2yZNFjMiaiaKmCcfNFDlmUNPjz0sxP9Gkjdia1x962w/0?wx_fmt=jpeg\\");// tt.loadImageLocal("D:\\APP.png");
		// 往图片上写文件
		// tt.writeImageLocal("D:\\120.png", tt.modifyImage(d, "维他康智", 500, 300));
		tt.writeImageLocal("D:\\cAA.png", tt.modifyImagetogeter(d, b, 300, 508, 180, 180), "jpg");// 将多张图片合在一起
		
		String backImage="D:\\110.jpg";
		String beforeImage="http://mmbiz.qpic.cn/mmbiz_jpg/Lt0OA957rNZLhWPGGUxrR1wAAgmBxjypgOyG7ITMWnPWiac2yZNFjMiaiaKmCcfNFDlmUNPjz0sxP9Gkjdia1x962w/0?wx_fmt=jpeg\\";
		Integer location_x=300;
		Integer location_y=500; 
		Integer showSize_x=180; 
		Integer showSize_y=300;
		String loadImageLocal="D:\\cABc.jpg";
		tt.mergePhoto(backImage,true,beforeImage,false,location_x,location_y,showSize_x,showSize_y,loadImageLocal);
	}

}
