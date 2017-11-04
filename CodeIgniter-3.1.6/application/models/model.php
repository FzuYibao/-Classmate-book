<?php
/**
*  ./application/models/test_m.php
*/
class Model extends CI_Model
{

    function Model(){  
        parent::__construct(); 
        $this->load->database();   
    }  

    // function select($name)  
    // {         
    //     $this->db->where('username', $name); //  WHERE name = 'Joe'
    //     $this->db->select('username, password');   //SELECT username, password
    //     $query = $this->db->get('user');   //SELECT * FROM user
    //     return $query->result();  
    // } 

    // function selectAll()  
    // {
    //     $query = $this->db->get('user');   //SELECT * FROM user
    //     return $query->result();  
    // } 

    // function insert()  
    // {         
    //     $data = array(
    //         'username' => 'me',
    //         'password' => '456789',
    //         'sex' => 'man',
    //         'age' => '29',
    //     );

    //     $this->db->insert('user', $data); 
    // }  
    
    // function update($username)
    // {
    //     $data = array(
    //         'password' => '456789',
    //     );
    //     $this->db->where('username', $username);
    //     $this->db->update('user', $data);
    // }
      
    // function delete($username){
    //     $this->db->where('username',$username);
    //     $this->db->delete('user');
    // }

    // function select($name)  
    // {         
    //     $this->db->where('name', $name); //  WHERE name = 'Joe'
    //     $this->db->select('name, password');   //SELECT username, password
    //     $query = $this->db->get('student');   //SELECT * FROM user
    //     return $query->result();  
    // } 

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