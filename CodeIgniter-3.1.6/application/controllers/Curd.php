
<?php 
if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Curd extends CI_Controller {


       public function __construct()
    {
        parent::__construct();
        $this->load->library('form_validation');

    }
   
  function insert(){  
  
    $this->load->model('curd_model'); 

    $this->form_validation->set_rules('name','用户名','required');
    $this->form_validation->set_rules('password','密码','required');
    $this->form_validation->set_rules('address','地址','required');
    $this->form_validation->set_rules('weichat','微信','required');
    $this->form_validation->set_rules('email','邮箱','required');
    $this->form_validation->set_rules('qq','qq','required');
    $this->form_validation->set_rules('personality','个人信息','required');
    $this->form_validation->set_rules('phone','电话号码','required');


    if($this->form_validation->run()==false)
    {   
        $message = "注册失败，请确认已填写所有信息";
        echo_json($message);
    }
    else
    {

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    if($this->curd_model->insert($name, $address, $phone, $weichat, $email, $qq, $personality, $password)){
        $message = "注册成功";
        echo_json($message);
    }
        
    }

      
}  


	function update(){  
  
    $this->load->model('curd_model'); 

    $this->form_validation->set_rules('name','用户名','required');
    $this->form_validation->set_rules('password','密码','required');
    $this->form_validation->set_rules('address','地址','required');
    $this->form_validation->set_rules('weichat','微信','required');
    $this->form_validation->set_rules('email','邮箱','required');
    $this->form_validation->set_rules('qq','qq','required');
    $this->form_validation->set_rules('personality','个人信息','required');
    $this->form_validation->set_rules('phone','电话号码','required');





	if($this->form_validation->run()==false)
    {   
        $message = "更新失败，请确认信息的完备性";
        echo_json($message);
    }else{
    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    if ($this->curd_model->update($name, $address, $phone, $weichat, $email, $qq, $personality, $password )) {
        $message = "更新成功";
        echo_json($message);
    }
        
        
    }

      
}

function selectAll(){  
  
    $this->load->model('curd_model'); 

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);


	$data['select'] = $this->curd_model->selectAll();

    echo_json($data['select']);
  
}

function delete(){  
  
    $this->load->model('curd_model'); 

    $name = $this->input->post('name',true);


    $this->curd_model->delete($name);

    $message = "删除成功";
    echo_json($message);
}
} 





/*

    $this->form_validation->set_rules('username','用户名','required');
        $this->form_validation->set_rules('password','密码','required');
        if($this->form_validation->run()==false)
        {
            $data=array(
                            'url' => site_url('admin/privilege/login'),
                            'message' => validation_errors(),
                            'wait'  => '2'

                        );
                    $this->load->helper('form');
                    $this->load->view('admin/message.html',$data);
        }else
        {

                #获取表单数据并进行处理   s输入类的使用 （systerm中自动载入）
                $captcha=$this->input->post('captcha');
                $code=strtolower($this->session->userdata('code'));

                if($captcha===$code)
                {
                    $username=$this->input->post('username',true);
                    $password=$this->input->post('password',true);



*/ 
?>  