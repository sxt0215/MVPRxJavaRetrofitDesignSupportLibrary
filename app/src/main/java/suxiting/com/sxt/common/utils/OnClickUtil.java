package suxiting.com.sxt.common.utils;

/**
 * 连击事件判断
 */
public class OnClickUtil {

	private static long lastClickTime;

	public static boolean isFastDoubleClick(int mills) {
		long time = System.currentTimeMillis();
		long timeD = time - lastClickTime;
		if (0 < timeD && timeD < mills) {
			return true;
		}
		lastClickTime = time;
		return false;
	}

}
