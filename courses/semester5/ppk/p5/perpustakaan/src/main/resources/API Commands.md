{ "jsonrpc": "2.0", "method": "createBook", "params": {"title":"Seminggu bersama zacky", "author":"Jeki Heta", "description":"mengenal zacky heta sang orang baik part II"}, "id": "2"
}

Request. { "jsonrpc": "2.0", "method": "getBooks", "params": {}, "id": "2"
}

a) Menambahkan Member
- URI: http://localhost:8080/member
- Method: POST
- Data:
  {"memberID": "111", "name": "Ahmad","address":"Jalan Merdeka No. 1","phoneNumber":"082193223xxx"}
- Headers: Content-Type:application/json

b) Menampilkan semua Member
- URI: http://localhost:8080/member
- Method: GET
  c) Mendapatkan data Member berdasarkan ID
- URI: http://localhost:8080/member/1
- Method: GET
  d) Mengubah data Member
- URI: http://localhost:8080/member/1
- Method: PUT
- Data:
  {"memberID": "111", "name": "AhmadAnas","address": "Jalan Merdeka No.2","phoneNumber": "082193223xxx"}
- Headers: Content-Type:application/json
  e) Mengubah nomor telepon Member
- URI: http://localhost:8080/member/1
- Method: PATCH
- Data: {"phoneNumber": "082193223111"}
- Headers: Content-Type:application/json
  f) Mencari data Member berdasarkan memberID
  60- URI:
  http://localhost:8080/member/search/findByMemberID?member_id=111
- Method: GET
  g) Mencari data Member berdasarkan nama
- URI:
  http://localhost:8080/member/search/findByName?name=Ahmad%20Anas
- Method: GET
  h) Menghapus Member
- URI: http://localhost:8080/member/1
- Method: DELETE