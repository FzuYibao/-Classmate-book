<?php

defined('BASEPATH') OR exit('No direct script access allowed');

function post_login($sno,$password)
{

			header('content-type:text/html;charset=utf-8');    


			$post_data="muser=".$sno."&passwd=".$password;


			$url = "http://59.77.226.32/logincheck.asp";
			$User_Agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0";
			$Referer = "http://jwch.fzu.edu.cn/";

			$ch = curl_init();
			curl_setopt($ch, CURLOPT_URL, $url);		//设置URL
			curl_setopt($ch, CURLOPT_HEADER, true);		//设置显示响应头
			curl_setopt($ch,CURLOPT_USERAGENT,$User_Agent); //设置代理浏览器
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); //把CRUL获取的内容赋值到变量,不直接输出
			curl_setopt($ch,CURLOPT_REFERER,$Referer);	//设置来源网站
			curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);//设置重定向
			curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);//设置参数
			$content = curl_exec($ch);
			curl_close($ch);

			// echo $content;

			$header = explode(PHP_EOL, $content);

			// print_r($header);
			foreach ($header as $each) {
				# code...
				// echo $each."<br>";
				// $preg = "/Location:\s+http://59.77.226.35/default.aspx?id=(.*)/is";


				$preg_id = "/default.aspx\?id=(.*)/is";
				// : http:\/\/59.77.226.35\/default.aspx?id=(.*?)/is

				if(preg_match_all($preg_id, $each, $arr_id))
				{
					// echo $each;
					// var_dump($arr);
					$id = $arr_id[1][0];
				}

				$preg_cookie = "/Set-Cookie:\s+(.*)/is";

				if(preg_match_all($preg_cookie, $each, $arr_cookie))
				{
					// echo $each;
					// var_dump($arr_cookie);
					// $id = $arr[1][0];
					// echo $arr_cookie[1][0];
					$cookie = $arr_cookie[1][0];

				}


			}

			// echo $id."<br>".$cookie;

					if(isset($id))
					{


							$info_url = "http://59.77.226.35/jcxx/xsxx/StudentInformation.aspx?id=".$id;
							$User_Agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0";
							$Referer = "http://59.77.226.35/left.aspx?id=".$id;

							$ch = curl_init();
							curl_setopt($ch, CURLOPT_URL, $info_url);			//设置URL
							curl_setopt($ch, CURLOPT_COOKIE, $cookie);		//设置上面取得的cookies值
							curl_setopt($ch,CURLOPT_USERAGENT,$User_Agent); //设置代理浏览器
							curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); //把CRUL获取的内容赋值到变量,不直接输出
							curl_setopt($ch,CURLOPT_REFERER,$Referer);		//设置来源网站
							$content = curl_exec($ch);
							curl_close($ch); 

							$content=strip_tags($content);//去除html标签
							// $content = iconv("GB2312","UTF-8//IGNORE",$content);

							$user = array();
							$user['sno'] = $sno;

							$preg_name = "/姓名(.*?)姓名/is";
							if(preg_match_all($preg_name, $content, $array))
							{
								// var_dump($array);
								$str = $array[1][0];
								$str = str_replace(PHP_EOL, '', $str);  
								$str = trim($str);
								$user['name'] = $str;

							}

							$preg_phone = "/本人电话\s+(.*?)\s+E-mail/is";
							if(preg_match_all($preg_phone, $content, $array))
							{
								// var_dump($array);
								$user['phone'] = $array[1][0];

							}

							// var_dump($user);
							return $user;


							// echo json_encode($user, JSON_UNESCAPED_UNICODE);
							// echo_json($user);

					}else{
						// echo "密码错误，请重新登录，或与学院教学办联系！";
						return false;
					}

}

?>
