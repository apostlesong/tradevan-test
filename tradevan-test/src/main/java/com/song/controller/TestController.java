package com.song.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.dto.RequestDTO;
import com.song.memberdata.AccountInfo;

@RestController
public class TestController {

	@PostMapping("deposit")
	public String deposit (@RequestBody RequestDTO requestDto) {
		int account = requestDto.getAccount();
		int result = AccountInfo.accountInfo.get(account) + requestDto.getAmount();
		AccountInfo.accountInfo.put(requestDto.getAccount(), result);
		return  "帳號" + account + "存款成功, 餘額:::" + result;
	}
	@PostMapping("withdrawl")
	public String withdrawl (@RequestBody RequestDTO requestDto) {
		int account = requestDto.getAccount();
		int result = AccountInfo.accountInfo.get(account) - requestDto.getAmount();
		
		if (result < 0) {
			return "帳號" + account + "提款失敗, 餘額不足";
		} 
		
		AccountInfo.accountInfo.put(requestDto.getAccount(), result);
		return  "帳號" + account + "提款成功, 餘額:::" + result;
	}
}
