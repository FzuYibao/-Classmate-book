<?php
defined('BASEPATH') OR exit('No direct script access allowed');
/**

  打印不转义中文的json

  @param [array] $data

 */

function echo_json($data) {

       echo json_encode ( $data, JSON_UNESCAPED_UNICODE );

}

?>