package com.chnghx.web.wechat.manager;
/**
 * 
 *
 *说明：图片格式
 <xml>
    <ToUserName>< ![CDATA[toUser] ]>
    </ToUserName>
    <FromUserName>< ![CDATA[fromUser] ]>
    </FromUserName>
    <CreateTime>12345678</CreateTime>
    <MsgType>< ![CDATA[image] ]>
    </MsgType>
    <Image>
        <MediaId>< ![CDATA[media_id] ]>
        </MediaId>
    </Image>
</xml>
 */
public class IMGEMessage extends BaseWeChatMessage{
	/**
	 * 素材ID
	 */
	private Image Image;

	public Image getImage() {
		if(null==Image) {
			Image=new Image();
		}
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	 public class Image{
		private String MediaId;

		public String getMediaId() {
			return MediaId;
		}

		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
	}
}

