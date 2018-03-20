package com.chnghx.web.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.chnghx.web.common.VCache;

/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年7月24日 　<br/>
 * <p>
 * 序列化和反序列
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年7月24日 <br/>
 * 
 */
public class SerializeUtil {

    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (Exception e) {
            LoggerUtils.error(SerializeUtil.class, "serialize error", e);
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }

    @SuppressWarnings("unchecked")
	public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
            }
        } catch (Exception e) {
            LoggerUtils.error(SerializeUtil.class, "deserialize error", e);
        } finally {
            close(is);
            close(bis);
        }
        return (T) rv;
    }

    private static void close(Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            } catch (IOException e) {
                LoggerUtils.error(SerializeUtil.class, "close stream error", e);
            }
    }

}
