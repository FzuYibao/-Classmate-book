<?php

defined('BASEPATH') OR exit('No direct script access allowed');
use \Firebase\JWT\JWT;
include('D:wamp64/www/yibao/third_party/JWT.php');


class Auth extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function login()
	{
		// $this->load->view('welcome_message');
		// $this->load->helper('render');
		// $data = array(
		// 	'user_name' => '反反复复'

		// );
// echo 'ddd';
		$sno = $this->input->post('sno',true);
		$password = $this->input->post('password',true);
		if(isset($sno) && isset($password))
		{
			$this->load->helper('post_login');
			$user=post_login($sno,$password);
			if($user==false)
			{
				echo '密码错误，请重新登录，或与学院教学办联系！';
			}else
			{
				print_r($user);
			}

		}


		$key = "example_key";
		$token = array(
		    "iss" => "http://example.org",
		    "aud" => "http://example.com",

		    "iat" => time(),
		    "nbf" => time()+13570000
		    // "iat" => 1356999524,
		    // "nbf" => 1357000000

		    // "iat"       => $_SERVER['REQUEST_TIME'],

		);

		/**
		 * IMPORTANT:
		 * You must specify supported algorithms for your application. See
		 * https://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-40
		 * for a list of spec-compliant algorithms.
		 */


		echo $jwt = JWT::encode($token, $key);
		// echo site_url()."<br>";
		// echo base_url();


		// echo_json($data);

	}
}
