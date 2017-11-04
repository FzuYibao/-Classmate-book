
<?php 
if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Controllers extends CI_Controller {

//     public function insert(){
//         $this->load->model('test_m');
//         $arr = array('usid'=>1,'uname'=>'deng1','upass'=>'1234');
//         $this->test_m->user_insert($arr);
//     }

//     public function update(){
//         $this->load->model('test_m');
//         $arr = array('usid'=>22,'uname'=>'deng222','upass'=>'1233333');
//         $this->test_m->user_update(2,$arr);
//     }

//     public function delete(){
//         $this->load->model('test_m');
//         $this->test_m->user_delete(22);
//     }

//     public function select()
//     {
//         $this->load->model('test_m');
//         $arr = $this->test_m->user_select(1);
//         print_r($arr);
//         echo $arr[0]->usid;

//     }
// }

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */

 function Controllers(){  
    parent::__construct();  
  }  
   
  function insert(){  
  
    $this->load->model('model'); 

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    // $this->model->update($name, $address, $phone, $weichat, $email, $qq, $personality, $password );
    $this->model->insert($name, $address, $phone, $weichat, $email, $qq, $personality, $password);
    // $this->model->delete($name);

	// $data['select'] = $this->model->selectAll();

    // var_dump($data['select']);
    // $this->load->view('views',$data);  //将数据传到views下的views.php文件，并展示出来
    $message = "插入成功";
    echo_json($message);
      
}  
	function update(){  
  
    $this->load->model('model'); 

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    $this->model->update($name, $address, $phone, $weichat, $email, $qq, $personality, $password );
    // $this->model->delete($name);

    // $data['name'] = $this->model->select('jz');  
	$data['select'] = $this->model->selectAll();

	$message = "修改成功";
    echo_json($message);
    // var_dump($data['select']);
    // $this->load->view('views',$data);  //将数据传到views下的views.php文件，并展示出来
      
}
function selectAll(){  
  
    $this->load->model('model'); 

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    // $this->model->update($name, $address, $phone, $weichat, $email, $qq, $personality, $password );
    // $this->model->delete($name);

    // $data['name'] = $this->model->select('jz');  
	$data['select'] = $this->model->selectAll();

    var_dump($data['select']);
    // echo_json($data['select']);
    // $this->load->view('views',$data);  //将数据传到views下的views.php文件，并展示出来
      
}
function delete(){  
  
    $this->load->model('model'); 

    $name = $this->input->post('name',true);
    $address = $this->input->post('address',true);
    $phone = $this->input->post('phone',true);
    $weichat = $this->input->post('weichat',true);
    $email = $this->input->post('email',true);
    $qq = $this->input->post('qq',true);
    $personality = $this->input->post('personality',true);
    $password = $this->input->post('password',true);

    // $this->model->update($name, $address, $phone, $weichat, $email, $qq, $personality, $password );
    $this->model->delete($name);

    // $data['name'] = $this->model->select('jz');  
	// $data['select'] = $this->model->selectAll();

    // var_dump($data['select']);
    // $this->load->view('views',$data);  //将数据传到views下的views.php文件，并展示出来
    $message = "删除成功";
    echo_json($message);
}
}  
?>  