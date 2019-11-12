package com.aaa.store08.config;

public class AlipayConfig {
	//APPID
	public static String app_id = "2016093000632172";
	//生成的私钥
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHV5g0l+XglhTHx++/P/HS1QZMQBAdY4jfdiY4lr4mKqXg8r0UwwUxYrElBtoVg/FBQxc0MzLuCHTGeT0wyy+sR+kyN3lnNGsQ92Cxn50G9BbvUUKHg2PlewFWYuCqaYxEMPQiZA9JJ47YnUZ6+sakZTuoRGdpLLt/nndS5q9qgb+L8PBrLkYNXeJ7kqolynOOx0MzkqI3w3H53LcRkt7A4duvjjlMLojBqN/xh8msacfOFtM2bhK0jHykt25Dy6RxyksNZ2yQ+QYXlr9Llt5IfLmzcvY15Ns0tnSWiyEwmC41hctxGMURY+1hZWulg1q2NWk6UYrgXwe8p47yvkxxAgMBAAECggEAQOk6Dr9reTOB8+9ohQleKggRZTC0iePbGZHI8wsZV6TMuf6xwOtn6i+zVlba8ca+RtauolKL8q4Lk8VCG8zXqIE0zujcSStSzmhW79nlrhgTh+QpTGUv3DgKhCwYJKNKqsnvzS7ARg267RlBXGo6K06CNknYbxENPD/8ar5JE4NDNjGXXLbV5D0YPb5erCktmO7YHnbkglXkIE/wTbOYXfC5XtGPjq0nh9DP7x3QZ+kC22cF58g47pwB0IKi+piTN0zkldAFlHbik29qblbgm5X/KtYKcbcA/qO2F2jPrnIUKbk/paCG5faWpdbSNsMuid921j47Cr6GlaUhusiiAQKBgQDSuZOHZ2XtScOea3f7sZ7vXWxQqEFepQ4G6wfcXGc+PG+uVnGHXCzpkFKBuFGzIk5dnlLqOb5Ipm88oS6+d+5veuKkNcnBtkJ70Hmvr0xQbuueCSZCK9ZfBSzsQLq5sALDfuqvjjJvYX/tqplmtusoMuR9fOarOp6/0JYOHn4h+QKBgQCka8T2vniCPmX5TiUBYJ/OdDwerVZSazRKXS6BM6wyUz5yzwWDN+aYs6XLwI9KjYyBBUSVZqV9HWLExBmyXCgnm8ABQenwJPSDBsmtkXbvLHURfnjWHj5JtWVEWf43fOupsE6J8eJjcoico9tlUXVLn0jV7l+4rQkuJr5/uN2cOQKBgCr+F75pdx85jIK21GzyqUWW3vF50pR3wmvg6eKoq5vEAtkj49fFE5i3jE3RCEIu/qQVGD+Xdl4mLs3E6N+NYoU2IiV0n+w4vkm6mAkjD8PdTY8ZuMeJYBxU1vyAnFgkM/wk2cblkR6uWsZnpxKQwVubPojnwbwvopHqAaNxzzQpAoGATQvLEiyS38VJl5dMs+aJO/8vpNho2NoveKFNh3GlQTfMzZPA64ooXmngSSgEfVTzAApt5uxgo84/WCDkQbX5gwXy5SPz8Xn/sd5eZx0A9HaKrRXsnbkySuvbdjoNbAb3j150jyNviFZFOdF2n3WaV0NeqBC5fhpncN7q6YLBJdECgYEA0U7M2WC9wsgVz9QMPf0R2DeMsh9G2oEBP9T/YWksCOHtGnqSLHG9dGkXSZz8lk3L9T49A/uBi07ZOh60kzAsNIns3LS0dipgCzT1meIelTWSnDSrmbVFGhOiibbJSmfaFu+y6F7XmhfqcM2RNclXDrx2IARhFXX80ZAlNr1U8i0=";
	//Controller Mapping:得放到服务器上，且使用域名解析 IP
	//public static String notify_url = "http://www.xxx.com/xxxxx /pay/notifyUrl";
	public static String notify_url = "http://localhost:8080/xm/hello/paly"; //用不到的话可以随意写
	//Controller Mapping:得放到服务器上，且使用域名解析 IP /pay/return_url"是返回的页面
	public static String return_url = "http://localhost:8080/xm/member/success";//支付成功具体跳转路径，这个非常重要
	public static String returns_url = "http://localhost:8080/xm/order/success";
	//开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
	public static String url = "https://openapi.alipaydev.com/gateway.do";
		
	public static String charset = "UTF-8";
		
	public static String format = "json";
	//开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
	//公匙
	public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1eYNJfl4JYUx8fvvz/x0tUGTEAQHWOI33YmOJa+Jiql4PK9FMMFMWKxJQbaFYPxQUMXNDMy7gh0xnk9MMsvrEfpMjd5ZzRrEPdgsZ+dBvQW71FCh4Nj5XsBVmLgqmmMRDD0ImQPSSeO2J1GevrGpGU7qERnaSy7f553UuavaoG/i/Dway5GDV3ie5KqJcpzjsdDM5KiN8Nx+dy3EZLewOHbr445TC6Iwajf8YfJrGnHzhbTNm4StIx8pLduQ8ukccpLDWdskPkGF5a/S5beSHy5s3L2NeTbNLZ0loshMJguNYXLcRjFEWPtYWVrpYNatjVpOlGK4F8HvKeO8r5McQIDAQAB";
		
	public static String signtype = "RSA2";

}
