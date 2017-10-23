package shiro_system.uitl;

import org.apache.shiro.codec.Base64;

import junit.framework.Assert;

public class Test {
	public void main(String[] args){
		String str = "hello";
		String base64Encoded = Base64.encodeToString(str.getBytes());
		String str2 = Base64.decodeToString(base64Encoded);
		Assert.assertEquals(str, str2);
	}
}
