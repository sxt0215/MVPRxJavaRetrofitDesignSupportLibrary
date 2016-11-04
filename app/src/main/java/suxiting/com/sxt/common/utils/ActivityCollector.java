package suxiting.com.sxt.common.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sxt on 16/11/3.
 */
public class ActivityCollector {

	public static List<Activity> activities = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		activities.add(activity);
	}

	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}

}
