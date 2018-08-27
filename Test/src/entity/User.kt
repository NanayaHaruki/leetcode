package entity

import com.google.gson.annotations.Expose

class User {
    @Expose
    val args4:String="12"

    @Expose
    val list = listOf<Int>()
}

open class A(val id:Int,val name:String)