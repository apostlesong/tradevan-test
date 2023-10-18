package com.song.memberdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountInfo {
	public static Map<Integer,Integer> accountInfo = new HashMap<>();
	static {
        accountInfo.put(1, 1000);
        accountInfo.put(2, 2000);
	}
}
