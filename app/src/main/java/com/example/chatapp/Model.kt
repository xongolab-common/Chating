package com.example.chatapp



class User (  var name: String? = null,
              var email: String? = null,
              var uid: String? = null
)

class Message (
    var message: String? = null,
    var senderId: String? = null
)
