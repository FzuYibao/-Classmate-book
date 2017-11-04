<?php

defined('BASEPATH') OR exit('No direct script access allowed');
class Curd_model extends CI_Model
{

       public function __construct()
    {
        parent::__construct();
    }

    function selectAll()  
    {
        $query = $this->db->get('student');   //SELECT * FROM user
        return $query->result();  
    } 

    function insert($name, $address, $phone, $weichat, $email, $qq, $personality, $password )  
    {         
        $data = array(
            'name' => $name,
            'address' => $address,
            'phone' => $phone,
            'weichat' => $weichat,
            'email' => $email,
            'qq' => $qq,
            'personality' => $personality,
            'password' => $password,
        );

        $this->db->insert('student', $data); 
    }  
    
    function update($name, $address, $phone, $weichat, $email, $qq, $personality, $password )
    {
        $data = array(
            'name' => $name,
            'address' => $address,
            'phone' => $phone,
            'weichat' => $weichat,
            'email' => $email,
            'qq' => $qq,
            'personality' => $personality,
            'password' => $password,
        );
        $this->db->where('name', $name);
        $this->db->update('student', $data);
    }
      
    function delete($name){
        $this->db->where('name',$name);
        $this->db->delete('student');
    }
}  
?>  