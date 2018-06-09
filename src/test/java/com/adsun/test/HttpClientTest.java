package com.adsun.test;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.adsun.server.http.MyHttpClient;

public class HttpClientTest {
	
	@Test
	public void test() {
		HttpGet get = new HttpGet("https://weibo.com/p/1005051111681197/info?mod=pedit_more&ajaxpagelet=1&ajaxpagelet_v6=1&__ref=%2Fwflanker%3Frefer_flag%3D0000015010_%26from%3Dfeed%26loc%3Dnickname%26is_all%3D1&_t=FM_152852421757926");
		get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		get.setHeader("Cookie", "SINAGLOBAL=6138753871697.622.1503576509910; un=17665306021; wb_timefeed_6461425565=1; wb_view_log=1920*10801; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5SGVz7z6nTxSgvaShZ-NJc5JpX5K2hUgL.FoqXSo2Xeo-fSo-2dJLoIE-LxKqL1-eLBKnLxKML1KeL1-eLxK-LBKeLBoeLxK-LB-BL1KWk; wvr=6; SCF=Asv1qKaJY8uvIkTDubOAou7WO0Hb3vO1vT4PYDZMalR9sg0bgATCZJUumOx-ubxvEoyMfGa99tFiKYEi86f3RlA.; SUB=_2A252Hx0WDeRhGeBK7VMV8ivJzTmIHXVVbQnerDV8PUNbmtAKLVrikW9NR7AbNFlRHPgEOaUmq2GCM7ZjbuzqlVET; SUHB=0LcSEjvtrZNZWs; ALF=1560060102; SSOLoginState=1528524102; YF-Ugrow-G0=8751d9166f7676afdce9885c6d31cd61; YF-V5-G0=1da707b8186f677d9e4ad50934b777b3; _s_tentry=www.sina.com.cn; UOR=,,www.sina.com.cn; Apache=975997128345.667.1528524095193; ULV=1528524095198:128:12:9:975997128345.667.1528524095193:1528477169017; YF-Page-G0=7b9ec0e98d1ec5668c6906382e96b5db");
		get.setHeader("Referer", "https://weibo.com/wflanker?refer_flag=0000015010_&from=feed&loc=nickname&is_all=1");
		get.setHeader("Upgrade-Insecure-Requests", "1");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

		CloseableHttpResponse response = null;
		try {
			
			response = MyHttpClient.executeRequest(get);
			
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
